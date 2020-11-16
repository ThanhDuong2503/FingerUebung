package com.finger.uebung.restclient.resttemplateImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finger.uebung.constants.URIConstants;
import com.finger.uebung.entities.GitMember;
import com.finger.uebung.restclient.RestClient;
import com.finger.uebung.restclient.objectmapper.JSONObjectMapper;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Component
@NoArgsConstructor
public class RestClientMembersRestTemplate implements RestClient {

    private RestTemplate restTemplate;

    @Autowired
    private JSONObjectMapper jsonObjectMapper;

    Logger logger = LoggerFactory.getLogger(RestClientMembersRestTemplate.class);

    @Autowired
    public RestClientMembersRestTemplate(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
        restTemplate.getMessageConverters().add(0, jsonObjectMapper.getMappingJackson2HttpMessageConverter());

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

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        RestClientMembersRestTemplate restClientMembersRestTemplate = new RestClientMembersRestTemplate(restTemplate);
        System.out.println(restClientMembersRestTemplate.retrieveAllGitMembers());
    }

}