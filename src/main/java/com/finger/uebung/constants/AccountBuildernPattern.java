package com.finger.uebung.constants;

public class AccountBuildernPattern {

    private int number;
    private String owner;
    private int balance;

    private AccountBuildernPattern(){}

    public static class Builder{

        private int number;
        private String owner;
        private int balance;

        public Builder(int number){
            this.number = number;
        }

        public Builder withOwner(String owner){
            this.owner = owner;
            return this;
        }

        public Builder withBalance(int balance){
            this.balance = balance;
            return this;
        }

        public AccountBuildernPattern build(){
            AccountBuildernPattern accountBuildernPattern = new AccountBuildernPattern();
            accountBuildernPattern.number = this.number;
            accountBuildernPattern.balance = this.balance;
            accountBuildernPattern.owner = this.owner;

            return accountBuildernPattern;
        }


    }

    public static void main(String[] args) {

        AccountBuildernPattern accountBuildernPattern = new Builder(1234)
                .withOwner("Robret")
                .withBalance(200)
                .build();
    }

}
