package com.mhd.manhuadui.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mhd.manhuadui.Pojo.Feedback;
import com.mhd.manhuadui.Pojo.User;
import com.mhd.manhuadui.Service.UseroperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

/**
 * 后台用户控制器
 */
@Controller
@RequestMapping("/admin")
public class UseroperationController {

    @Autowired
    UseroperationService useroperationService;

    //显示用户列表,分页
    @GetMapping("/UserList")
    public String UserList(Model model,
                           @RequestParam(value = "start", defaultValue = "0") int start,
                           @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"u_id desc");
        List<User> list = new ArrayList<>();
        list=useroperationService.list();
        PageInfo<User> page = new PageInfo<>(list);
        model.addAttribute("page",page);
        return "admin/UserList";
    }
    //删除用户
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam Integer u_id) {
         useroperationService.delete(u_id);
         System.out.println("删除成功"+u_id);
         return "redirect:/admin/UserList";
    }
    /**
     * 搜索用户
     */
     @GetMapping("/serachuser")
     public String serachuser(@RequestParam String inputtext,Model model) {
         List<User> list = new ArrayList<>();
         list = useroperationService.like(inputtext);
         if(list.toString().equals("[]")) {
             model.addAttribute("message","没有搜索到相关数据");
             return "admin/Userserach";
         } else {
             model.addAttribute("list",list);
             return "admin/Userserach";
         }
     }
    /**
     * 用户反馈列表
     */
     @GetMapping("/feedbacklist")
     public String feedbacklist(Model model) {
         List<Feedback> list = new ArrayList<>();
         Feedback feedback = new Feedback();
         list = useroperationService.Feedbacklist();
         model.addAttribute("list",list);
         return "admin/feedbacklist";
     }
    /**
     * 查看反馈内容
     */
     @GetMapping("/gettext")
     public String gettext(Integer id,Model model) {
           String text = useroperationService.Text(id);
           model.addAttribute("text",text);
           return "admin/text";
     }
}
