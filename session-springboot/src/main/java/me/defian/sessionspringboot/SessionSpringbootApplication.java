package me.defian.sessionspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@SpringBootApplication
public class SessionSpringbootApplication {

    public static void main(String[] args) {
        System.out.println("Hello world");
        SpringApplication.run(SessionSpringbootApplication.class, args);
    }

}
