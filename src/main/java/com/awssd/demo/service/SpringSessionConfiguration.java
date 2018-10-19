package com.awssd.demo.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.events.SessionCreatedEvent;
import org.springframework.session.events.SessionDeletedEvent;
import org.springframework.session.events.SessionExpiredEvent;
import org.springframework.session.web.http.DefaultCookieSerializer;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
  * session整合配置类
  *
  */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 20)
public class SpringSessionConfiguration {
    private final static Log log = LogFactory.getLog(SpringSessionConfiguration.class);
    // 程序启动时可以在控制台中输出这句话
    public SpringSessionConfiguration() {
        log.info("MySessionListenerInitialized");
    }
    @EventListener
    public void onSessionExpired(SessionExpiredEvent expiredEvent) {
        log.info("onSessionExpired");

    }
    @EventListener
    public void onSessionDeleted(SessionDeletedEvent deletedEvent) {
        String sessionId = deletedEvent.getSessionId();
        log.info("onSessionExpired");

    }
    @EventListener
    public void onSessionCreated(SessionCreatedEvent createdEvent) {
        String sessionId = createdEvent.getSessionId();
        log.info("onSessionCreated");
    }
}
