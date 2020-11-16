package com.finger.uebung.restcontroller;

import com.finger.uebung.entities.GitMember;
import com.finger.uebung.service.GitMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping()
public class RestControllerGitMember {

    private final GitMemberService gitMemberService;

    @Autowired
    public RestControllerGitMember(GitMemberService gitMemberService) {
        this.gitMemberService = gitMemberService;
    }

    @GetMapping("/members")
    private Flux<GitMember> getAllGitMembers() {

        /**
        List<GitMember> m1List = new TestObject().getMembersTests();
        return Flux.fromIterable(m1List);

        //return Flux.fromIterable(memberService.getAllMembers());
         **/

        return null;
    }

    @GetMapping("/one")
    private Mono<GitMember> getGitMemberById() {

        /**
        GitMember member = new TestObject().getOneMemberTests();
        return Mono.just(member);

         **/

        return null;
    }

    /**
    //TODO Alternative hier

    @RequestMapping(value={"/members"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<Member> getMembers(){
        return memberService.getAllMembers();
    }

    **/
}
