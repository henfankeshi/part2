package com.mhd.manhuadui.web;

import com.mhd.manhuadui.Pojo.Mhinfo;
import com.mhd.manhuadui.Service.ComicmainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 漫画更新控制器
 */
@Controller
@RequestMapping("/admin")
public class RecentupdatesController {
     @Autowired
    ComicmainService comicmainService;
     @GetMapping("/recentupdates")
     public String recentupdates(Model model) {
         List<Mhinfo> list = new ArrayList<>();
         list=comicmainService.getupdatetime();
         model.addAttribute("list",list);
         return "admin/Recentupdates";
     }

}
