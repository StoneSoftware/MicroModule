package org.springboot.springmvc.mybatis.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfigFilter
{
    /*
     * @Bean public CorsFilter corsFilter() { UrlBasedCorsConfigurationSource
     * source = new UrlBasedCorsConfigurationSource(); CorsConfiguration config
     * = new CorsConfiguration(); config.setAllowCredentials(true);
     * config.addAllowedOrigin("http://localhost:9000");
     * config.addAllowedOrigin("null"); config.addAllowedHeader("*");
     * config.addAllowedMethod("*"); source.registerCorsConfiguration("/**",
     * config); // CORS 配置对所有接口都有效 CorsFilter corsFilter = new
     * CorsFilter(source); return corsFilter; }
     */
}
