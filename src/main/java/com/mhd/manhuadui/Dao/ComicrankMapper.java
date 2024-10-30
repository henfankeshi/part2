package com.mhd.manhuadui.Dao;

import com.mhd.manhuadui.Pojo.Comicrank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ComicrankMapper {

    /**
     * 按照number大小进行排序
     */
      @Select("SELECT * FROM t_comicrank ORDER BY c_number ASC")
      List<Comicrank> selectbynumber();

    /**
     * 根据id获取漫画的信息
     */
      @Select("select * from t_comicrank where c_id = #{c_id}")
      Comicrank selectById(int c_id);
    /**
     * 根据id修改漫画排名信息
     */
      @Update("update t_comicrank set c_name = #{c_name},c_words = #{c_words} where c_id = #{c_id}")
      int  updatecomicrank(Comicrank comicrank);

}
