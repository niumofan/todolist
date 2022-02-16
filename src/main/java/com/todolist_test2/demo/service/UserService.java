package com.todolist_test2.demo.service;

import com.todolist_test2.demo.component.UserContext;
import com.todolist_test2.demo.dao.UserDao;
import com.todolist_test2.demo.dto.user.ImageDTO;
import com.todolist_test2.demo.dto.user.UpdateUserDTO;
import com.todolist_test2.demo.dto.user.UserInfo;
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
import sun.misc.BASE64Encoder;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.*;

/**
 * @author nmf
 * @date 2021年11月02日 10:47
 */
@Service
public class UserService {

    private static final int MAX_LENGTH = 1024 * 1024;

    private UserMapper userMapper;

    private UserDao userDao;

    private UserContext userContext;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setUserContext(UserContext userContext) {
        this.userContext = userContext;
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

    public UserInfo updateUser(UpdateUserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userMapper.updateByPrimaryKeySelective(user);
        return userDao.loadUserById(userDTO.getId());
    }

    public UserInfo getUser() {

        return userDao.loadUserByUsername(userContext.getUsername());

    }

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
            suffix = ".jpeg";
        } else if ("data:image/jpg;".equalsIgnoreCase(format)){
            //data:image/x-icon;base64,base64编码的icon图片数据
            suffix = ".jpg";
        } else if ("data:image/x-icon;".equalsIgnoreCase(format)){
            //data:image/x-icon;base64,base64编码的icon图片数据
            suffix = ".ico";
        } else if ("data:image/gif;".equalsIgnoreCase(format)){
            //data:image/gif;base64,base64编码的gif图片数据
            suffix = ".gif";
        } else if ("data:image/png;".equalsIgnoreCase(format)){
            //data:image/png;base64,base64编码的png图片数据
            suffix = ".png";
        } else {
            return "上传图片格式不合法";
        }

        String tempFileName="" + userId + suffix;
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
            String relativePath = "/static/headIcon/" + tempFileName;
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

    public String downloadImage() throws IOException {

        /* 获取图片相对路径 */
        Integer userId = userContext.getUserId();
        String imagePath = userDao.getImagePath(userId);
        String dir = new ApplicationHome(getClass()).getSource().getParentFile().toString();

        File file = new File(dir + imagePath);
        String prefix = getBase64Prefix(file);

        Base64.Encoder encoder = Base64.getEncoder();
        byte[] buffer = new byte[MAX_LENGTH];
        InputStream input = new BufferedInputStream(new FileInputStream(dir + imagePath));
        if (input.available() >= MAX_LENGTH) {
            input.close();
            throw new IOException("读取头像文件失败");
        }
        int len = input.read(buffer);
        buffer = Arrays.copyOfRange(buffer, 0, len);
        if (len == MAX_LENGTH) {
            input.close();
            throw new IOException("读取头像文件失败");
        }
        input.close();
        byte[] ans = encoder.encode(buffer);
        return prefix + (new String(ans));
    }

    private String getBase64Prefix(File file) throws IOException {
        String name = file.getName();
        String format = name.substring(name.lastIndexOf(".") + 1);

        String prefix;
        if ("jpeg".equalsIgnoreCase(format)) {
            prefix = "data:image/jpeg;";
        } else if ("jpg".equalsIgnoreCase(format)) {
            prefix = "data:image/jpg;";
        } else if ("ico".equalsIgnoreCase(format)) {
            prefix = "data:image/x-icon;";
        } else if ("png".equalsIgnoreCase(format)) {
            prefix = "data:image/png;";
        } else if ("gif".equalsIgnoreCase(format)) {
            prefix = "data:image/gif;";
        } else {
            throw new IOException("头像格式不正确，请重新上传头像");
        }
        prefix += "base64,";
        return prefix;
    }
}
