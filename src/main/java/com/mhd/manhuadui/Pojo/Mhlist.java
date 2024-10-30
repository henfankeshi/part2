package com.mhd.manhuadui.Pojo;

import lombok.Data;

import java.util.List;

/**
 * 漫画章节列表类
 */
@Data
public class Mhlist {
     private int id;
     private int m_id;   //外键为Mhinfo类的id
     private String title;
     private String createtime;
}
