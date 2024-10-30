package com.mhd.manhuadui.web;


import com.mhd.manhuadui.Pojo.Feedback;
import com.mhd.manhuadui.Pojo.User;
import com.mhd.manhuadui.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.rsocket.context.LocalRSocketServerPort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
//@SessionAttributes(value = {"username","userpassword","u_id"})
public class UserController {
     @Autowired
     private UserService userService;

    /**
     * 注册用户
     * @return
     */
    @PostMapping("/UserRegister")
    public String UserRegister(User user, Map<Object,Object> map, HttpServletRequest request, RedirectAttributes attributes,Model model) {
        user.setUsername(request.getParameter("username"));
        user.setUserpassword(request.getParameter("userpassword"));
        //判断用户名是否相同
        if(userService.getUsername(user).toString().equals("[]")&&request.getParameter("username")!="") {
            userService.SaveUser(user);
            System.out.println("用户注册成功");

            //按姓名进行查找
            List<User> Userlist=userService.getUsername(user);
            int u_id = Userlist.get(0).getU_id();
            String username = user.getUsername();
            String userpassword = user.getUserpassword();

            map.put("u_id",u_id);
            map.put("username",username);
            map.put("userpassword",userpassword);

            return "login";
        }
        else {
            System.err.println("用户注册失败");
            model.addAttribute("error","用户注册失败,已有该用户名");
            return "register";
        }
    }


    /**
     * 用户登录验证
     * @return
     */
    @PostMapping("Userlogin")
    public String UserLogin(@Valid @ModelAttribute User user,
                            Model model,
                            Map<Object,Object> map,
                            HttpServletRequest request,
                            HttpSession session,
                            RedirectAttributes attributes
    ) throws Exception {
        user.setUsername(request.getParameter("username"));
        user.setUserpassword(request.getParameter("userpassword"));
        List<User> list=userService.getUser(user);
        //根据用户名密码查询
        if(!list.toString().equals("[]")) {
            int u_id = list.get(0).getU_id();
            String username = list.get(0).getUsername();
            String userpassword = list.get(0).getUserpassword();

            //  map.put("u_id",u_id);
           //   map.put("username",username);
           //   map.put("userpassword",userpassword);

            user.setU_id(u_id);
            user.setUsername(username);
            user.setUserpassword(userpassword);

            System.out.println("用户"+username+"登录成功");
          //  model.addAttribute("map",user);
            session.setAttribute("user",user);
            session.setAttribute("u_id",u_id);
            // attributes.addFlashAttribute("map",user);

            //用户成功登录后跳转到首页，防止表单重复提交
             return "redirect:/";


        } else {
            System.err.println("用户" + user.getUsername() + "登录失败");
            model.addAttribute("error", "用户名或者密码错误");
            return "login";
        }
    }



    /**
     * 用户注销
     * @return
     */
    @GetMapping("/UserLoginout")
    public String UserLoginout(HttpSession session,HttpServletRequest request) {
        session.removeAttribute("user");
        return "redirect:/login";
    }

    /**
     * 修改用户名
     * @param model
     * @param
     * @return
     */
    @GetMapping("/UpdateUsername")
    public String UpdateUsername(User user,HttpServletRequest request,Model model,RedirectAttributes attributes) {
        int u_id=(Integer.parseInt(request.getParameter("u_id"))) ;
        String username = request.getParameter("username");
        user.setU_id(u_id);
        user.setUsername(username);

        if(userService.getUsername(user).toString().equals("[]")&&request.getParameter("username")!=null) {
            userService.updateUsername(user);
            System.out.println("修改用户名"+user.getUsername()+"成功");
            //    model.addAttribute("message","修改用户名成功");
            attributes.addFlashAttribute("message","用户名修改成功");
            return "redirect:/info";
        }
        else  {
            attributes.addFlashAttribute("error","该用户名已注册，请更换别的用户名");
            return "redirect:/info";
        }
    }

    /**
     * 修改密码
     * @param
     * @param session
     * @return
     */
    @PostMapping("/UpdatePassword")
    public String UpdatePassword(HttpSession session,User user,RedirectAttributes attributes,
                                 HttpServletRequest request) {
        int u_id = Integer.parseInt(request.getParameter("u_id"));
        String newpass = request.getParameter("newpass");
        String mpass = request.getParameter("mpass");
        //    user.setU_id(u_id);
        //    user.setUserpassword(mpass);
        String password = userService.getPassword(u_id);
       // if (password.equals("[]")&& password.equals(mpass)) {
            user.setU_id(u_id);
            user.setUserpassword(newpass);
            userService.updatePassword(user);
            System.out.println("用户密码" + user.getUserpassword() + "修改成功");
            attributes.addFlashAttribute("message", "用户名密码修改成功");
            return "redirect:/password";
     //   }
     //   System.err.println("用户的正确密码为:"+password);
     //   System.err.println("修改失败获得输入原密码"+mpass);
     //   System.err.println("修改失败获得输入新密码"+newpass);
     //   attributes.addFlashAttribute("error","原始密码不匹配");
      //  return "redirect:/password";
    }



     @GetMapping("/u")
    public String myinfohome(Model model,HttpSession session) {
      //   int id=(int) session.getAttribute("u_id");
      //   model.addAttribute("id",id);
         return  "myinfohome";
     }

     @GetMapping("/info")
    public String info(HttpSession session,Model model) throws Exception {
         int u_id=(int) session.getAttribute("u_id");
         List<User> userList=userService.getU_id(u_id);
         model.addAttribute("userList",userList.get(0));
         return "info";
     }

     @GetMapping("/password")
    public String password(HttpSession session,Model model) throws Exception {
         //获取session中的id
         int u_id = (int) session.getAttribute("u_id");
         //根据id查找信息
         List<User> userList=userService.getU_id(u_id);
         model.addAttribute("userList",userList.get(0));
         return "updatepassword";
     }

     @GetMapping("/history")
    public String history() {
         return  "history";
     }
     //跳转到提交反馈的页面
     @GetMapping("/feedback")
    public String feedback() {
         return "feedback";
     }
    /**
     * 提交反馈
     */
     @GetMapping("/addfeedback")
     public String addfeedback(@RequestParam String textfile,
                               RedirectAttributes attributes,HttpSession session) {
         Feedback f = new Feedback();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date date = new Date();
         String createtime = sdf.format(date);
         int u_id = (Integer)session.getAttribute("u_id");
         String username = userService.getUsername(u_id);
         f.setU_id(u_id);
         f.setCreatetime(createtime);
         f.setTextfield(textfile);
         f.setUsername(username);
         userService.Insertfeedback(f);
         attributes.addFlashAttribute("message","反馈成功");
         return  "redirect:/feedback";
     }
}
