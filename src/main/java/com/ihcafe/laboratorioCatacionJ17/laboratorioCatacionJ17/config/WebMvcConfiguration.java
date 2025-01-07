package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.config;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils.SortingPagingUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration {

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("static/messages");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200","https://5eec-138-0-229-20.ngrok-free.app") // Asegúrate de que la URL de ngrok esté aquí
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*") // Permite todos los encabezados
                        .allowCredentials(true); // Permite enviar credenciales
            }
        };
    }

    @Bean
    public SortingPagingUtils sortingPagingUtils(){
        return new SortingPagingUtils();
    }


}
