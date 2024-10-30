package com.mhd.manhuadui.Pojo;


import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 漫画实体类
 */
@Data
public class Mhinfo {

     private int id;        //主键
     private String mhname;//漫画名称
     private String authorname;//作者名字
     private int size;//作品数量
     private String announcement;//作者公告
     private String state;//状态
     private String category;//类别
     private String type;//类型
     private String region;//地区
     private String Introduction;//简介
     private String alias;//别名
     private String imgname;//封面图片名称
     private String imgurl;//封面图片地址
     private Date updatetime; //更新时间
}
