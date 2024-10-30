package com.mhd.manhuadui.Dao;

import com.mhd.manhuadui.Pojo.Mhinfo;
import com.mhd.manhuadui.Pojo.Recommended;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface RecommendedMapper {
    /**
     * 将漫画加入到推荐表中
     */
    @Insert("insert into t_recommended(m_id,name,author,imgurl) values(#{m_id},#{name},#{author},#{imgurl})")
    void save(Recommended recommended);
    /**
     *显示被推荐的漫画列表
     */
    @Select("SELECT * from t_recommended order by r_id desc")
    List<Recommended> list();
    /**
     * 删除推荐漫画
     */
    @Delete("delete from t_recommended where r_id = #{r_id}")
    int delete(int id);
    /**
     * 首页显示六部推荐漫画
     */
    @Select("select * from t_recommended order by r_id desc limit 6")
    List<Recommended> listlimit();
    /**
     * 根据 m_id 获取漫画的详情信息
     */
    @Select("select t_mhinfo.id,t_mhinfo.mhname,t_mhinfo.authorname,t_mhinfo.size,t_mhinfo.announcement,t_mhinfo.state,t_mhinfo.category,t_mhinfo.type,t_mhinfo.region,t_mhinfo.Introduction,t_mhinfo.alias,t_mhinfo.imgurl from t_mhinfo,t_recommended  where t_mhinfo.id=t_recommended.m_id and t_recommended.r_id = #{r_id}")
    Mhinfo listAll(int r_id);
}
