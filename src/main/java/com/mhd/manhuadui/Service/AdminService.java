package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Pojo.Admin;
import com.mhd.manhuadui.Pojo.Comicrank;
import org.omg.PortableInterceptor.AdapterNameHelper;

import java.util.List;

/**
 * create time 2020-02-01
 */
public interface AdminService {
    /**
     * 管理员登录验证
     */

    Admin adminlogin(Admin admin);

    /**
     * 获取数据库版本号
     */
    String getMysql();
    /**
     * 统计用户数量
     */
    int getUsernumber();
    /**
     * 统计漫画的数量
     */
    int getMhinfonumber();
}
