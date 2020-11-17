package com.finger.uebung.restclient.resttemplateImpl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finger.uebung.constants.URIConstants;
import com.finger.uebung.entities.GitMember;
import com.finger.uebung.entities.GitMemberDetails;
import com.finger.uebung.entities.GitMemberRepo;
import com.finger.uebung.restclient.RestClient;
import com.finger.uebung.restclient.webclientImpl.RestClientMembersWebClient;
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
public class RestClientMembersRestTemplate implements RestClient {

    private RestTemplate restTemplate;
    private List<GitMember> gitMembers;

    Logger logger = LoggerFactory.getLogger(RestClientMembersRestTemplate.class);

    public RestClientMembersRestTemplate(){
        retrieveAllGitMembers();
    }

    @Autowired
    public RestClientMembersRestTemplate(RestTemplate restTemplate) {

        super();
        this.restTemplate = restTemplate;
        restTemplate.getMessageConverters().add(0, this.getMappingJackson2HttpMessageConverter());

    }

    public GitMember retrieveGitMemberByName(String fullName) {

        Optional<GitMember> gitMember = gitMembers.stream()
                .filter(e -> e.getGitMemberDetails().getName().equals(fullName))
                .findFirst();

        return gitMember.orElse(null);
    }

    @Override
    public List<GitMember> retrieveAllGitMembers() {

        GitMember[] gitAllMembers = retrieveGitMembersBasicData();
        setGitMembersDetailsAndRepos(gitAllMembers);

        return gitMembers;
    }

    private GitMember[] retrieveGitMembersBasicData() {

        ResponseEntity<GitMember[]> gitMembers = restTemplate.getForEntity(URIConstants.getAllGitMembers(), GitMember[].class);

        if (gitMembers.getStatusCode() != HttpStatus.OK) {
            logger.error("Resource not found");
        }

        GitMember[] gitAllMembers = gitMembers.getBody();

        return gitAllMembers;
    }

    private GitMemberDetails retrieveGitMemberDetails(String uriGitMemberDetails) {

        ResponseEntity<GitMemberDetails> gitMemberDetails = restTemplate.getForEntity(uriGitMemberDetails, GitMemberDetails.class);

        if (gitMemberDetails.getStatusCode() != HttpStatus.OK) {
            logger.error("Resource not found");
        }

        return gitMemberDetails.getBody();
    }

    private List<GitMemberRepo> retrieveGitMemberRepositories(String URLgitRepository) {

        ResponseEntity<GitMemberRepo[]> gitRepositories = restTemplate.getForEntity(URLgitRepository, GitMemberRepo[].class);

        if (gitRepositories.getStatusCode() != HttpStatus.OK) {
            logger.error("Resource not found");
        }

        GitMemberRepo[] gitMemberRepositories = gitRepositories.getBody();

        return Arrays.asList(gitMemberRepositories);
    }

    private void setGitMembersDetailsAndRepos(GitMember[] gitMembers) {

        this.gitMembers = Arrays.asList(gitMembers).stream().map(
                member -> {
                    member.setGitMemberDetails(retrieveGitMemberDetails(member.getUrl()));
                    member.setGitMemberRepos(retrieveGitMemberRepositories(member.getRepos_url()));
                    return member;
                }).collect(Collectors.toList());
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