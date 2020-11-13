package com.finger.uebung.dao;

import org.springframework.stereotype.Component;

import java.util.List;

public interface DaoEntity<T> {

    List<T> getAllMembers();

}
