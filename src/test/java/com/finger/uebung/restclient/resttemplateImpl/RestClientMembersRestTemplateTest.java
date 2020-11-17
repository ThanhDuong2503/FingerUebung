package com.finger.uebung.restclient.resttemplateImpl;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class RestClientMembersRestTemplateTest {

    RestTemplate restTemplate = new RestTemplate();
    RestClientMembersRestTemplate restClientMembersRestTemplate = new RestClientMembersRestTemplate(restTemplate);

    @Test
    void retrieveAllGitMembers() {

        System.out.println(restClientMembersRestTemplate.retrieveAllGitMembers());
    }
}