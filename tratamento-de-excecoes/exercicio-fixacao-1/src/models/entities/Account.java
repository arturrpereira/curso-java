package models.entities;

import models.exceptions.DomainExceptions;

public class Account {
   
    private Integer number;
    private String holder;
    private Double balance;
    private Double withDrawLimite;
    
    public Account() {

    }

    public Account(Integer number, String holder, Double balance, Double withDrawLimite) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withDrawLimite = withDrawLimite;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithDrawLimite() {
        return withDrawLimite;
    }

    public void setWithDrawLimite(Double withDrawLimite) {
        this.withDrawLimite = withDrawLimite;
    }

    public void deposit(Double amount) {
        this.balance += amount;
    }

    public void withdraw (Double amount) throws DomainExceptions {
        if(amount > getWithDrawLimite()) {
            throw new DomainExceptions("The amount exceeds withdraw limit");
        }
        if(amount > getBalance()) {
            throw new DomainExceptions("Not enough balance");
        }
        this.balance -= amount;
    }
}
