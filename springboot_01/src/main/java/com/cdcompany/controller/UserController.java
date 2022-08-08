package com.cdcompany.controller;

import com.cdcompany.domain.User;
import com.cdcompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.Origin;
import org.springframework.web.bind.annotation.*;

//2.定义Controller
//2.1使用@Controller定义bean
//@Controller
//@ResponseBody
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    /*
        1.登录用户操作
    */
    //2.2设置当前操作的访问路径
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @CrossOrigin
    //2.3设置当前操作的返回值类型, @RequestBody User user@RequestParam("username") String loginName@RequestParam("password") String loginPsw+loginPsw
    public Result login(User user){
        //int a;
        /*User user = new User();
        //获取用户输入的姓名和密码
        user.setUsername(loginName);
        user.setPassword(loginPsw);*/
        //flag判断是否登录成功
        boolean flag = userService.findUser(user);
        System.out.println("user login success !!! username==="+user.getUsername()+"   password==="+user.getPassword());
        if(flag){
            System.out.println("登录成功");
            return new Result(0);
        }else{
            System.out.println("登录失败");
            return new Result(-1);
        }
        //return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR);
    }

    /*
        2.添加用户操作
    */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    //   @CrossOrigin
    public String add(@RequestParam("username") String loginName,@RequestParam("password") String loginPsw){
        User user = new User();
        user.setUsername(loginName);
        user.setPassword(loginPsw);
        System.out.println("user add name==="+loginName+"   password==="+loginPsw);
        boolean flagFindUser = userService.findUser(user);
        if(flagFindUser){
            System.out.println("添加失败,用户已存在");
            //a = 0;
            return "{'false!!! The user already exist !!!'}";
        }else{
            boolean flag = userService.addUser(user);
            if(flag){
                System.out.println("添加成功");
                return "{'true'}";
            }else{
                System.out.println("添加失败");
                return "{'false'}";
            }
        }
    }

    /*
        3.删除用户操作
    */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    //   @CrossOrigin
    public String delete(@RequestParam("username") String loginName,@RequestParam("password") String loginPsw) {
        User user = new User();
        //user.setName(loginName);
        user.setPassword(loginPsw);
        System.out.println("user delete name===" + loginName + "   password===" + loginPsw);
        boolean flagFindUser = userService.findUser(user);
        if (flagFindUser) {
            boolean flag = userService.deleteUser(user);
            if (flag) {
                System.out.println("删除成功");
                return "{'true'}";
            } else {
                System.out.println("删除失败");
                return "{'false'}";
            }
        } else {
            System.out.println("删除失败,用户不存在");
            //a = 0;
            return "{'false!!! The user not exist !!!'}";
        }
    }

    /*
        4.更改用户信息操作
    */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @CrossOrigin
    public String update(@RequestParam("username") String loginName,@RequestParam("password") String loginPsw) {
        User user = new User();
        //user.setName(loginName);
        user.setPassword(loginPsw);
        System.out.println("user update name===" + loginName + "   password===" + loginPsw);
        boolean flag = userService.updateUser(user);
        if (flag) {
            System.out.println("更改用户信息成功");
            return "{'true'}";
        } else {
            System.out.println("更改用户信息失败,用户不存在");
            return "{'false!!! The user not exist !!!'}";
        }
    }
}
