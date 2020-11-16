package com.finger.uebung.dao;

import com.finger.uebung.entities.GitMember;
import org.springframework.stereotype.Component;

import java.util.List;

public interface DaoEntity<T> {

    List<T> getAllMembers();

    GitMember getMember(long id);
}
