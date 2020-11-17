package com.finger.uebung.restclient;

import java.util.List;

public interface RestClient<T> {

    public T retrieveGitMemberByName(String name);
    public List<T> retrieveAllGitMembers();
}
