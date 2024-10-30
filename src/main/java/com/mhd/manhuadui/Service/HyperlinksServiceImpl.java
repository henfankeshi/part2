package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Dao.HyperlinksMapper;
import com.mhd.manhuadui.Pojo.Hyperlinks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HyperlinksServiceImpl implements HyperlinksService{

    @Autowired
    HyperlinksMapper hyperlinksMapper;
    @Override
    public List<Hyperlinks> list() {
        return hyperlinksMapper.selectAll();
    }

    @Override
    public List<Hyperlinks> listlimit() {
        return hyperlinksMapper.selectAlllimit();
    }

    @Override
    public void delete(int id) {
         hyperlinksMapper.deleteAll(id);
    }

    @Override
    public void save(Hyperlinks hyperlinks) {
         hyperlinksMapper.insertAll(hyperlinks);
    }

    @Override
    public int links() {
        return hyperlinksMapper.linksnumber();
    }
}
