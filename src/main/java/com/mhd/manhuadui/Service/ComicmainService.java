package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Pojo.Img;
import com.mhd.manhuadui.Pojo.Mhinfo;
import com.mhd.manhuadui.Pojo.Mhlist;

import java.util.List;

public interface ComicmainService {
    /**
     * 对漫画进行倒序显示
     */
     List<Mhinfo> getAll();
    /**
     * 添加漫画
     */
     void savemh(Mhinfo mhinfo);
    /**
     * 删除漫画
     */
     void remove(int id);
    /**
     * 获取漫画的全部信息
     */
      Mhinfo getId(int id);
    /**
     * 更新漫画
     */
      void updatecomic(Mhinfo mhinfo);
    /**
     * 按照更新时间进行排序
     */
     List<Mhinfo> getupdatetime();
    /**
     * 根据作者名字或者漫画名进行查询
     */
    List<Mhinfo> getnameorau(String nameorau);
    /**
     * 显示漫画章节列表
     */
    List<Mhlist> getmhlist(int id);
    /**
     * 根据漫画名查找ID
     */
    int sidbyname(String name);
    /**
     * 添加漫画章节
     */
    void savemhlist(Mhlist mhlist);
    /**
     * 显示漫画图片链接列表
     */
    List<Img> imglist(int id);
    /**
     * 根据ID查询漫画名跟章节数
     */
    String Selectnamebyid(int id);
    String Selecttitlebyid(int id);
    /**
     * 添加漫画图片
     */
     void Saveimg(Img img);
    /**
     * 统计漫画图片的数量
     */
    int Imgnumber(int id);
}
