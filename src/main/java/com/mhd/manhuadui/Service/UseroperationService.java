package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Pojo.Feedback;
import com.mhd.manhuadui.Pojo.User;

import java.awt.*;
import java.util.List;

public interface UseroperationService {

    /**
     * 显示用户列表
     */
     List<User> list();
    /**
     * 删除用户
     */
     int delete(int id);
    /**
     * 模糊查询搜索用户
     */
     List<User> like(String inputtext);
    /**
     * 倒序显示反馈列表
     */
     List<Feedback> Feedbacklist();
    /**
     * 查看反馈内容
     */
     String Text(int id);
}
