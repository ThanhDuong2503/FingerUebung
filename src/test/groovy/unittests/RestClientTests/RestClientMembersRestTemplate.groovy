package com.finger.uebung.gitmember.resttemplatelmpl

import com.finger.uebung.gitmember.entities.GitMember
import com.finger.uebung.gitmember.client.GitMembersRestCallRestTemplate
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class GitMembersRestCallRestTemplateTest extends Specification {

    def "Should return a list of all gitMembers"() {
        //RestTemplate mocken (setup, dass immer, wenn RestTemplate aufgerufen wird, dann size 30
        //btw. ein bestimmtes GitMember-Object

        given:
        RestTemplate restTemplate = new RestTemplate()
        GitMembersRestCallRestTemplate restClientMembersRestTemplate = new GitMembersRestCallRestTemplate(restTemplate);

        when:
        List<GitMember> gitMembers = restClientMembersRestTemplate.retrieveAllGitMembers()

        then:
        gitMembers.size() == 30
        System.out.println(gitMembers)
    }
}