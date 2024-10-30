package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Dao.MainMapper;
import com.mhd.manhuadui.Pojo.Mhinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService{

    @Autowired
    MainMapper mainMapper;

    @Override
    public List<Mhinfo> getnameAll(String mhname) {
        return mainMapper.selectAllbyname(mhname);
    }

    @Override
    public int count(String mhname) {
        return  mainMapper.selectconut(mhname);
    }

    @Override
    public String gettime() {
        return mainMapper.selectmhlisttime();
    }
}
