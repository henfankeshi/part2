package com.mhd.manhuadui.Dao;

import com.mhd.manhuadui.Pojo.Feedback;
import com.mhd.manhuadui.Pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * create time 2020-02-01
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 用户注册
     */
     @Insert("insert into t_user values(null,#{username},#{userpassword})")
      int save(User user);

    /**
     * 根据用户名进行查询
     * @param user
     * @return
     */
     @Select("select * from t_user where username=#{username}")
      List<User> selectByUsername(User user);
    /**
     * 根据id进行查询
     */
      @Select("select * from t_user where u_id = #{u_id}")
      List<User> selectByU_id(int u_id);

    /**
     * 根据用户名密码进行查询
     */
      @Select("select * from t_user where username = #{username} and userpassword = #{userpassword}")
      List<User>  selectByUser(User user);
    /**
     * 修改用户名
     */
      @Update("update t_user set username = #{username} where u_id = #{u_id}")
      int updateUsername(User user);
    /**
     * 修改密码
     */
      @Update("update t_user set userpassword = #{userpassword} where u_id = #{u_id}")
      int updateUserpassword(User user);
    /**
     * 根据id查询密码/用户名
     */
       @Select("select userpassword from t_user where u_id = #{u_id}")
       String selectbyUserPassword(int id);
    /**
     * 根据id查询用户名
     */
       @Select("select username from t_user where u_id = #{u_id}")
       String selectbyUserUsername(int id);
    /**
     * 提交反馈
     */
      @Insert("INSERT INTO t_feedback(u_id,textfield,createtime,username) VALUE(#{u_id},#{textfield},#{createtime},#{username})")
      int insertfeedback(Feedback feedback);
}
