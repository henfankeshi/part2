package com.mhd.manhuadui.Dao;

import com.mhd.manhuadui.Pojo.Hyperlinks;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HyperlinksMapper {
    /**
     * 显示链接列表
     */
     @Select("SELECT * from t_hyperlinks order by createtime desc")
    List<Hyperlinks>  selectAll();
    /**
     * 显示链接列表的前五个
     */
     @Select("SELECT * from t_hyperlinks order by createtime desc limit 8")
     List<Hyperlinks> selectAlllimit();
    /**
     * 删除链接
     */
     @Delete("delete from t_hyperlinks where id = #{id}")
     int deleteAll(int id);
    /**
     * 添加链接
     */
     @Insert("INSERT into t_hyperlinks(name,url,createtime)  values(#{name},#{url},#{createtime})")
     int insertAll(Hyperlinks hyperlinks);
    /**
     * 统计链接个数
     */
     @Select("SELECT count(*) from t_hyperlinks")
     int linksnumber();
}
