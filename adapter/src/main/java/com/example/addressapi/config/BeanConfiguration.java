package com.example.addressapi.config;

import com.example.addressapi.port.AddressRepositoryPort;
import com.example.addressapi.service.AddressService;
import com.example.addressapi.utils.ModelMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BeanConfiguration {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    AddressService customerService(AddressRepositoryPort addressRepository) {
        return new AddressService(addressRepository);
    }

    @Bean
    ModelMapperUtils modelMapperUtils() {
        return new ModelMapperUtils();
    }

    @Bean
    WebClient webClient() {
        return WebClient.create();
    }

}
