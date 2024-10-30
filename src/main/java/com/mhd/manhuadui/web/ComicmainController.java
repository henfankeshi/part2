package com.mhd.manhuadui.web;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mhd.manhuadui.Pojo.Img;
import com.mhd.manhuadui.Pojo.Mhinfo;
import com.mhd.manhuadui.Pojo.Mhlist;
import com.mhd.manhuadui.Service.ComicmainService;
import com.mhd.manhuadui.Service.ComicrankService;
import com.mhd.manhuadui.Service.TrailerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 后台漫画管理控制器
 */
@Controller
@RequestMapping("/admin")
public class ComicmainController {

    @Autowired
    ComicmainService comicmainService;

    /**
     * 倒序显示列表
     * @param model
     * @param start
     * @param size
     * @return
     * @throws Exception
     */
   @GetMapping("/comicmain")
    public String comicmain(Model model,
                            @RequestParam(value = "start",
                            defaultValue = "0") int start,
                            @RequestParam(value = "size",
                            defaultValue = "5") int size) throws Exception {
       PageHelper.startPage(start,size,"id desc");
       List<Mhinfo> list = new ArrayList<>();
       list = comicmainService.getAll();
       PageInfo<Mhinfo> page= new PageInfo<>(list);
       model.addAttribute("page",page);
       return "admin/Comicmain";
   }
    /**
     * 跳转到添加漫画页面
     */
   @GetMapping("/addcomic")
    public String addcomic() {
       return "admin/addcomic";
   }

    /**
     *
     *跳转到更新漫画页面
     */
   @GetMapping("updatecomic")
   public String updatecomic() {
       return "admin/updatecomic";
   }

    /**
     * 添加漫画
     */
    @GetMapping("/AddComicCheck")
     public String Addcomic(Model model, RedirectAttributes attributes, @RequestParam String mhname,
                            @RequestParam String authorname, @RequestParam Integer size,
                            @RequestParam String announcement, @RequestParam String state,
                            @RequestParam String category, @RequestParam String type,
                            @RequestParam String region, @RequestParam String Introduction,
                            @RequestParam String alias, @RequestParam String imgurl
                            ) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
//        Date date = new Date();
//        String updatetime = sdf.format(date);
        Mhinfo mhinfo = new Mhinfo();


        mhinfo.setMhname(mhname);
        mhinfo.setAuthorname(authorname);
        mhinfo.setSize(size);
        mhinfo.setAnnouncement(announcement);
        mhinfo.setState(state);
        mhinfo.setCategory(category);
        mhinfo.setType(type);
        mhinfo.setRegion(region);
        mhinfo.setIntroduction(Introduction);
        mhinfo.setAlias(alias);
        mhinfo.setImgname("我是图片");
        mhinfo.setImgurl(imgurl);
        mhinfo.setUpdatetime(new Date());


        if(mhinfo!=null) {
            comicmainService.savemh(mhinfo);
            System.out.println("添加成功");
            attributes.addFlashAttribute("message","添加成功,你可以继续添加或者关闭页面");
            return "redirect:/admin/addcomic";
        } else {
            System.out.println("添加失败");
            attributes.addFlashAttribute("error","添加失败");
            return "redirect:/admin/addcomic";
        }
    }

    /**
     * 删除漫画
     */
      @GetMapping("/deletemh")
      public String deletemh(@RequestParam Integer id) {
          comicmainService.remove(id);
          System.out.println("删除成功"+id);
          return "redirect:/admin/comicmain";
      }
    /**
     * 获取漫画内容
     */
      @GetMapping("/getId")
      public String getId(int id,Model model) {
           Mhinfo mhinfo = new Mhinfo();
           mhinfo = comicmainService.getId(id);
           model.addAttribute("list",mhinfo);
           return "admin/updatecomic";
      }
    /**
     * 更新漫画
     */
      @GetMapping("/update")
      public String update(Model model, RedirectAttributes attributes, @RequestParam String mhname,
                           @RequestParam String authorname, @RequestParam Integer size,
                           @RequestParam String announcement, @RequestParam String state,
                           @RequestParam String category, @RequestParam String type,
                           @RequestParam String region, @RequestParam String Introduction,
                           @RequestParam String alias, @RequestParam String imgurl,
                           @RequestParam Integer id){
          Mhinfo mhinfo = new Mhinfo();
          mhinfo.setId(id);
          mhinfo.setMhname(mhname);
          mhinfo.setAuthorname(authorname);
          mhinfo.setSize(size);
          mhinfo.setAnnouncement(announcement);
          mhinfo.setState(state);
          mhinfo.setCategory(category);
          mhinfo.setType(type);
          mhinfo.setRegion(region);
          mhinfo.setIntroduction(Introduction);
          mhinfo.setAlias(alias);
          mhinfo.setImgurl(imgurl);
          mhinfo.setUpdatetime(new Date());

          comicmainService.updatecomic(mhinfo);
          System.out.println("更新成功");
          return "redirect:/admin/comicmain";
      }
    /**
     * 漫画模糊查询
     */
      @GetMapping("/serachmh")
      public String serachmh(@RequestParam String nameorauthor,Model model) {
          List<Mhinfo> list = new ArrayList<>();
          list = comicmainService.getnameorau(nameorauthor);
          if(list.toString().equals("[]")) {
              model.addAttribute("message","没有搜索到相关数据");
              return "admin/comicserach";
          } else {
              model.addAttribute("list", list);
              return "admin/comicserach";
          }
      }

     /**
     * 获取漫画名跳转到添加章节列表
     */
     @GetMapping("/addtitle")
     public String addtitle(String name,Model model) {
         int id = comicmainService.sidbyname(name);
         System.err.println(id);
         model.addAttribute("id",id);
         return "admin/addtitle";
     }
    /**
     * 显示章节列表
     */
     @GetMapping("/titlelist")
     public String titlelist(Integer id,Model model) {
         List<Mhlist> list = new ArrayList<>();
         Mhinfo m = new Mhinfo();
         m = comicmainService.getId(id);
         list = comicmainService.getmhlist(id);
         model.addAttribute("list",list);
         model.addAttribute("m",m);
         return "admin/titlelist";
     }
    /**
     * 添加章节列表
     */
     @GetMapping("/AddTitle")
     public String AddTitle(RedirectAttributes attributes,@RequestParam int id,@RequestParam String title) {
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date date = new Date();
         String time = sdf.format(date);
         Mhlist m = new Mhlist();
         m.setM_id(id);
         m.setCreatetime(time);
         m.setTitle(title);
         comicmainService.savemhlist(m);
         System.out.println("保存成功");
         attributes.addFlashAttribute("message","添加成功,可以继续添加或者关闭会话框");
         return "redirect:/admin/success";
     }

    @GetMapping("/success")
    public String success() {
         return "admin/success";
    }

    /**
     * 漫画图片显示列表
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/mhimglist")
    public String mhimglist(Integer id,Model model) {
         List<Img> list = new ArrayList<>();
         list = comicmainService.imglist(id);
         String name = comicmainService.Selectnamebyid(id);
         String title = comicmainService.Selecttitlebyid(id);
         model.addAttribute("list",list);
         model.addAttribute("name",name);
         model.addAttribute("title",title);
         return "admin/mhlist";
    }
    /**
     * 跳转到上传漫画图片页面
     */
     @GetMapping("/addmhImg")
     public String addmhimg() {
         return "admin/addmhImg";
     }
    /**
     * 上传漫画图片
     */
     @GetMapping("/addmhimgcheck")
     public String addmhimgcheck(@RequestParam Integer id,@RequestParam String imgurl,RedirectAttributes attributes) {
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date date = new Date();
         String createtime = sdf.format(date);
         Img i = new Img();
         i.setI_id(id);
         i.setImgurl(imgurl);
         i.setCreatetime(createtime);
         comicmainService.Saveimg(i);
         System.out.println("添加成功"+imgurl);
         attributes.addFlashAttribute("message","添加成功你可以继续添加或者关闭会话框");
         return "redirect:/admin/addmhImg";
     }


}
