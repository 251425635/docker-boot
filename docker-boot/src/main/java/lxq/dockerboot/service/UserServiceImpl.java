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

    @Autowired
    UserMapper userMapper;
    /**
     * @param id
     * @return
     */
    @Override
    public User getUser(String id) {
        return userMapper.getUserById(id);
    }

    /**
     * @param user
     * @return
     */
    @Override
    public int insertUser(User user) {

        return userMapper.Insert(user);
    }
}
