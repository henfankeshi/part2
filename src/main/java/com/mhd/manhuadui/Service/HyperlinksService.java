package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Pojo.Hyperlinks;
import java.util.List;

public interface HyperlinksService {
    /**
     * 显示链接列表
     */
     List<Hyperlinks> list();
     /**
     * 显示链接列表的前五个
     */
     List<Hyperlinks> listlimit();
    /**
     * 删除链接
     */
     void delete(int id);
    /**
     * 添加链接
     */
     void save(Hyperlinks hyperlinks);
    /**
     * 统计链接个数
     */
     int links();


}
