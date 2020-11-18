package com.finger.uebung.gitmember.service;

import com.finger.uebung.base.data.DaoEntity;
import com.finger.uebung.gitmember.entities.GitMember;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class GitMemberService {

    private DaoEntity daoMember;

    @Autowired
    public GitMemberService(DaoEntity daoMember){
        this.daoMember = daoMember;
    }

    public List<GitMember> getAllGitMembers(){

        return daoMember.getAllGitMembers();
    }

    public GitMember getGitMemberByName(String fullName){
        return daoMember.getGitMemberByName(fullName);
    }
}
