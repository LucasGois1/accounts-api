package com.fintech.accountsapi.restapi;

import com.fintech.accountsapi.restapi.configurations.WebServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;


@SpringBootApplication(scanBasePackages = "com.fintech.accountsapi", exclude = {SecurityAutoConfiguration.class})
@Import(WebServerConfig.class)
public class AccountsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApiApplication.class, args);
	}
}
