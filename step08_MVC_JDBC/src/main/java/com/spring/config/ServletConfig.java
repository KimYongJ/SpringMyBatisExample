//// servlet-context.xml을 java로 바꿔주는 것
//package com.spring.config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//
//@Configuration // 먼저 어노테이션을 선언해야 한다.
//@EnableWebMvc // MVC패턴을 설정하기 위해서 해당 어노테이션을 설정해야 한다.
//@ComponentScan(basePackages = {"com.spring.jdbc"}) // servlet-context.xml의<context:component-scan>이부분을 재정의 하는것
//public class ServletConfig implements WebMvcConfigurer{
//	//servlet-context.xml의 <resources mapping="/resources/**" location="/resources/" /> 이것을 재정의 하는것
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//	}
//	//servlet-context.xml의<beans:bean> 재정의
//	@Bean
//	public InternalResourceViewResolver resolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setViewClass(JstlView.class);
//		resolver.setPrefix("/WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
//	
//	
//	
//
//}
