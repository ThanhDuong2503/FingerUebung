package com.finger.uebung.entities;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GitMember implements Serializable {

    private long id;
    private String fullname;
    private List<GitMemberRepo> repositories;
    private String urlMember;

}
