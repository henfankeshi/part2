package com.mhd.manhuadui.Service;

import com.mhd.manhuadui.Pojo.Trailer;

import java.util.List;

public interface TrailerService {
    /**
     * 根据更新时间倒序查找数据
     */
     List<Trailer>  getTrailer();
    /**
     * 添加新的更新预告
     */
     void save(Trailer trailer);
    /**
     * 根据id删除数据
     */
     void deleteTrailer(Integer up_id);


}
