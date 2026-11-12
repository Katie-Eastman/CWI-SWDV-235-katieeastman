package edu.cwi.data;

import java.math.BigDecimal;

public class Account {

    // Fields
    private int id;
    private int userId;
    private String accountType;
    private BigDecimal balance;

    // Default constructor
    public Account() {
    }

    // Parameterized constructor
    public Account(int id, int userId, String accountType,
                   BigDecimal balance) {

        this.id = id;
        this.userId = userId;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
