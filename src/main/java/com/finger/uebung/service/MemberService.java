package com.finger.uebung.service;

import com.finger.uebung.dao.DaoEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;

@Service
public class MemberService {

    private DaoEntity daoMember;

    public MemberService(DaoEntity daoMember){
        this.daoMember = daoMember;
    }

    public List<Member> getAllMembers(){

        return daoMember.getAllMembers();
    }
}
