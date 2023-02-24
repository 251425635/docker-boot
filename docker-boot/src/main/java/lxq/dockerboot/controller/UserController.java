package lxq.dockerboot.controller;

import lxq.dockerboot.pojo.User;
import lxq.dockerboot.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author Yikair
 * @Create 2023/2/24 21:59
 * @Description
 */
@MapperScan("lxq/dockerboot/dao")
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/insertUser")
    public void insert() {
        Date date = new Date();
        Timestamp timeStamep = new Timestamp(date.getTime());

        User user = new User();
        user.setUsername("lxq2");
        user.setPassword("12345");
        user.setSex(0);
        user.setDeleted(0);
        user.setCreate_time(timeStamep);
        user.setUpdate_time(timeStamep);

        userService.insertUser(user);
    }
    @GetMapping(value = "/selectUser")
    public void getUser()
    {

        User user= userService.getUser("1");
        System.out.println(user);
    }
}
