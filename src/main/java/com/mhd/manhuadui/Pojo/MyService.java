package com.mhd.manhuadui.Pojo;

import lombok.Data;

import java.sql.Connection;
import java.util.Properties;

@Data
public class MyService {
      private String system; //操作系统信息
      private String ipaddress;  //ip地址
      private String domainname; //域名
      private String  jdkversion; //Java版本
      private String sqlname;   //数据库名称版本

    public static Properties getSystemProperties() {
        Properties props = System.getProperties(); // 系统属性
        return props;
    }
    public static void main(String[] args) {
        Properties props = getSystemProperties();
        System.out.println("Java运行时环境规范版本：" + props.getProperty("java.specification.version"));
        System.out.println("操作系统的名称：" + props.getProperty("os.name"));

    }
}
