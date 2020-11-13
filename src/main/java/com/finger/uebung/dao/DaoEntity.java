package com.finger.uebung.dao;

import java.util.List;

public interface DaoEntity<T> {

    List<T> getAllMembers();

}
