package com.finger.uebung.restcontroller;

import com.finger.uebung.entities.GitMember;
import com.finger.uebung.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.Member;
import java.util.List;

@RestController
@RequestMapping("/members")
public class RestControllerMember {

    @Autowired
    private final MemberService memberService;

    public RestControllerMember(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    private Flux<GitMember> getAllMembers() {

        return Flux.fromIterable(memberService.getAllMembers());
    }

    @GetMapping("/{id}")
    private Mono<GitMember> getEmployeeById(@PathVariable long id) {
        //memberService.findEmployeeById(id);

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
