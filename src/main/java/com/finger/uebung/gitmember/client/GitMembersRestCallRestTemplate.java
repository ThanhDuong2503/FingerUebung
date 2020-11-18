package com.finger.uebung.gitmember.client;

import com.finger.uebung.base.constants.URIConstants;
import com.finger.uebung.base.json.ObjectMapper;
import com.finger.uebung.gitmember.entities.GitMember;
import com.finger.uebung.gitmember.entities.GitMemberDetails;
import com.finger.uebung.gitmember.entities.GitMemberRepo;
import com.finger.uebung.base.data.GitMembersAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Component("RestClientRestTemplate")
public class GitMembersRestCallRestTemplate implements GitMembersAccessor {

    private RestTemplate restTemplate;
    private List<GitMember> gitMembers;

    Logger logger = LoggerFactory.getLogger(GitMembersRestCallRestTemplate.class);

    @Autowired
    public GitMembersRestCallRestTemplate(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
        restTemplate.getMessageConverters().add(0, ObjectMapper.getMappingJackson2HttpMessageConverter());
    }

    public GitMember retrieveGitMemberByName(String fullName) {

        retrieveAllGitMembers();

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
}