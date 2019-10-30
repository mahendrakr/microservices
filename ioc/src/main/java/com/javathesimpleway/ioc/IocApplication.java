package com.javathesimpleway.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.javathesimpleway.ioc.config.AppConfig;

//@ImportResource("config.xml")
@SpringBootApplication
@Import(AppConfig.class)
public class IocApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(IocApplication.class, args);
		Hello bean = run.getBean(Hello.class);
		bean.show();
		
	}

}
