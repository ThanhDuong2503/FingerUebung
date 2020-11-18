package com.finger.uebung.controller;

import com.finger.uebung.entities.GitMember;
import com.finger.uebung.service.GitMemberService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping()
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RestControllerGitMember {

    //alle nicht-initialisierten final-Felder --> werden automatisch required im Konstruktor
    // und automatisch autowired (weil Zwangsinitialisierung) + @noneNull-Lombok Annoationfelder

    private final GitMemberService gitMemberService;

    @GetMapping("/members")
    public @ResponseBody List<GitMember> getAllGitMembers(){
        return gitMemberService.getAllGitMembers();
    }

    /**
    @RequestMapping(value={"/members"}, method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public @ResponseBody List<GitMember> getAllGitMembers(){

        return gitMemberService.getAllGitMembers();
    }
     **/

    @RequestMapping(value={"/members/{fullName}"}, method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public @ResponseBody Optional<GitMember> getGitMemberByName(@PathVariable String fullName){

        return Optional.ofNullable(gitMemberService.getGitMemberByName(fullName));
    }
}