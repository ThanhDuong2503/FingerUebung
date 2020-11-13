package com.finger.uebung.restcontroller;

import com.finger.uebung.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Member;
import java.util.List;

public class RestControllerMember {

    @Autowired
    private final MemberService memberService;

    public RestControllerMember(MemberService memberService) {
        this.memberService = memberService;
    }

    //TODO Alternative hier

    @RequestMapping(value={"/members"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<Member> getMembers(){
        return memberService.getAllMembers();
    }

}
