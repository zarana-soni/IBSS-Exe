package account;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String name;
    private double balance;
    private List<String> transactions;
    private String statement;

    public Account(String accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = 0;
        this.transactions = new ArrayList<>();
        this.statement = "";
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("DEP " + amount);
    }

    public void withdraw(double amount) {
        balance -= amount;
        transactions.add("CHQ " + amount);
    }

    public void produceStatement() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Account: ").append(accountNumber).append("\n");
        sb.append("Balance: ").append(String.format("%.2f", balance)).append("\n");
        sb.append("Transactions:").append("\n");

        for (String transaction : transactions) {
            sb.append(transaction).append("\n");
        }

        statement = sb.toString();
    }

    public String getStatement() {
        return statement;
    }

}
