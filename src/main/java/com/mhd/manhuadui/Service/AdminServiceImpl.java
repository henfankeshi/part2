package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Dao.AdminMapper;
import com.mhd.manhuadui.Dao.ComicrankMapper;
import com.mhd.manhuadui.Pojo.Admin;
import com.mhd.manhuadui.Pojo.Comicrank;
import com.mhd.manhuadui.Util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create time 2020-02-01
 * 管理员验证登录
 */
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminMapper adminMapper;
    ComicrankMapper comicrankMapper;

    @Override
    public Admin adminlogin(Admin admin) {
        Admin admin1 = adminMapper.selectnameandpassword(admin);
        return admin1;
    }

    @Override
    public String getMysql() {
        return adminMapper.selectversion();
    }

    @Override
    public int getUsernumber() {
          return adminMapper.selectusercount();
    }

    @Override
    public int getMhinfonumber() {
        return adminMapper.selectmhinfocount();
    }


}
