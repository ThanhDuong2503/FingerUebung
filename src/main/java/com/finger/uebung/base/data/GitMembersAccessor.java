package com.finger.uebung.base;

import com.finger.uebung.gitmember.entities.GitMember;

import java.util.List;

//Ehemaliger RestClient -> zu technisch gedacht, wenn ich es so nenne
//Reader und Writer wäre vll noch eine sinnvolle Aufteilung
public interface GitMembersAccessor {

    GitMember retrieveGitMemberByName(String name);
    List<GitMember> retrieveAllGitMembers();
}
