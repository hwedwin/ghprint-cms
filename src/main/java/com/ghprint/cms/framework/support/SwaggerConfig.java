package com.ghprint.cms.framework.support;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableSwagger
@EnableWebMvc
@ComponentScan(basePackages = {"com.ghprint.cms.controller"})
public class SwaggerConfig {



    private SpringSwaggerConfig springSwaggerConfig;
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig)
    {
        this.springSwaggerConfig = springSwaggerConfig;
    }
    @Bean
    public SwaggerSpringMvcPlugin swaggerSpringMvcPlugin() {
        return new SwaggerSpringMvcPlugin(springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns(".*?");

    }
    private ApiInfo apiInfo()
    {
        ApiInfo apiInfo = new ApiInfo(
                "My Apps API Title",
                "My Apps API Description",
                "My Apps API terms of service",
                "My Apps API Contact Email",
                "My Apps API Licence Type",
                "My Apps API License URL");
        return apiInfo;
    }
}