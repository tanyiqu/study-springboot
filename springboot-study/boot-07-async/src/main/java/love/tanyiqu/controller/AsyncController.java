package love.tanyiqu.controller;

import love.tanyiqu.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    AsyncService asyncService;

    @Autowired
    public void setAsyncService(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    // 普通的延时操作，用户需要等待3秒
    @GetMapping("/do")
    public String doAsync() {
        // 一个延时操作
        asyncService.doSth();
        return "已完成";
    }

    // 延时任务
    @GetMapping("/async")
    public String async() {
        // 一个延时操作
        asyncService.doAsync();
        return "正在处理...";
    }

}
