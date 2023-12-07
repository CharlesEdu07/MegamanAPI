package com.charlesedu.megamanapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    // @Bean
    // public WebMvcConfigurer corsConfigurer() {
    // return new WebMvcConfigurer() {
    // @Override
    // public void addCorsMappings(CorsRegistry registry) {
    // registry.addMapping("/**")
    // .allowedOrigins("https://megaman-speedrun-81ua.vercel.app",
    // "http://localhost:3000")
    // .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE",
    // "CONNECT",
    // "OPTIONS")
    // .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept",
    // "Authorization",
    // "Access-Control-Allow-Origin", "Access-Control-Allow-Headers",
    // "Access-Control-Allow-Methods", "Access-Control-Allow-Credentials")
    // .exposedHeaders("Authorization")
    // .exposedHeaders("Access-Control-Allow-Origin",
    // "Access-Control-Allow-Headers",
    // "Access-Control-Allow-Methods", "Access-Control-Allow-Credentials")
    // .maxAge(3600)
    // .allowCredentials(true);
    // }
    // };
    // }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://megaman-speedrun-81ua.vercel.app", "http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT",
                        "OPTIONS")
                .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization",
                        "Access-Control-Allow-Origin", "Access-Control-Allow-Headers",
                        "Access-Control-Allow-Methods", "Access-Control-Allow-Credentials")
                .exposedHeaders("Authorization")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Headers",
                        "Access-Control-Allow-Methods", "Access-Control-Allow-Credentials")
                .allowCredentials(true);
    }
}
