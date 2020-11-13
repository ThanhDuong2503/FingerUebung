package com.finger.uebung.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GitMemberRepo {

    private long id;
    private String urlRepo;
    private CodingLanguage codingLanguage;
}
