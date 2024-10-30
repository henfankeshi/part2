package com.mhd.manhuadui.Dao;

import com.mhd.manhuadui.Pojo.Img;
import com.mhd.manhuadui.Pojo.Mhinfo;
import com.mhd.manhuadui.Pojo.Mhlist;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ComicmainMapper {

    /**
     * 按照ID倒序查找漫画所有的信息
     */
     @Select("select * from t_mhinfo order by id desc")
     List<Mhinfo> selectAll();
    /**
     * 添加漫画
     *
     */
     @Insert("insert into t_mhinfo(mhname,authorname,size,announcement,state,category,type,region,Introduction,alias,imgname,imgurl,updatetime) values(#{mhname},#{authorname},#{size},#{announcement},#{state},#{category},#{type},#{region},#{Introduction},#{alias},#{imgname},#{imgurl},#{updatetime})")
     int save(Mhinfo mhinfo);

    /**
     * 更新漫画
     */
     @Update("update t_mhinfo set mhname=#{mhname},authorname=#{authorname},size=#{size},announcement=#{announcement},state=#{state},category=#{category},type=#{type},region=#{region},Introduction=#{Introduction},alias=#{alias},imgurl=#{imgurl},updatetime=#{updatetime} where id = #{id}")
      int update(Mhinfo mhinfo);

    /**
     * 删除漫画
     */
     @Delete("delete from t_mhinfo where id = #{id}")
     int deleteall(int id);

    /**
     * 查询所有信息
     */
     @Select("select * from t_mhinfo where id = #{id}")
     Mhinfo getAllbyId(int id);
    /**
     * 按照更新时间进行排序
     */
      @Select("SELECT id,mhname,authorname,imgurl from t_mhinfo ORDER BY updatetime DESC LIMIT 6")
     List<Mhinfo> selectByUpdatetime();
    /**
     * 根据作者漫画名搜索漫画
     */
    @Select("SELECT * from t_mhinfo where mhname like concat('%',#{0},'%') or authorname like concat('%',#{0},'%')")
     List<Mhinfo> selectlikename(String nameorau);
    /**
     * 显示漫画列表
     */
     @Select("SELECT t_mhlist.id,t_mhlist.title,t_mhlist.createtime from t_mhlist,t_mhinfo where t_mhinfo.id =  t_mhlist.m_id AND t_mhlist.m_id = #{m_id} order by title DESC")
     List<Mhlist> mhlist(int id);
    /**
     * 根据漫画名查找ID
     */
     @Select("SELECT id from t_mhinfo where mhname  = #{mhname}")
     int selectidbyname(String name);
    /**
     * 添加漫画章节
     */
     @Insert("insert into t_mhlist(m_id,title,createtime) values(#{m_id},#{title},#{createtime})")
     int insertmhlist(Mhlist mhlist);
    /**
     * 显示漫画图片链接列表
     */
     @Select("SELECT t_img.id,t_img.imgurl,t_img.createtime,t_img.i_id from t_img,t_mhlist where t_mhlist.id=t_img.i_id and t_img.i_id = #{i_id}")
     List<Img> selectimglist(int id);
    /**
     * 根据ID查询漫画名跟章节数
     */
     @Select("select t_mhinfo.mhname from t_mhinfo,t_mhlist where t_mhlist.m_id = t_mhinfo.id and t_mhlist.id = #{id}")
     String selectnamebyid(int id);
     @Select("select t_mhlist.title from t_mhinfo,t_mhlist where t_mhlist.m_id = t_mhinfo.id and t_mhlist.id = #{id}")
     String selecttitlebyid(int id);

    /**
     * 添加漫画图片
     */
     @Insert("INSERT into t_img(i_id,imgurl,createtime) VALUES(#{i_id},#{imgurl},#{createtime})")
     int saveimg(Img img);
    /**
     * 统计漫画图片的数量
     */
     @Select("SELECT COUNT(imgurl) from t_img,t_mhlist where t_img.i_id = t_mhlist.id and t_img.i_id = #{i_id}")
     int imgnumber(int id);
}
