package com.news.frugal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

 @Configuration
 @EnableWebMvc
 @ComponentScan({"com.news.frugal"})
 
 public class AppConfig extends WebMvcConfigurerAdapter {

 @Override
 public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    registry.addResourceHandler("/view/**").addResourceLocations("/view/");
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
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
 
 /*public @Bean MongoDbFactory getMongoDbFactory() throws Exception {
     return new SimpleMongoDbFactory(new MongoClient("localhost",27017), "bookguide");
 }

 public @Bean MongoTemplate getMongoTemplate() throws Exception {
     MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory());
     return mongoTemplate;
 }*/
}
