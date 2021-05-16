package com.example.eTag.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

/**
 * @author Khairul Islam Azam
 * @since 1.0
 */
@Configuration
public class EtagConfig {


    @Bean
    public FilterRegistrationBean<ShallowEtagHeaderFilter> shallowEtagHeaderFilter() {

        FilterRegistrationBean<ShallowEtagHeaderFilter> filterRegistrationBean
                = new FilterRegistrationBean<>(new ShallowEtagHeaderFilter());
        filterRegistrationBean.addUrlPatterns("/list-customer/*");
        filterRegistrationBean.setName("etagFilter");
        return filterRegistrationBean;
    }

}
