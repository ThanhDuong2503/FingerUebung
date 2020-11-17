package com.finger.uebung.dao;

import com.finger.uebung.entities.GitMember;
import com.finger.uebung.restclient.RestClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class DaoMemberImpl implements DaoEntity<GitMember> {

    private List<GitMember> GitMembers;

    @Autowired
    private RestClient restclient;

    @Override
    public List<GitMember> getAllGitMembers() {

        GitMembers = restclient.retrieveAllGitMembers();

        return GitMembers;
    }

    @Override
    public GitMember getGitMemberByName(String fullName) {

        GitMember gitMember = (GitMember) restclient.retrieveGitMemberByName(fullName);

        return gitMember;
    }
}