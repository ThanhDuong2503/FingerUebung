package com.finger.uebung.restclient;

import com.finger.uebung.constants.URIConstants;
import com.finger.uebung.entities.GitMember;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class RestClientMembers {

    WebClient client = WebClient.create();

    public void  retrieveMembers() {
        
        Flux<GitMember> employeeFlux = client.get()
                .uri(URIConstants.getAllGitMembers())
                .retrieve()
                .bodyToFlux(GitMember.class);

        employeeFlux.subscribe(System.out::println);

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
