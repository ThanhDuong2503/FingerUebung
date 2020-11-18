package com.finger.uebung.base.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

public class ObjectMapper {

    public static MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(getObjectMapper());

        return mappingJackson2HttpMessageConverter;
    }

    private static com.fasterxml.jackson.databind.ObjectMapper getObjectMapper() {

        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return objectMapper;
    }
}
