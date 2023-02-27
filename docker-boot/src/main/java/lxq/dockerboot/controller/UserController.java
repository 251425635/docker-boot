package lxq.dockerboot.controller;

import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lxq.dockerboot.entities.User;
import lxq.dockerboot.service.RedisService;
import lxq.dockerboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

/**
 * @Author Yikair
 * @Create 2023/2/24 21:59
 * @Description
 */
@RestController
@RequestMapping(value = "/user")
@Api(tags = "用户管理", description = "用户user接口")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    RedisService redisService;

    @ApiOperation("数据库新增用户数据")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser() {
        Date date = new Date();
        Timestamp timeStamep = new Timestamp(date.getTime());

        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setUsername("lxq" + i);
            user.setPassword(IdUtil.simpleUUID().substring(0, 6));
            user.setSex((byte) new Random().nextInt(2));
            userService.addUser(user);
        }

    }

    @ApiOperation("数据库查询用户数据")
    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable Integer id) {
        User user = userService.findUserById(id);
        return user;
    }
}
