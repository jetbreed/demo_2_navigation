package com.example.demo;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.faces.webapp.FacesServlet;

@Configuration
public class JsfConfig {

    @Bean
    public ServletRegistrationBean<FacesServlet> facesServlet() {
        // Register the FacesServlet for handling .xhtml extensions
        ServletRegistrationBean<FacesServlet> registrationBean = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
        registrationBean.setLoadOnStartup(1); // Load on startup
        return registrationBean;
    }
}
