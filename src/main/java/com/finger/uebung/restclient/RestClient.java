package com.finger.uebung.restclient;

import java.util.List;

public interface RestClient<T> {

    public T retrieveOneMember();
    public List<T> retrieveAllMembers();
}
