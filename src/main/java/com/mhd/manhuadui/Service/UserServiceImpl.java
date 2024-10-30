package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Dao.UserMapper;
import com.mhd.manhuadui.Pojo.Feedback;
import com.mhd.manhuadui.Pojo.User;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public void SaveUser(User user) {
         userMapper.save(user);
    }

    @Override
    public List<User> getU_id(int id) {
        return userMapper.selectByU_id(id);
    }

    @Override
    public List<User> getUsername(User user) {
        return userMapper.selectByUsername(user);
    }

    @Override
    public List<User> getUser(User user) {
        return userMapper.selectByUser(user);
    }

    @Override
    public void updateUsername(User user) {
         userMapper.updateUsername(user);
    }

    @Override
    public void updatePassword(User user) {
         userMapper.updateUserpassword(user);
    }

    @Override
    public String getPassword(int id) {
          return userMapper.selectbyUserPassword(id);
    }

    @Override
    public String getUsername(int id) {
        return userMapper.selectbyUserUsername(id);
    }

    @Override
    public void Insertfeedback(Feedback feedback) {
           userMapper.insertfeedback(feedback);
    }


}
