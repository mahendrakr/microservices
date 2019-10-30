package com.javathesimpleway.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javathesimpleway.ioc.A;
import com.javathesimpleway.ioc.B;
import com.javathesimpleway.ioc.Hello;

@Configuration
public class AppConfig {
@Bean
public A getBeanA() {
	return new A();
}

@Bean
public B getBeanB() {
	return new B();
}

@Bean
public Hello getBeanHello() {
	Hello hello = new Hello();
	hello.setAobj(getBeanA());
	hello.setBobj(getBeanB());
	return hello;
}

}
