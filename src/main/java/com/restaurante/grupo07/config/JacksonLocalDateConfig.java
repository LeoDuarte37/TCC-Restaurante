package com.restaurante.grupo07.config;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class JacksonLocalDateConfig {

    private static final String datePattern = "dd/MM/yyyy";
    private static final String dateTimePattern = "dd/MM/yyyy HH:mm";

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer localDateCustomizer() {
        return builder -> {
            builder.simpleDateFormat(dateTimePattern);
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(datePattern)));
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateTimePattern)));
        };
    }
}
