package com.finger.uebung.restclient;

import com.finger.uebung.constants.URIConstants;
import com.finger.uebung.entities.GitMember;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

public class RestClientMembers {

   WebClient client = WebClient.create();

    public void  retrieveMembers() {

        Flux<GitMember> employeeFlux = client.get()
                .uri("localhost:8080/members")
                .retrieve()
                .bodyToFlux(GitMember.class);

        employeeFlux.subscribe(System.out::println);

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
