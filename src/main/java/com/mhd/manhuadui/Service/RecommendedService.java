package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Pojo.Mhinfo;
import com.mhd.manhuadui.Pojo.Recommended;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RecommendedService {
    /**
     * 将漫画加入到推荐表中
     */
    void Save(Recommended recommended);
    /**
     *显示被推荐的漫画列表
     */
    List<Recommended> List();
    /**
     * 删除推荐漫画
     */
    int Delete(int id);
    /**
     * 首页显示六部推荐漫画
     */
    List<Recommended> Listlimit();
    /**
     * 根据 m_id 获取漫画的详情信息
     */
    Mhinfo ListAll(int r_id);
}
