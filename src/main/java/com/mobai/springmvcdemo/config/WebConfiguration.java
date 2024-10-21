package com.mobai.springmvcdemo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableWebMvc   //快速配置SpringMvc注解，如果不添加此注解会导致后续无法通过实现WebMvcConfigurer接口进行自定义配置
@ComponentScans({
        @ComponentScan("com.mobai.springmvcdemo.entity"),
        @ComponentScan("com.mobai.springmvcdemo.controller"),
        @ComponentScan("com.mobai.springmvcdemo.service"),
})
@MapperScan("com.mobai.springmvcdemo.mapper")
public class WebConfiguration implements WebMvcConfigurer {
  //我们需要使用ThymeleafViewResolver作为视图解析器，并解析我们的HTML页面
  @Bean
  public ThymeleafViewResolver thymeleafViewResolver(SpringTemplateEngine springTemplateEngine) {
    ThymeleafViewResolver resolver = new ThymeleafViewResolver();
    resolver.setOrder(1);   //可以存在多个视图解析器，并且可以为他们设定解析顺序
    resolver.setCharacterEncoding("UTF-8");   //编码格式是重中之重
    resolver.setTemplateEngine(springTemplateEngine);   //和之前JavaWeb阶段一样，需要使用模板引擎进行解析，所以这里也需要设定一下模板引擎
    return resolver;
  }

  //配置模板解析器
  @Bean
  public SpringResourceTemplateResolver templateResolver() {
    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
    resolver.setSuffix(".html");   //需要解析的后缀名称
    resolver.setPrefix("/");   //需要解析的HTML页面文件存放的位置，默认是webapp目录下，如果是类路径下需要添加classpath:前缀
    return resolver;
  }

  //配置模板引擎Bean
  @Bean
  public SpringTemplateEngine springTemplateEngine(ITemplateResolver resolver) {
    SpringTemplateEngine engine = new SpringTemplateEngine();
    engine.setTemplateResolver(resolver);   //模板解析器，默认即可
    return engine;
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();   //开启默认的Servlet
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    //配置静态资源的访问路径
  }

  @Bean   //单独创建一个Bean，方便之后更换
  public DataSource dataSource(){
    return new PooledDataSource("com.mysql.cj.jdbc.Driver",
            "jdbc:mysql://localhost:3306/SpringMVCDemo", "root", "mobaisilent");
  }

  @Bean
  public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){  //直接参数得到Bean对象
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    return bean;
  }
}