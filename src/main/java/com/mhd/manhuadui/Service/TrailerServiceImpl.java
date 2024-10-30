package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Dao.TrailerMapper;
import com.mhd.manhuadui.Pojo.Trailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrailerServiceImpl implements TrailerService{
    @Autowired
    TrailerMapper trailerMapper;

    @Override
    public List<Trailer> getTrailer() {
        return trailerMapper.selectTrailer();
    }

    @Override
    public void save(Trailer trailer) {
        // trailer.setUp_time(new Date());
         trailerMapper.saveTrailer(trailer);
    }

    @Override
    public void deleteTrailer(Integer up_id) {
         trailerMapper.deleteId(up_id);
    }


}
