package com.finger.uebung.gitmember.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GitMemberDetails implements Serializable {

    long id;
    String login;
    String name;

}