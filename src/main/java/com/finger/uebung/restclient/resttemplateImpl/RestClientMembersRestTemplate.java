package com.finger.uebung.restclient.resttemplateImpl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finger.uebung.constants.URIConstants;
import com.finger.uebung.entities.GitMember;
import com.finger.uebung.entities.GitMemberDetails;
import com.finger.uebung.entities.GitMemberRepo;
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

import java.util.*;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class RestClientMembersRestTemplate implements RestClient {

    private RestTemplate restTemplate;
    private List<GitMember> gitAllMembersFilled;
    Logger logger = LoggerFactory.getLogger(RestClientMembersRestTemplate.class);

    @Autowired
    public RestClientMembersRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        restTemplate.getMessageConverters().add(0, this.getMappingJackson2HttpMessageConverter());
    }

    @Override
    public GitMember retrieveOneGitMember() {

        ResponseEntity<GitMember> response = restTemplate.getForEntity("http://localhost:8080/one", GitMember.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            logger.error("Resource not found");
        }
        GitMember gitMember = response.getBody();
        return gitMember;
    }

    @Override
    public List<GitMember> retrieveAllGitMembers() {

        ResponseEntity<GitMember[]> gitMembers = restTemplate.getForEntity(URIConstants.getAllGitMembers(), GitMember[].class);

        if (gitMembers.getStatusCode() != HttpStatus.OK) {
            logger.error("Resource not found");
        }

        GitMember[] gitAllMembers = gitMembers.getBody();
        fillGitAllMembers(gitAllMembers);

        return gitAllMembersFilled;
    }

    private void fillGitAllMembers(GitMember[] gitAllMembers) {

        gitAllMembersFilled = Arrays.asList(gitAllMembers);
        gitAllMembersFilled.stream().map(
                member -> {
                    member.setGitMemberDetails(retrieveGitMemberDetails(member.getUrl()));
                    member.setGitMemberRepos(retrieveAllGitRepositoriesForOneMember(member.getRepos_url()));
                    return member;
                }).collect(Collectors.toList());
    }

    private GitMemberDetails retrieveGitMemberDetails(String URLgitMemberDetails) {

        ResponseEntity<GitMemberDetails> gitMemberDetails = restTemplate.getForEntity(URLgitMemberDetails, GitMemberDetails.class);

        if (gitMemberDetails.getStatusCode() != HttpStatus.OK) {
            logger.error("Resource not found");
        }

        return gitMemberDetails.getBody();
    }

    private List<GitMemberRepo> retrieveAllGitRepositoriesForOneMember(String URLgitRepository) {

        ResponseEntity<GitMemberRepo[]> gitRepositories = restTemplate.getForEntity(URLgitRepository, GitMemberRepo[].class);

        if (gitRepositories.getStatusCode() != HttpStatus.OK) {
            logger.error("Resource not found");
        }

        GitMemberRepo[] gitMemberRepositories = gitRepositories.getBody();

        return Arrays.asList(gitMemberRepositories);
    }

    private MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(this.getObjectMapper());

        return mappingJackson2HttpMessageConverter;
    }

    private ObjectMapper getObjectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return objectMapper;
    }
}