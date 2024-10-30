package com.mhd.manhuadui.Dao;

import com.mhd.manhuadui.Pojo.Trailer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 漫画更新预告DAO方法
 */

@Mapper
@Repository
public interface TrailerMapper {
    /**
     * 根据更新时间倒序显示
     */
     @Select("SELECT * from t_updatetrailer ORDER BY up_time DESC LIMIT 8")
     List<Trailer> selectTrailer();
    /**
     * 添加新的更新预告
     */
     @Insert("insert into t_updatetrailer(up_name,up_wors,up_time) values(#{up_name},#{up_wors},#{up_time})")
     int saveTrailer(Trailer trailer);
    /**
     * 根据id删除数据
     */
    @Delete("delete from t_updatetrailer where up_id = #{up_id}")
     void  deleteId(Integer up_id);


}
