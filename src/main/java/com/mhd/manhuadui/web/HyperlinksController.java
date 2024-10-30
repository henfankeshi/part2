package com.mhd.manhuadui.web;

import com.mhd.manhuadui.Pojo.Hyperlinks;
import com.mhd.manhuadui.Service.HyperlinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 友情链接控制器
 */
@Controller
@RequestMapping("/admin")
public class HyperlinksController {

     @Autowired
     HyperlinksService hyperlinksService;

    /**
     * 列表显示友情链接
     * @param model
     * @return
     */
     @GetMapping("/hyperlinks")
     public String hyperlinks(Model model) {
         List<Hyperlinks> list = new ArrayList<>();
         list = hyperlinksService.list();
         int number = hyperlinksService.links();
         model.addAttribute("number",number);
         model.addAttribute("list",list);
         return "admin/hyperlinks";
    }
     //跳转到添加友情链接页面
     @GetMapping("/addhyperlinks")
     public String addhyperlinks() {
         return "admin/addhyperlinks";
     }
     //添加友情链接
     @GetMapping("/add")
     public String add(@RequestParam String name,@RequestParam String url,RedirectAttributes attributes) {
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
          Date date = new Date();
          String createtime = sdf.format(date);
          Hyperlinks h = new Hyperlinks();
          h.setName(name);
          h.setUrl(url);
          h.setCreatetime(createtime);
          hyperlinksService.save(h);
          attributes.addFlashAttribute("message","添加成功可以继续添加或者关闭会话框");
          return "redirect:/admin/addhyperlinks";
     }
     //删除链接
     @GetMapping("/remove")
     public String remove(int id) {
         hyperlinksService.delete(id);
         System.out.println("删除成功"+id);
         return "redirect:/admin/hyperlinks";
     }


}
