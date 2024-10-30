package com.mhd.manhuadui.web;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mhd.manhuadui.Pojo.Img;
import com.mhd.manhuadui.Pojo.Mhinfo;
import com.mhd.manhuadui.Pojo.Mhlist;
import com.mhd.manhuadui.Pojo.Trailer;
import com.mhd.manhuadui.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 首页控制器
 */
@Controller
public class IndexController {

     @Autowired
     ComicrankService comicrankService;
     @Autowired
     TrailerService trailerService;
     @Autowired
     MainService mainService;
     @Autowired
     ComicmainService comicmainService;
     @Autowired
     HyperlinksService hyperlinksService;
     @Autowired
     RecommendedService recommendedService;
    //根跳转
  //  @GetMapping("/")
  //  public String root() {
   //     return "redirect:/index";
  //  }
     @GetMapping("/")
     public String index(Model model) {
         model.addAttribute("paiming",comicrankService.getComicPaiming());
         model.addAttribute("gengxin",trailerService.getTrailer());
         model.addAttribute("zuijinggengxin",comicmainService.getupdatetime());
         model.addAttribute("links",hyperlinksService.listlimit());
         model.addAttribute("tuijian",recommendedService.Listlimit());
         return "Index";
     }


    //主页跳转
  //  @GetMapping("/index")
   // public String index() {
   //     return "redirect:/comic";
  //  }

    //跳转到关于我的页面
    @GetMapping("/about")
    public String about() {
        return "about";
    }

    //跳转到漫画详情页
    @GetMapping("/jinjidejuren")
    public String message() {
        return "message";
    }

    //跳转到注册
    @GetMapping("/register")
    public String register() {

        return "register";
    }
    //登录跳转
    @GetMapping("/login")
    public String Login() {
        return "login";
    }
    @GetMapping("/serach")
    public String serach() {
         return "serach";
    }
    /**
     * 模糊查询漫画
     */
    @GetMapping("/serachmh")
    public String serachmh(@RequestParam String Keywords, HttpServletRequest request,Model model) {
        if(request.getParameter("Keywords")!=null) {
            List<Mhinfo> list = new ArrayList();
            int a = mainService.count(Keywords);
            list = mainService.getnameAll(Keywords);
            if(list.toString().equals("[]")) {
                model.addAttribute("a", a);
                model.addAttribute("Keywords", Keywords);
                model.addAttribute("error","没有找到相关数据");
                return "serach";
            } else {
                model.addAttribute("list", list);
                model.addAttribute("a", a);
                model.addAttribute("Keywords", Keywords);
                return "serach";
            }
        }
        System.err.println("搜索请求失败");
        return "redirect:/";
    }
    //跳转到项目外地址
    @GetMapping("/go")
    public ModelAndView go(String url) {
        return new ModelAndView(new RedirectView(url));
    }
    //查看漫画详情
    @GetMapping("/comic")
    public String comic(Integer id,Model model) {
        Mhinfo m = new Mhinfo();
        List<Mhlist> list = new ArrayList<>();
        list = comicmainService.getmhlist(id);
        String time = mainService.gettime();
        m=comicmainService.getId(id);
        model.addAttribute("m",m);
        model.addAttribute("list",list);
        model.addAttribute("time",time);
        return "message";
    }
    @GetMapping("/comics")
    public String comics(Integer r_id,Model model) {
        Mhinfo m = new Mhinfo();
        List<Mhlist> list = new ArrayList<>();
        String time = mainService.gettime();
        m = recommendedService.ListAll(r_id);
        list = comicmainService.getmhlist(m.getId());
        model.addAttribute("m",m);
        model.addAttribute("list",list);
        model.addAttribute("time",time);
        return "message";
    }
    /**
     * 跳转到漫画阅读页
     */
//     @GetMapping("/manhua")
//     public String manhua(Integer id,
//                          Model model,
//                          @RequestParam(value = "start",
//                                  defaultValue = "0") int start,
//                          @RequestParam(value = "size",
//                                  defaultValue = "17") int size
//     ) throws Exception {
//         PageHelper.startPage(start,size,"id asc");
//         List<Img> list = new ArrayList<>();
//         list = comicmainService.imglist(id);
//         PageInfo<Img> page= new PageInfo<>(list);
//         model.addAttribute("page",page);
//         return "manhua";
//     }
       @GetMapping("/manhua")
       public String manhua(Integer id,Model model) {
           List<Img> list = new ArrayList<>();
           list = comicmainService.imglist(id);
           int number = comicmainService.Imgnumber(id);
           model.addAttribute("list",list);
           model.addAttribute("number",number);
           return "manhua";
       }
}
