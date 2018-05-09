
package com.jk.controller;

import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author zlh
 * @create 2018/4/27
 * @since 1.0.0
 */
@Controller
@RequestMapping("userController")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询list集合
     * @return
     */
    @RequestMapping("selectUserList")
    @ResponseBody
    public List<User> selectUserList(){
        List<User> list=userService.selectUser();
        return list;
    }

    @RequestMapping("userjsp")
    public String  userjsp(){
        return "user.jsp";
    }

}