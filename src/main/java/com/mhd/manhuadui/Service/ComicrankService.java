package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Pojo.Comicrank;

import javax.smartcardio.CommandAPDU;
import java.util.List;

public interface ComicrankService {
    /**
     * 对漫画进行排名
     */
    List<Comicrank> getComicPaiming();
    /**
     * 根据id获取漫画信息
     */
    Comicrank getone(int c_id);
    /**
     * 根据id修改漫画排名信息
     */
    int updategetid(Comicrank comicrank);
}
