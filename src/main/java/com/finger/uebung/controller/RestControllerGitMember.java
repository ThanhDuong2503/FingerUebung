package com.finger.uebung.controller;

import com.finger.uebung.entities.GitMember;
import com.finger.uebung.service.GitMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping()
public class RestControllerGitMember {

    private final GitMemberService gitMemberService;

    @Autowired
    public RestControllerGitMember(GitMemberService gitMemberService) {
        this.gitMemberService = gitMemberService;
    }

    @RequestMapping(value={"/members"}, method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public @ResponseBody List<GitMember> getAllGitMembers(){

        return gitMemberService.getAllGitMembers();
    }

    @RequestMapping(value={"/members/{fullName}"}, method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public @ResponseBody Optional<GitMember> getGitMemberByName(@PathVariable String fullName){

        return Optional.ofNullable(gitMemberService.getGitMemberByName(fullName));
    }
}