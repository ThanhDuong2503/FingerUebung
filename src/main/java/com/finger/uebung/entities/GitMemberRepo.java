package com.finger.uebung.entities;

import lombok.Data;

@Data
public class GitMemberRepo {

    private long id;
    private String urlRepo;
    private CodingLanguage codingLanguage;
}
