package com.todolist_test2.demo.service;

import com.todolist_test2.demo.dao.FocusDao;
import com.todolist_test2.demo.dto.focus.AddFocusDTO;
import com.todolist_test2.demo.dto.focus.QueryFocusDTO;
import com.todolist_test2.demo.mbg.mapper.FocusMapper;
import com.todolist_test2.demo.mbg.model.Focus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nmf
 * @date 2022年01月26日 12:20
 */
@Service
public class FocusService {

    @Autowired
    private FocusMapper focusMapper;

    @Autowired
    private FocusDao focusDao;

    public Focus addFocus(AddFocusDTO focusDTO) {
        Focus focus = new Focus();
        BeanUtils.copyProperties(focusDTO, focus);
        focus.setDuration((short)((focusDTO.getEndTime().getTime() - focus.getStartTime().getTime()) / 1000));
        focusMapper.insert(focus);
        return focus;
    }

    public List<Focus> queryFocusOfTodo(QueryFocusDTO focusDTO) {
        return focusDao.queryFocusOfTodo(focusDTO);
    }

    public List<Focus> queryFocusOfCategory(QueryFocusDTO focusDTO) {
        return focusDao.queryFocusOfCategory(focusDTO);
    }

    public List<Focus> queryFocusOfUser(QueryFocusDTO focusDTO) {
        return focusDao.queryFocusOfUser(focusDTO);
    }
}
