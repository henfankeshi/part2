package com.mhd.manhuadui.Pojo;

import lombok.Data;

/**
 * 推荐漫画表实体类
 */
@Data
public class Recommended {

     private int r_id;
     private int m_id;
     private String name;
     private String author;
     private String imgurl;
}
