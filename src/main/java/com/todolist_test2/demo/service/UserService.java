package com.todolist_test2.demo.service;

import com.todolist_test2.demo.dao.UserDao;
import com.todolist_test2.demo.dto.user.ImageDTO;
import com.todolist_test2.demo.dto.user.UserRegisterDTO;
import com.todolist_test2.demo.mbg.mapper.UserMapper;
import com.todolist_test2.demo.mbg.model.User;
import com.todolist_test2.demo.mbg.model.UserExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author nmf
 * @date 2021年11月02日 10:47
 */
@Service
public class UserService {

    private UserMapper userMapper;

    private UserDao userDao;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public User loadUserByUsername(String username) {

        if (username == null || "".equals(username)) {
            return null;
        }

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList == null || userList.size() == 0) {
            throw new RuntimeException("用户不存在");
        }

        return userList.get(0);
    }

    public Set<String> getRolesOfUser(User user) {
        List<String> permissions = userDao.selectRolesOfUser(user.getId());
        return new HashSet<>(permissions);
    }

    @Transactional
    public int registerUser(UserRegisterDTO userRegisterDTO) {
        String username = userRegisterDTO.getUsername();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        if (userMapper.selectByExample(userExample).size() > 0) {
            throw new RuntimeException("用户名已存在");
        }

        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getRepeatPassword())) {
            throw new RuntimeException("两次密码不一致");
        }

        User user = new User();
        BeanUtils.copyProperties(userRegisterDTO, user);
        user.setPassword(user.getPassword());
        user.setAccountNonExpired((byte) 1);
        user.setAccountNonLocked((byte) 1);
        user.setEnabled((byte) 1);
        user.setCredentialsNonExpired((byte) 1);

        Date curTime = new Date();
        user.setCreateTime(curTime);
        user.setUpdateTime(curTime);
        user.setLastLoginTime(curTime);

        return userMapper.insertSelective(user);
    }

    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

//    public User getUser()

    public String uploadImage(ImageDTO imageDTO) {

        String base64Data = imageDTO.getBase64Image();
        Integer userId = imageDTO.getUserId();

        String format = "";  // base64格式前头
        String data = "";  // 实体部分数据
        if(base64Data==null||"".equals(base64Data)){
            return "上传失败，上传图片数据为空";
        }else {
            String [] d = base64Data.split("base64,");//将字符串分成数组
            if(d.length == 2){
                format = d[0];
                data = d[1];
            }else {
                return "上传失败，数据不合法";
            }
        }
        String suffix = "";  // 图片后缀，用以识别哪种格式数据

        //data:image/jpeg;base64,base64编码的jpeg图片数据
        if("data:image/jpeg;".equalsIgnoreCase(format)){
            suffix = ".jpg";
        }else if("data:image/x-icon;".equalsIgnoreCase(format)){
            //data:image/x-icon;base64,base64编码的icon图片数据
            suffix = ".ico";
        }else if("data:image/gif;".equalsIgnoreCase(format)){
            //data:image/gif;base64,base64编码的gif图片数据
            suffix = ".gif";
        }else if("data:image/png;".equalsIgnoreCase(format)){
            //data:image/png;base64,base64编码的png图片数据
            suffix = ".png";
        }else {
            return "上传图片格式不合法";
        }

        String tempFileName="" + userId + suffix;
        String imgFilePath = "classpath:/static/headIcon/" + tempFileName;  //新生成的图片
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(data);
            for (int i = 0; i < b.length; i++) {
                if (b[i] < 0) {
                    //调整异常数据
                    b[i] += 256;
                }
            }
            String dir = new ApplicationHome(getClass()).getSource().getParentFile().toString();
            String relativePath = "/static/headIcon" + tempFileName;
            System.out.println();
            OutputStream out = new FileOutputStream(dir + relativePath);
            out.write(b);
            out.flush();
            out.close();

            User user = new User();
            user.setId(userId);
            user.setHeadIcon(relativePath);
            userMapper.updateByPrimaryKeySelective(user);
            return null;
        } catch ( IOException e) {
            return "上传图片失败";
        }
    }
}
