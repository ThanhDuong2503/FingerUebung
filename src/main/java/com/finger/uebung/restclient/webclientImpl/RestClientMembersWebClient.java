package com.finger.uebung.restclient.webclientImpl;

import com.finger.uebung.entities.GitMember;
import com.finger.uebung.restclient.RestClient;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;


@NoArgsConstructor
public class RestClientMembersWebClient implements RestClient {

    private WebClient.Builder webClientBuilder;

    @Autowired
    public RestClientMembersWebClient(WebClient.Builder webClientBuilder){
        this.webClientBuilder = webClientBuilder;
    }

    //TODO Pfad anpassen
    //TODO Property Fields anpassen mittels Annotation
    public GitMember retrieveOneMember(){

        GitMember gitMember = webClientBuilder.build()
                .get()
                .uri("localhost:8080/one")
                .retrieve()
                .bodyToMono(GitMember.class)
                .block();

        return gitMember;
    }

    @Override
    public List<GitMember> retrieveAllMembers() {
        return null;
    }

    public static void main(String[] args){
        WebClient.Builder webClientBuilder = WebClient.builder();
        RestClientMembersWebClient d = new RestClientMembersWebClient(webClientBuilder);

        System.out.println(d.retrieveOneMember());
    }
}