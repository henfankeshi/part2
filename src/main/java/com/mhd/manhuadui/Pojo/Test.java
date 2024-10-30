package com.mhd.manhuadui.Pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
     public static void main(String[] args) {
//         SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );
//         Date date = new Date();
//         String str = sdf.format(date);
//         System.out.println("当前时间通过 yyyy-MM-dd HH:mm:ss SSS 格式化后的输出: "+str);
          System.out.println(new Date());
     }
     public void getTime(String str){
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
           Date date = new Date();
           str = sdf.format(date);
           System.out.println("当前时间通过 yyyy-MM-dd HH:mm:ss SSS 格式化后的输出: "+str);
     }
}
