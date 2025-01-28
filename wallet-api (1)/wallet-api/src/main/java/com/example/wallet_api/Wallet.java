package com.example.wallet_api;

// those imports allow me to use the stuff starting with
// @ which on the other hand is the interaction of the database
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity  // Marks the class as an entity for JPA
public class Wallet {

    @Id  // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generates a unique ID
    private Long id;
    private String name;
    private double balance;

    public Wallet() {
        this.balance = 0.0;
    }

    public Wallet(Double balance) {
        this.balance = balance;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
