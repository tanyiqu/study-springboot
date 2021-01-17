package love.tanyiqu.service.impl;

import love.tanyiqu.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    public void doSth() {
        // 模拟延时操作
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("已完成");
    }

    @Override
    @Async
    public void doAsync() {
        System.out.println("正在处理");
        // 模拟延时操作
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
