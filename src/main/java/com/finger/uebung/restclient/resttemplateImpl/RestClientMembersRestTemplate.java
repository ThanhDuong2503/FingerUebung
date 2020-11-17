package com.finger.uebung.restclient.resttemplateImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finger.uebung.constants.URIConstants;
import com.finger.uebung.entities.GitMember;
import com.finger.uebung.restclient.RestClient;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Component
@NoArgsConstructor
public class RestClientMembersRestTemplate implements RestClient {

    private RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(RestClientMembersRestTemplate.class);

    @Autowired
    public RestClientMembersRestTemplate(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;

        restTemplate.getMessageConverters().add(0, this.getMappingJackson2HttpMessageConverter());

    }

    @Override
    public GitMember retrieveOneGitMember() {
        ResponseEntity<GitMember> response = restTemplate.getForEntity("http://localhost:8080/one", GitMember.class);

        if(response.getStatusCode() != HttpStatus.OK){
            logger.error("Resource not found");
        }

        GitMember gitMember = response.getBody();

        return gitMember;
    }

    @Override
    public List<GitMember> retrieveAllGitMembers() {
        ResponseEntity<GitMember[]> gitMemebers = restTemplate.getForEntity(URIConstants.getAllGitMembers(), GitMember[].class);
        if(gitMemebers.getStatusCode() != HttpStatus.OK){
            logger.error("Resource not found");
        }
        GitMember[] gitAllMembers = gitMemebers.getBody();
        return Arrays.asList(gitAllMembers);
    }

    private MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter(){

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();

        mappingJackson2HttpMessageConverter.setObjectMapper(this.getObjectMapper());

        return mappingJackson2HttpMessageConverter;
    }

    private ObjectMapper getObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return objectMapper;
    }

}