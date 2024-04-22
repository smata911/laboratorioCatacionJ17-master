package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.config;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.utils.SortingPagingUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

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
    public SortingPagingUtils sortingPagingUtils(){
        return new SortingPagingUtils();
    }


}
