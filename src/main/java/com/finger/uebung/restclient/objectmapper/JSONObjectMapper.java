package com.finger.uebung.restclient.objectmapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class JSONObjectMapper {

    @Autowired
    private ObjectMapper objectMapper;


    public JSONObjectMapper(){

        defaultConfigs();
    }

    private ObjectMapper getObjectMapper() {

        return objectMapper;

    }

    private void defaultConfigs() {
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter(){

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(this.getObjectMapper());

        return converter;
    }
}
