package com.sprindock.demo.Tables;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer t_id;
    private String stock_sym;
    private String type;
    private Integer qty;
    private Long price;
    private Timestamp timestamp_t;
    @OneToMany(mappedBy = "transaction")
    private List<User> users;

    public Transaction(Integer t_id, String stock_sym, String type, Integer qty, Long price, Timestamp timestamp_t, List<User> users) {
        this.t_id = t_id;
        this.stock_sym = stock_sym;
        this.type = type;
        this.qty = qty;
        this.price = price;
        this.timestamp_t = timestamp_t;
        this.users = users;
    }

    public Transaction() {

    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getStock_sym() {
        return stock_sym;
    }

    public void setStock_sym(String stock_sym) {
        this.stock_sym = stock_sym;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Timestamp getTimestamp_t() {
        return timestamp_t;
    }

    public void setTimestamp_t(Timestamp timestamp_t) {
        this.timestamp_t = timestamp_t;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction that)) return false;

        if (!getT_id().equals(that.getT_id())) return false;
        if (!getStock_sym().equals(that.getStock_sym())) return false;
        if (!getType().equals(that.getType())) return false;
        if (!getQty().equals(that.getQty())) return false;
        if (!getPrice().equals(that.getPrice())) return false;
        if (!getTimestamp_t().equals(that.getTimestamp_t())) return false;
        return getUsers().equals(that.getUsers());
    }

    @Override
    public int hashCode() {
        int result = getT_id().hashCode();
        result = 31 * result + getStock_sym().hashCode();
        result = 31 * result + getType().hashCode();
        result = 31 * result + getQty().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + getTimestamp_t().hashCode();
        result = 31 * result + getUsers().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "t_id=" + t_id +
                ", stock_sym='" + stock_sym + '\'' +
                ", type='" + type + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", timestamp_t=" + timestamp_t +
                ", users=" + users +
                '}';
    }
}
