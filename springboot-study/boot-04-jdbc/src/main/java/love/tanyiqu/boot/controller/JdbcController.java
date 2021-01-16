package love.tanyiqu.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/getUsers")
    public List<Map<String, Object>> getUsers() {
        String sql = "select * from user";

        List<Map<String, Object>> users = jdbcTemplate.queryForList(sql);

        return users;
    }

    @GetMapping("/addUser")
    public String addUSer() {
        String sql = "insert into user(id, name, age, sex) value (4, '张四', 19 , '女')";
        jdbcTemplate.update(sql);
        return "添加成功";
    }

}
