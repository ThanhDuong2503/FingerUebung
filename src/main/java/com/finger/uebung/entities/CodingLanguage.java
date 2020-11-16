package com.finger.uebung.entities;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CodingLanguage implements Serializable {

    private long id;
    private String codingLanguageName;

}
