package com.mission.manager_app;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Configuration
public class thymeleafConfig {
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}

