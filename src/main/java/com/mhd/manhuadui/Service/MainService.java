package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Pojo.Mhinfo;

import java.util.List;

public interface MainService {
    /**
     * 模糊查询
     */
    List<Mhinfo>  getnameAll(String mhname);
    /**
     * 查询结果统计个数
     */
    int count(String mhname);
    /**
     * 查询漫画章节更新时间
     */
    String gettime();
}
