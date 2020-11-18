package com.finger.uebung.gitmember.controller;

import com.finger.uebung.gitmember.entities.GitMember;
import com.finger.uebung.gitmember.service.GitMemberService;
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

    @GetMapping("/members/{fullName}")
    public @ResponseBody Optional<GitMember> getGitMemberByName(@PathVariable String fullName){

        return Optional.ofNullable(gitMemberService.getGitMemberByName(fullName));
    }
}