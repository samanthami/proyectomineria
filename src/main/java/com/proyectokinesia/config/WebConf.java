package com.proyectokinesia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConf implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("https://mineriaproyecto.herokuapp.com/mineria")
                .allowCredentials(true)
                .allowedMethods("*")
                .maxAge(3600);
    }
}
