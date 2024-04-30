package com.example.carparkproject.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
public class AppicationConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
