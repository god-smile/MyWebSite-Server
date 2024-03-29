package com.zxcv.portal.config.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 35*60 )//设置登录失效时间 35分钟
public class HttpSessionConfig {

    @Bean
    public static HeaderHttpSessionIdResolver xAuthToken() {
        return new HeaderHttpSessionIdResolver("X-Auth-Token");
    }

    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }
}



