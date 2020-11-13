package com.finger.uebung.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GitMember {

    private long id;
    private String fullname;
    private List<GitMemberRepo> repositories;
    private String urlMember;

}
