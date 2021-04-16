package com.csw.controller;

import com.csw.entity.User;
import com.csw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("login")
    public String LoginAction(User user, String captchaCode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("securityCode");
        System.out.println("code:" + code);
        System.out.println("captchaCode//:" + captchaCode);
        String a = "abc";
        String b = "ABC";
        System.out.println("a.equals(b)://" + a.equals(b));
        System.out.println("code.equals(captchaCode)://" + code.equals(captchaCode));
        User user2 = userService.login(user.getName(), user.getPassword());
        if (user2 != null && code.equals(captchaCode)) {
            return "redirect:/emp/queryAndPage?currPage=1";
        } else {
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("regist")
    public String RegistAction(User user) {
        User user2 = userService.queryBy(user.getName());
        if (user2 != null) {
            return "redirect:/regist.jsp";
        } else {
            userService.addUser(user);
            return "redirect:/login.jsp";
        }
    }
}
