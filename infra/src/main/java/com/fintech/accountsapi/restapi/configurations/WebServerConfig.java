package com.fintech.accountsapi.restapi.configurations;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.fintech.accountsapi")
@EnableJpaRepositories(basePackages = "com.fintech.accountsapi.repository")
@EntityScan("com.fintech.accountsapi.repository.postgresql.entities")
public class WebServerConfig extends SpringBootServletInitializer {
}
