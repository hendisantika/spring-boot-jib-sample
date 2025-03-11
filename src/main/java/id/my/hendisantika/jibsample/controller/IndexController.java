package id.my.hendisantika.jibsample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jib-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 11/03/25
 * Time: 14.03
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
public class IndexController {
    public String index() {
        log.info("Spring Boot Jib Sample {}", LocalDateTime.now());
        return "Spring Boot Jib Sample " + LocalDateTime.now();
    }
}
