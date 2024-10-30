package com.mhd.manhuadui.Service;


import com.mhd.manhuadui.Dao.ComicrankMapper;
import com.mhd.manhuadui.Pojo.Comicrank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicrankServiceImpl  implements ComicrankService{
    @Autowired
    ComicrankMapper comicrankMapper;

    /**
     * 对漫画进行排名
     */
    @Override
    public List<Comicrank> getComicPaiming() {
        return comicrankMapper.selectbynumber();
    }

    @Override
    public Comicrank getone(int c_id) {
        return comicrankMapper.selectById(c_id);
    }

    @Override
    public int updategetid(Comicrank comicrank) {
        return comicrankMapper.updatecomicrank(comicrank);
    }
}
