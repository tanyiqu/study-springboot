package love.tanyiqu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class MailApplicationTests {

    @Autowired
    JavaMailSender mailSender;

    @Test
    void simpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("测试主题");
        message.setFrom("1953649096@qq.com");
        message.setTo("15139744921@163.com");
        message.setText("测试 简单消息");
        mailSender.send(message);
    }

    @Test
    void MimeMessage() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 创建helper对象 设置支持多文件
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setSubject("测试复杂邮件~");
        messageHelper.setFrom("1953649096@qq.com");
        messageHelper.setTo("15139744921@163.com");
        messageHelper.setText("<p style='color:blue;'>这是复杂邮件~</p>", true);

        // 设置附件
        messageHelper.addAttachment("11.png", new File("C:\\Users\\Tanyiqu\\Desktop\\1.png"));
        messageHelper.addAttachment("22.png", new File("C:\\Users\\Tanyiqu\\Desktop\\1.png"));

        // 发送
        mailSender.send(mimeMessage);
    }
}
