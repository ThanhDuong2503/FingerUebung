package com.finger.uebung.restcontroller;

import com.finger.uebung.entities.CodingLanguage;
import com.finger.uebung.entities.GitMember;
import com.finger.uebung.entities.GitMemberRepo;

import java.util.ArrayList;
import java.util.List;

public class TestObject {

    /**
    public List<GitMember> getMembersTests(){

        List<GitMember> listMembers = new ArrayList<>();

        CodingLanguage codingLanguage = new CodingLanguage(1, "Java");

        GitMemberRepo repo1 = new GitMemberRepo(1, "www", codingLanguage);
        GitMemberRepo repo2 = new GitMemberRepo(2, "www2", codingLanguage);
        List<GitMemberRepo> reposList = new ArrayList<>();
        reposList.add(repo1);
        reposList.add(repo2);


        GitMember m1 = new GitMember(1, "Robert", reposList, "www3");
        GitMember m2 = new GitMember(2, "Robert2", reposList, "www4");
        listMembers.add(m1);
        listMembers.add(m2);

        return listMembers;
    }

    public GitMember getOneMemberTests(){

        CodingLanguage codingLanguage = new CodingLanguage(1, "Java");

        GitMemberRepo repo1 = new GitMemberRepo(1, "www", codingLanguage);
        GitMemberRepo repo2 = new GitMemberRepo(2, "www2", codingLanguage);
        List<GitMemberRepo> reposList = new ArrayList<>();
        reposList.add(repo1);
        reposList.add(repo2);


        GitMember m1 = new GitMember(1, "Robert", reposList, "www3");

        return m1;

    }

     **/
}
