package com.finger.uebung.restclient;

import com.finger.uebung.constants.URIConstants;
import com.finger.uebung.entities.GitMember;
import com.finger.uebung.restclient.andereEntities.GitMemberanders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

public class RestClientMembers {

   @Autowired
   private WebClient client = WebClient.create();

    public Flux<GitMember> retrieveMembers() {

        Flux<GitMember> employeeFlux = client.get()
                .uri("localhost:8080/members")
                .retrieve()
                .bodyToFlux(GitMember.class);

        return employeeFlux;

    }

    public static void main(String[] args){
        RestClientMembers d = new RestClientMembers();
        d.retrieveMembers();

    }
//    private WebClient.Builder webClient;

    /**
    @RequestMapping()
    public List<Member> retrieveMembers(){

        return webClient
                .build()
                .get()
                .uri(URIConstants.getAllGitMembers())
                .retrieve()
                .bodyToFlux(String.class)
                .collectList()
                .block();
    }
    **/
}
