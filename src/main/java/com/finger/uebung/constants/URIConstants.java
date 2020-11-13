package com.finger.uebung.constants;

public class URIConstants {

        //Example AllUsers: https://api.github.com/orgs/codecentric/members
        //Example OneUser for NameSearch: https://api.github.com/users/0x4a616e
        //Example RepoURL: https://api.github.com/users/0x4a616e/repos

        private static final String ALL_GIT_MEMBERS = "https://api.github.com/orgs/codecentric/members";
        private static final String GIT_MEMBER ="https://api.github.com/users";
        private static final String GIT_REPO = "/repos";

        public static String getAllGitMembers(){
            return ALL_GIT_MEMBERS;
        }

        public static String getMember(String memberName){
            return GIT_MEMBER + memberName;

        }

        public static String getRepo(String memberName){
            return getMember(memberName) + GIT_REPO;
        }

}
