package com.restaurante.grupo07.utils;

import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

public class StringToUUIDConverter implements Converter<String, UUID> {

    @Override
    public UUID convert(String source) {
        return UUID.fromString(source);
    }
}
