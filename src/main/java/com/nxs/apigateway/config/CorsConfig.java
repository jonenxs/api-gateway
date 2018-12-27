package com.nxs.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        //是否支持cookie跨域
        config.setAllowCredentials(true);
        //原始域
        config.setAllowedOrigins(Arrays.asList("*"));
        //请求头
        config.setAllowedHeaders(Arrays.asList("*"));
        //300s内不会对相同的请求做跨域检查
        config.setMaxAge(300L);

        source.registerCorsConfiguration("/**",config);
        return new CorsFilter(source);
    }
}
