package com.mhd.manhuadui.web;


import com.mhd.manhuadui.Pojo.Trailer;
import com.mhd.manhuadui.Service.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 漫画更新预告控制器
 */
@RequestMapping("/admin")
@Controller
public class TrailerController {
    @Autowired
    TrailerService trailerService;

    //获取更新预告并排序
    @GetMapping("/trailer")
    public String trailer(Model model) {
        model.addAttribute("trailer",trailerService.getTrailer());
        return "admin/trailer";
    }
    //跳转到添加更新预告页面
    @GetMapping("/addtrailer")
    public String addtrailer() {
        return "admin/addtrailer";
    }

    /**
     * 添加更新预告
     * @param up_name
     * @param up_wors
     * @param model
     * @param attributes
     * @return
     */
    @GetMapping("/Addtrailer")
    public String Addtrailer(@RequestParam String up_name, @RequestParam String up_wors, Model model, RedirectAttributes attributes) {
        //获取系统当前时间
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );
        Date date = new Date();
        String time = sdf.format(date);

        Trailer trailer = new Trailer();
        trailer.setUp_name(up_name);
        trailer.setUp_wors(up_wors);
        trailer.setUp_time(new Date());

        if(up_name!=null&&up_wors!=null) {
            trailerService.save(trailer);

            System.out.println("添加成功");
            //model.addAttribute("message","添加成功");
            attributes.addFlashAttribute("message","添加成功，可以继续添加或者关闭会话框");
            return "redirect:/admin/addtrailer";
        } else  {
            System.err.println("添加失败");
            attributes.addFlashAttribute("error","添加失败");
            return "redirect:/admin/addtrailer";
        }
    }

    /**
     * 根据id删除数据
     */
      @GetMapping("/deletetrailer")
      public String deletetrailer(@RequestParam Integer u_id) {
           trailerService.deleteTrailer(u_id);
           System.err.println("删除成功"+u_id);
           return "redirect:/admin/trailer";
      }

}

