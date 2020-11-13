package com.finger.uebung.restclient;

import com.finger.uebung.constants.URIConstants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Member;
import java.util.List;

public class RestClientMembers {

    private WebClient.Builder webClient;

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
