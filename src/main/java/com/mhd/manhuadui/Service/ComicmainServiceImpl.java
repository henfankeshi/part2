package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Dao.ComicmainMapper;
import com.mhd.manhuadui.Dao.ComicrankMapper;
import com.mhd.manhuadui.Pojo.Img;
import com.mhd.manhuadui.Pojo.Mhinfo;
import com.mhd.manhuadui.Pojo.Mhlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicmainServiceImpl implements ComicmainService{

    @Autowired
    ComicmainMapper comicmainMapper;

    //倒序查询漫画信息
    @Override
    public List<Mhinfo> getAll() {
        return comicmainMapper.selectAll();
    }
    //保存漫画
    @Override
    public void savemh(Mhinfo mhinfo) {
        comicmainMapper.save(mhinfo);
    }
    //删除漫画
    @Override
    public void remove(int id) {
         comicmainMapper.deleteall(id);
    }
    //查询所有信息
    @Override
    public Mhinfo getId(int id) {
        return comicmainMapper.getAllbyId(id);
    }
    //更新漫画
    @Override
    public void updatecomic(Mhinfo mhinfo) {
        comicmainMapper.update(mhinfo);
    }

    @Override
    public List<Mhinfo> getupdatetime() {
        return comicmainMapper.selectByUpdatetime();
    }

    @Override
    public List<Mhinfo> getnameorau(String nameorau) {
        return comicmainMapper.selectlikename(nameorau);
    }

    @Override
    public List<Mhlist> getmhlist(int id) {
        return comicmainMapper.mhlist(id);
    }

    @Override
    public int sidbyname(String name) {
        return comicmainMapper.selectidbyname(name);
    }

    @Override
    public void savemhlist(Mhlist mhlist) {
         comicmainMapper.insertmhlist(mhlist);
    }

    @Override
    public List<Img> imglist(int id) {
        return comicmainMapper.selectimglist(id);
    }

    @Override
    public String Selectnamebyid(int id) {
       return   comicmainMapper.selectnamebyid(id);
    }

    @Override
    public String Selecttitlebyid(int id) {
        return comicmainMapper.selecttitlebyid(id);
    }

    @Override
    public void Saveimg(Img img) {
         comicmainMapper.saveimg(img);
    }

    @Override
    public int Imgnumber(int id) {
        return comicmainMapper.imgnumber(id);
    }


}
