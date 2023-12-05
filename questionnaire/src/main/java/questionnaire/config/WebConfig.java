package questionnaire.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("questionnaire.web")
public class WebConfig extends WebMvcConfigurerAdapter {

//    @Autowired
//    private HandlerInterceptor[] interceptors;


    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); // 要求 Dispatcher 将对静态资源的请求转发到 Servlet 容器的默认 servlet
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        super.addResourceHandlers(registry);
    }


//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        for (HandlerInterceptor temp:interceptors) {
//            registry.addInterceptor(temp).addPathPatterns("/managerLogin/**");
//        }
//    }
}
