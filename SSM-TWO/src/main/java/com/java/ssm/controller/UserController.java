package com.java.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.java.ssm.pojo.User;
import com.java.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService ;

    @RequestMapping(value = "/text/list/page/{pageNumber}" , method = RequestMethod.GET)
    public String getListPage(@PathVariable("pageNumber")  Integer pageNumber , Model model) {
        //获取员工分页信息
        PageInfo<User> page = userService.getUserPage(pageNumber) ;
        //将分页数据共享到请求域中
        model.addAttribute("page" , page);
        //跳转页面
        return "List" ;
    }

    @RequestMapping(value = "/text/list" , method = RequestMethod.GET)
    public String getList(Model model) {
        List<User> list = userService.getList();
        model.addAttribute("list" , list);
        return "List" ;
    }

    @RequestMapping(value = "/text/login" , method = RequestMethod.POST)
    public String getUser(String username , String password) {
        System.out.println("username "+username);
        System.out.println("password "+password);
        User user = userService.getUser(username, password);
        if(user == null) {
            return "ERRO" ;
        }
        return "redirect:/text/list/page/1" ;
    }

    @RequestMapping("/text/register")
    public String register(User user ) {
        System.out.println("user "+user);
        Integer i = userService.insert(user);
        if (i >= 1){
            return "redirect:/text/list/page/1" ;
        }
        return "ERRO" ;
    }

    @RequestMapping("/text/delete/{id}")
    public String delete( @PathVariable("id") Integer id) {
        System.out.println(id);
        Integer i = userService.delete(id);
        if( i>= 1) {
            return "redirect:/text/list/page/1" ;
        }
        return "ERRO" ;
    }

    @RequestMapping("/text/getUserById/{id}")
    public String getUserById(@PathVariable("id") Integer id , Model model) {
        User user = userService.getUserById(id);
        System.out.println(user);
        model.addAttribute("user" , user);
        return "update" ;
    }

    @RequestMapping("/text/update")
    public String update(User user) {
        System.out.println("user "+user);
        Integer update = userService.update(user);
        if(update >= 1) {
            return "redirect:/text/list/page/1" ;
        }
        return "ERRO" ;
    }
}
