package com.mhd.manhuadui.Dao;

import com.mhd.manhuadui.Pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 *  create time 2020-02-01
 */
@Mapper
@Repository
public interface AdminMapper {
    /**
     * 管理员登录验证
     */
    @Select("select * from t_admin where adminname = #{adminname} and adminpassword = #{adminpassword}")
    Admin selectnameandpassword(Admin admin);
    /**
     * 获取MySql的版本
     */
    @Select("select concat(@@version_comment , ' ' , @@version) from dual")
    String selectversion();
    /**
     * 统计用户数量
     */
    @Select("SELECT count(*) from t_user ")
    int selectusercount();
    /**
     * 统计漫画的数量
     */
    @Select("SELECT count(*) from t_mhinfo")
    int selectmhinfocount();

}
