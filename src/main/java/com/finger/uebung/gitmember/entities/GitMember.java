package com.finger.uebung.gitmember.entities;
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
    private String url;
    private String repos_url;
    private GitMemberDetails gitMemberDetails;
    private List<GitMemberRepo> gitMemberRepos;

}