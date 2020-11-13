package com.finger.uebung.restclient.andereEntities;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GitMemberanders {

    private long id;
    private List<GitMemberRepoandersanders> repositories;
    private String urlMember;

}
