package com.finger.uebung.gitmember.entities;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GitMemberRepo implements Serializable {

    private long id;
    private String url;
    private String language;
}
