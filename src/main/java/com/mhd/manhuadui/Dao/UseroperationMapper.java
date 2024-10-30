package com.mhd.manhuadui.Dao;

import com.mhd.manhuadui.Pojo.Feedback;
import com.mhd.manhuadui.Pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UseroperationMapper {
    /**
     * 显示用户列表
     */
    @Select("select * from t_user")
    List<User> selectList();
    /**
     * 删除用户
     */
    @Delete("delete from t_user where u_id = #{u_id}")
    int deleteUser(int id);
    /**
     * 模糊查询搜索用户
     */
    @Select("SELECT * from t_user where username like concat('%',#{0},'%') or u_id like concat('%',#{0},'%')")
    List<User> selectLike(String inputtext);
    /**
     * 倒序显示反馈列表
     */
     @Select("select t_feedback.id,t_feedback.u_id,t_feedback.createtime,t_feedback.username from t_user,t_feedback where t_feedback.u_id = t_user.u_id ORDER BY createtime  DESC")
     List<Feedback> feedbacklist();
    /**
     * 查看反馈内容
     */
     @Select("SELECT t_feedback.textfield from t_feedback where id = #{id}")
     String text(int id);
}
