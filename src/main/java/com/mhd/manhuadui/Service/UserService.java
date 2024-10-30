package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Pojo.Feedback;
import com.mhd.manhuadui.Pojo.User;

import java.util.List;

public interface UserService {
     /**
      *用户注册
      */
      void SaveUser(User user);
    /**
     * 用户登录
     */
      List<User> getU_id(int id);
    /**
     * 根据用户名进行查询
     */
      List<User> getUsername(User user);
    /**
     * 根据用户名密码进行查询
     */
      List<User> getUser(User user);
    /**
     * 根据用户id修改用户名
     */
      void updateUsername(User user);
    /**
     * 根据用户Id修改密码
     */
      void updatePassword(User user);
    /**
     * 根据id查询密码
     */
      String getPassword(int id);
    /**
     * 根据id查询用户名
     */
     String getUsername(int id);
    /**
     * 提交反馈
     */
      void Insertfeedback(Feedback feedback);

}
