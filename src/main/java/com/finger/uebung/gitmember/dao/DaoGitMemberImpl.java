package com.finger.uebung.gitmember.dao;

import com.finger.uebung.base.DaoEntity;
import com.finger.uebung.gitmember.entities.GitMember;
import com.finger.uebung.base.GitMembersAccessor;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class DaoGitMemberImpl implements DaoEntity<GitMember> {

    private List<GitMember> GitMembers;

    @Autowired
    @Qualifier("RestClientRestTemplate")
    private GitMembersAccessor restclient;

    @Override
    public List<GitMember> getAllGitMembers() {

        GitMembers = restclient.retrieveAllGitMembers();

        return GitMembers;
    }

    @Override
    public GitMember getGitMemberByName(String fullName) {

        GitMember gitMember = restclient.retrieveGitMemberByName(fullName);

        return gitMember;
    }
}