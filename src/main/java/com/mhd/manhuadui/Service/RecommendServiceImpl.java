package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Dao.RecommendedMapper;
import com.mhd.manhuadui.Pojo.Mhinfo;
import com.mhd.manhuadui.Pojo.Recommended;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendedService{

    @Autowired
    RecommendedMapper recommendedMapper;
    @Override
    public void Save(Recommended recommended) {
         recommendedMapper.save(recommended);
    }

    @Override
    public List<Recommended> List() {
        return recommendedMapper.list();
    }

    @Override
    public int Delete(int id) {
        return recommendedMapper.delete(id);
    }

    @Override
    public List<Recommended> Listlimit() {
        return recommendedMapper.listlimit();
    }

    @Override
    public Mhinfo ListAll(int r_id) {
        return recommendedMapper.listAll(r_id);
    }
}
