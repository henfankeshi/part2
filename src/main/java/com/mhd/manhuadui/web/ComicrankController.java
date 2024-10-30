package com.mhd.manhuadui.web;


import com.mhd.manhuadui.Pojo.Comicrank;
import com.mhd.manhuadui.Service.ComicrankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 漫画排名控制器
 */
@Controller
@RequestMapping("/admin")
public class ComicrankController {

    @Autowired
    ComicrankService comicrankService;
    /**
     * 漫画排名
     * @return
     */
    @GetMapping("/comicrank")
    public String comicrank(Model model) throws Exception {
        List<Comicrank> list = comicrankService.getComicPaiming();
        if(list!=null) {
            model.addAttribute("c2",list);
            return "admin/Comicrank";
        }
        else {
            System.err.println("获取内容失败");
            return "redirect:/admin/index";
        }
    }

    /**
     * 更新漫画排名
     * @param c_id
     * @param c_name
     * @param c_words
     * @return
     */
    @GetMapping("/updatepaiming")
    public String updatecomicrank(@RequestParam int c_id,@RequestParam String c_name,@RequestParam String c_words) {
        Comicrank comicrank = new Comicrank();
        comicrank.setC_id(c_id);
        comicrank.setC_name(c_name);
        comicrank.setC_words(c_words);

        comicrankService.updategetid(comicrank);

        System.out.println("更新成功");
        return "redirect:/admin/comicrank";

   //     System.err.println("更心失败");
     //   return  "admin/updatecomicrank";
    }

    @GetMapping("/getid")
    public String getId(int c_id,Model model) {
        Comicrank comicrank = comicrankService.getone(c_id);
        model.addAttribute("c",comicrank);
        return "admin/updatecomicrank";
    }

}
