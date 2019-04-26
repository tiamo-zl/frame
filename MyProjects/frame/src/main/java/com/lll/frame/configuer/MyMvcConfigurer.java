package com.lll.frame.configuer;

import com.lll.frame.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * MyMvcConfigurer
 * mvc
 * @Author: ZL
 * @CreateTime: 2019-02-25 17:18
 */
@Configuration
public class MyMvcConfigurer extends WebMvcConfigurationSupport{

    @Autowired
    private UserInterceptor userInterceptor;

    // 以下WebMvcConfigurationSupport 比较常用的重写接口
    // /** 解决跨域问题 **/
    // public void addCorsMappings(CorsRegistry registry) ;
    // /** 添加拦截器 **/
    // void addInterceptors(InterceptorRegistry registry);
    // /** 这里配置视图解析器 **/
    // void configureViewResolvers(ViewResolverRegistry registry);
    // /** 配置内容裁决的一些选项 **/
    // void configureContentNegotiation(ContentNegotiationConfigurer
    // configurer);
    // /** 视图跳转控制器 **/
    // void addViewControllers(ViewControllerRegistry registry);
    // /** 静态资源处理 **/
    // void addResourceHandlers(ResourceHandlerRegistry registry);
    // /** 默认静态资源处理器 **/
    // void configureDefaultServletHandling(DefaultServletHandlerConfigurer
    // configurer);

    /**
     * 表示这些配置的表示静态文件所处路径， 不用拦截
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/templates/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor)
                // addPathPatterns 用于添加拦截规则 ， 先把所有路径都加入拦截， 再一个个排除
                .addPathPatterns("/api/**")
                // excludePathPatterns 表示改路径不用拦截
                .excludePathPatterns("/");
        super.addInterceptors(registry);
    }

}
