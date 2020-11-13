package com.finger.uebung.service;

import com.finger.uebung.dao.DaoEntity;
import com.finger.uebung.entities.GitMember;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MemberService {

    private DaoEntity daoMember;

    public MemberService(DaoEntity daoMember){
        this.daoMember = daoMember;
    }

    public List<GitMember> getAllMembers(){

        return daoMember.getAllMembers();
    }
}
