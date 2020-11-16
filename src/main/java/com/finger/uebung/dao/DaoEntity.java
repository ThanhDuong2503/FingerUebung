package com.finger.uebung.dao;

import com.finger.uebung.entities.GitMember;

import java.util.List;

public interface DaoEntity<T> {

    List<T> getAllGitMembers();

    GitMember getGitMember(long id);
}
