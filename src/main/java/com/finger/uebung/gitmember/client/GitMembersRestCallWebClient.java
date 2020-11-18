package com.finger.uebung.gitmember.webclientImpl;

import com.finger.uebung.gitmember.entities.GitMember;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@NoArgsConstructor
@Component("WebClientRestClient")
public class GitMembersAccessor implements com.finger.uebung.base.GitMembersAccessor {

    private WebClient.Builder webClientBuilder;

    private final WebClient webClient;

    {
        webClient = WebClient.create();
    }

    @Autowired
    public GitMembersAccessor(WebClient.Builder webClientBuilder){
        this.webClientBuilder = webClientBuilder;
    }

    //TODO Pfad anpassen
    //TODO Property Fields anpassen mittels Annotation
    public GitMember retrieveOneMember(){
/**
    * //Mit WebClientBuild
        GitMember gitMember = webClientBuilder.build()
                .get()
                .uri("localhost:8080/one")
                .retrieve()
                .bodyToMono(GitMember.class)
                .block();

        return gitMember;
 **/
//Mit webclient.create()
        GitMember gitMember = this.webClient
                .get()
                .uri("localhost:8080/one")
                .retrieve()
                .bodyToMono(GitMember.class)
                .block();

        return gitMember;

    }


    public Flux<GitMember> retrieveAllMembers() {

        Flux<GitMember> gitMembers = this.webClient
                .get()
                .uri("localhost:8080/members")
                .retrieve()
                .bodyToFlux(GitMember.class);

        return gitMembers;
        /**
        Mono<Collection<GitMember>> gitMembers = webClientBuilder.build()
                .get()
                .uri("localhost:8080/members")
                .retrieve()
                .bodyToFlux(GitMember.class).collect(Collectors.toList());

        return gitMembers;
**/


    }

    public static void main(String[] args){
        //CALL ONE MEMBER
        //WebClient.Builder webClientBuilder = WebClient.builder();
        //RestClientMembersWebClient d = new RestClientMembersWebClient(webClientBuilder);
        //GitMember n = d.retrieveOneMember();

        //CALL ALL MEMBERS
        WebClient.Builder webClientBuilder = WebClient.builder();
        GitMembersAccessor d = new GitMembersAccessor(webClientBuilder);
        System.out.println("Size: " + d.retrieveAllMembers());
    }

    @Override
    public GitMember retrieveGitMemberByName(String name) {
        return null;
    }

    @Override
    public List<GitMember> retrieveAllGitMembers() {
        return null;
    }
}