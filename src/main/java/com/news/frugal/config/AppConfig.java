package com.news.frugal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

 @Configuration
 @EnableWebMvc
 @ComponentScan({"com.news.frugal"})
// @EnableMongoRepositories 
 public class AppConfig extends WebMvcConfigurerAdapter {

 @Override
 public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    registry.addResourceHandler("/view/**").addResourceLocations("/view/");
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");	
    registry.addResourceHandler("/modules/**").addResourceLocations("/modules/");
 }

 @Bean
 public ViewResolver configureViewResolver() {
     InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
     viewResolve.setPrefix("/WEB-INF/views/");
     viewResolve.setSuffix(".jsp");
     return viewResolve;
 }

 @Override
 public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
   configurer.enable();
 }
 
 @Bean
 public MultipartResolver multipartResolver(){
     CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
     commonsMultipartResolver.setDefaultEncoding("utf-8");
     return commonsMultipartResolver;
 }
 
}
