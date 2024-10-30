package com.mhd.manhuadui.web;



import com.mhd.manhuadui.Pojo.Admin;
import com.mhd.manhuadui.Pojo.Comicrank;
import com.mhd.manhuadui.Pojo.MyService;
import com.mhd.manhuadui.Service.AdminService;
import com.mhd.manhuadui.Util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Properties;


@Controller
@RequestMapping("/admin")
//@SessionAttributes(value = {"a_id","adminname","adminpassword"})
public class AdminController {
      @Autowired
      private AdminService adminService;

      //进入后台首先跳转到登录页面
      @GetMapping
      public String LoginPage() {
          return "admin/lyear_pages_login";
      }

       //转向后台主页
    @GetMapping("/a")
    public String index() {
        return  "admin/index";
    }


    /**
     * 管理员注销登录
     * @param session
     * @return
     */
      @GetMapping("/loginout")
      public String loginout(HttpSession session) {
          session.removeAttribute("admin");
          return "redirect:/admin";
      }
    /**
     *管理员登录验证
     */
      @PostMapping("/logincheck")
     public String logincheck(@RequestParam String adminname,
                              @RequestParam String adminpassword,
                              HttpSession session,
                              RedirectAttributes attributes,
                              HttpServletRequest request,
                              Model model) {
          Admin a=new Admin();
          a.setAdminname(adminname);
          a.setAdminpassword(MD5Util.code(adminpassword));
          Admin admin = adminService.adminlogin(a);
          if(admin!=null) {
              session.setAttribute("admin",admin);
             // attributes.addFlashAttribute("admin",admin);
              model.addAttribute("admin",admin);
              //如果登录成功跳转到管理员首页,防止表单重复提交
              return "redirect:/admin/main.html";

          } else {
              attributes.addFlashAttribute("error","账号或者密码错误");
              return "redirect:/admin";
          }
      }


       @GetMapping("/top")
      public String top() {
          return "admin/top";
       }

    /**
     * 获取服务器信息
     * @return
     */
    @GetMapping("/right")
      public  String right(MyService myService,HttpServletRequest request,Model model) {
          //服务器环境
           Properties props = MyService.getSystemProperties();
           String system = props.getProperty("os.name");
          //java版本
           String jdkversion =props.getProperty("java.specification.version");
          //数据库版本号
           String sqlname = adminService.getMysql();
          //服务器IP地址
           String ipaddress = request.getLocalAddr();
          //服务器主机名
           String  domainname = request.getLocalName();

           myService.setSystem(system);
           myService.setJdkversion(jdkversion);
           myService.setSqlname(sqlname);
           myService.setIpaddress(ipaddress);
           myService.setDomainname(domainname);

           model.addAttribute("myService",myService);
           model.addAttribute("usernumber",adminService.getUsernumber());
           model.addAttribute("mhinfonumber",adminService.getMhinfonumber());
           return "admin/right";
       }

       @GetMapping("/left")
      public String left() {
          return "admin/left";
       }





}
