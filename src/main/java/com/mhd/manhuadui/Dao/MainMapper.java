package com.mhd.manhuadui.Dao;

import com.mhd.manhuadui.Pojo.Mhinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MainMapper {
    /**
     * 进行模糊查询
     */
     @Select("SELECT id,mhname,authorname,imgurl from t_mhinfo where mhname like concat('%',#{0},'%') or authorname like concat('%',#{0},'%')")
     List<Mhinfo>  selectAllbyname(String mhname);
    /**
     * 统计查询结果的个数
     */
     @Select("select count(*) from t_mhinfo where mhname like concat('%',#{0},'%') or authorname like concat('%',#{0},'%')")
     int selectconut(String mhname);
    /**
     * 查询漫画章节更新时间
     */
     @Select("SELECT createtime from t_mhlist order by createtime DESC limit 1")
     String selectmhlisttime();
}
