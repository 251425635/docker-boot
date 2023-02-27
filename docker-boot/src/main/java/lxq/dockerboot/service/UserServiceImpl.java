package lxq.dockerboot.service;

import lxq.dockerboot.mapper.UserMapper;
import lxq.dockerboot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Yikair
 * @Create 2023/2/24 22:15
 * @Description
 */
@Service
public class UserServiceImpl implements UserService{

    public static final String REDISKEY_USER = "user." ;

    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisService redisService;
    /**
     * @param id
     * @return
     */
    @Override
    public User findUserById(Integer id) {
        User user = new User();
        String key = REDISKEY_USER + id;
        user = (User)redisService.get(key);
        // redis 没有则去 mysql 找
        if (user == null){
            user = userMapper.getUserById(id);
            if (user == null){
                return user;
            }else {
                // 回写到 redis
                redisService.set(key, user);
            }
        }
        return user;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public void addUser(User user) {
        // 入库
        int i = userMapper.addUser(user);
        if (i > 0){
             user = userMapper.getUserById(user.getId());
            String key = REDISKEY_USER + user.getId();
            // 存 redis (保证和数据库一致性)
            redisService.set(key, user);
        }

    }
}
