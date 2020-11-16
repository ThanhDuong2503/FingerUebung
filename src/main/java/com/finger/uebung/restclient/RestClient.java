package com.finger.uebung.restclient;

import java.util.List;

public interface RestClient<T> {

    public T retrieveOneGitMember();
    public List<T> retrieveAllGitMembers();
}
