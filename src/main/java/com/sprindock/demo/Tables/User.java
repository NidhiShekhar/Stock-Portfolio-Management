package com.sprindock.demo.Tables;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "USER_SAPP")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer user_id;
    private String username;
    private String email;
    private String password;
    private Timestamp createdAt;
    @ManyToOne
    private Portfolio portfolio;
    @ManyToOne
    private Transaction transaction;

    public User(Integer user_id, String username, String email, String password, Timestamp createdAt, Portfolio portfolio, Transaction transaction) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.portfolio = portfolio;
        this.transaction = transaction;
    }

    public User() {

    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (!getUser_id().equals(user.getUser_id())) return false;
        if (!getUsername().equals(user.getUsername())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (!getCreatedAt().equals(user.getCreatedAt())) return false;
        if (!getPortfolio().equals(user.getPortfolio())) return false;
        return getTransaction().equals(user.getTransaction());
    }

    @Override
    public int hashCode() {
        int result = getUser_id().hashCode();
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + getPortfolio().hashCode();
        result = 31 * result + getTransaction().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", portfolio=" + portfolio +
                ", transaction=" + transaction +
                '}';
    }
}
