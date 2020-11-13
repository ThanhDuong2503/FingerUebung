package com.finger.uebung.constants;

public class URIConstants {
    
        //Example AllUsers: https://api.github.com/orgs/codecentric/members
        //Example OneUser for NameSearch: https://api.github.com/users/0x4a616e
        //Example RepoURL: https://api.github.com/users/0x4a616e/repos

        private static String GET_ALL_MEMBERS = "https://api.github.com/orgs/codecentric/members";
        private static String GET_MEMBER ="https://api.github.com/users";
        private static String GET_REPO = "/repos";

        public static String getGetAllMembers(){
            return GET_ALL_MEMBERS;
        }

        public static String getMember(String memberName){
            return GET_MEMBER + memberName;

        }

        public static String getRepo(String memberName){
            return getMember(memberName) + GET_REPO;
        }

}
