package love.tanyiqu.controller;

import love.tanyiqu.mapper.UserMapper;
import love.tanyiqu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    // 直接用mapper了，实际应该用service
    private UserMapper userMapper;

    @Autowired
    public void setMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("all")
    public List<User> all() {
        return userMapper.getUsers();
    }

}
