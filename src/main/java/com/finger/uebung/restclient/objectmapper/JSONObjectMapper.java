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

    @Autowired
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;


    public JSONObjectMapper(){

        defaultConfigs();
    }

    private void defaultConfigs() {
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter(){

        mappingJackson2HttpMessageConverter.setObjectMapper(this.objectMapper);

        return mappingJackson2HttpMessageConverter;
    }
}