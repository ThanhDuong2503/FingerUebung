package com.finger.uebung.dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class DaoMemberImpl implements DaoEntity<Member> {

    private List<Member> allMembers;

    //TODO Hier fehlt noch RestCall
    @Override
    public List<Member> getAllMembers() {

        allMembers = new ArrayList<>();

        return null;
    }
}