package lxq.dockerboot.service;

import lxq.dockerboot.entities.User;

/**
 * @Author Yikair
 * @Create 2023/2/24 22:14
 * @Description
 */
public interface UserService {
    User getUser(String id);
    int insertUser(User user);
}
