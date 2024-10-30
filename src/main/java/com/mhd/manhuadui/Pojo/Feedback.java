package com.mhd.manhuadui.Pojo;

import lombok.Data;

/**
 * 反馈实体
 */
@Data
public class Feedback {
     private int id;
     private int u_id;
     private String textfield;
     private String createtime;
     private String username;
}
