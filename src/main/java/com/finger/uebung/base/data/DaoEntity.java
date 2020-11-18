package com.finger.uebung.base;

import com.finger.uebung.gitmember.entities.GitMember;

import java.util.List;

public interface DaoEntity<T> {

    List<T> getAllGitMembers();

    GitMember getGitMemberByName(String fullName);
}
