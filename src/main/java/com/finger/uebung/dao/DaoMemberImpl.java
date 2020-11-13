package com.finger.uebung.dao;

import com.finger.uebung.entities.GitMember;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class DaoMemberImpl implements DaoEntity<GitMember> {

    private List<GitMember> allMembers;

    //TODO Hier fehlt noch RestCall
    @Override
    public List<GitMember> getAllMembers() {

        allMembers = new ArrayList<>();

        return null;
    }
}