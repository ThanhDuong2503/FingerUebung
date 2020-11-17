package com.finger.uebung.restclient.resttemplatelmpl

import com.finger.uebung.entities.GitMember
import com.finger.uebung.restclient.resttemplateImpl.RestClientMembersRestTemplate
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class RestClientMembersRestTemplateTest extends Specification {

    def "Should return a list of all gitMembers"() {
        //RestTemplate mocken (setup, dass immer, wenn RestTemplate aufgerufen wird, dann size 30
        //btw. ein bestimmtes GitMember-Object

        given:
        RestTemplate restTemplate = new RestTemplate()
        RestClientMembersRestTemplate restClientMembersRestTemplate = new RestClientMembersRestTemplate(restTemplate);

        when:
        List<GitMember> gitMembers = restClientMembersRestTemplate.retrieveAllGitMembers()

        then:
        gitMembers.size() == 30
        System.out.println(gitMembers)
    }
}