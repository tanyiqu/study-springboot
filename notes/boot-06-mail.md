# Springboot 发送邮件

## 依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

<br>

## 配置

properties

```properties
spring.mail.username=1953649096@qq.com
spring.mail.password=halsrbvvkvkqcaga
spring.mail.host=smtp.qq.com
# 如果是QQ邮箱，需要添加下面这个
spring.mail.properties.mail.smtp.ssl.enable=true
```

<br>

yml

```yml
spring:
  mail:
    username: 1953649096@qq.com
    password: halsrbvvkvkqcaga
    host: smtp.qq.com
    properties:
      # 如果是QQ邮箱，需要添加这个
      mail.smtp.ssl.enable: true
```

<br>

## 测试

```java
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
```

