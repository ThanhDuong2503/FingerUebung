package com.finger.uebung.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GitMemberRepo {

    private long id;
    private String urlRepo;
    private CodingLanguage codingLanguage;
}
