package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Dao.UseroperationMapper;
import com.mhd.manhuadui.Pojo.Feedback;
import com.mhd.manhuadui.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseroperationServiceImpl implements UseroperationService{

    @Autowired
    UseroperationMapper useroperationMapper;
    @Override
    public List<User> list() {
        return useroperationMapper.selectList();
    }

    @Override
    public int delete(int id) {
        return useroperationMapper.deleteUser(id);
    }

    @Override
    public List<User> like(String inputtext) {
        return useroperationMapper.selectLike(inputtext);
    }

    @Override
    public List<Feedback> Feedbacklist() {
        return  useroperationMapper.feedbacklist();
    }

    @Override
    public String Text(int id) {
        return useroperationMapper.text(id);
    }
}
