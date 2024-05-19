package com.example.cross_prog_2;

import io.github.wimdeblauwe.jpearl.InMemoryUniqueIdGenerator;
import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@Configuration
public class DemoApplicationConfiguration {
    @Bean
    public UniqueIdGenerator<UUID> uniqueIdGenerator() {
        return new InMemoryUniqueIdGenerator();
    }

    @Bean
    @RequestScope
    public ServletUriComponentsBuilder urlBuilder() {
        return ServletUriComponentsBuilder.fromCurrentRequest();
    }

}
