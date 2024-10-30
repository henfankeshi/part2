package com.mhd.manhuadui.web;

import com.mhd.manhuadui.Dao.RecommendedMapper;
import com.mhd.manhuadui.Pojo.Mhinfo;
import com.mhd.manhuadui.Pojo.Recommended;
import com.mhd.manhuadui.Service.ComicmainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

/**
 * 漫画推荐
 */
@Controller
@RequestMapping("/admin")
public class RecommendedController {
     @Autowired
     RecommendedMapper recommendedMapper;
     @Autowired
     ComicmainService comicmainService;
     //后台列表显示
     @GetMapping("/recommended")
     public String recommended(Model model) {
         List<Recommended> list = new ArrayList<>();
         list=recommendedMapper.list();
         model.addAttribute("list",list);
         return "admin/recommended";
     }
     //设为推荐漫画
     @GetMapping("/tuijian")
     public String tuijian(@RequestParam Integer id) {
         Mhinfo m = new Mhinfo();
         Recommended r = new Recommended();
         m = comicmainService.getId(id);
         if(m.toString().equals("[]")) {
             System.err.println("错误"+id);
             return  "redirect:/admin/comicmain";
         } else {
             r.setM_id(m.getId());
             r.setName(m.getMhname());
             r.setAuthor(m.getAuthorname());
             r.setImgurl(m.getImgurl());
             recommendedMapper.save(r);
             System.out.println("推荐成功");

             return "redirect:/admin/comicmain";
         }
     }
    /**
     * 删除推荐漫画
     */
     @GetMapping("/deletere")
     public String deletere(Integer id) {
         recommendedMapper.delete(id);
         System.out.println("删除成功"+id);
         return "redirect:/admin/recommended";
     }

}
