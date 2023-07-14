package com.sprindock.demo.Tables;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "STOCKS_INFO")
public class StocksInfo {

    @Id
    private Integer info_id;
    private String stock_symbol;
    private Integer current_price;
    @ManyToMany
    private List<Portfolio> portfolios;
    @OneToOne
    private Stocks stocks;

    public StocksInfo(Integer info_id, String stock_symbol, Integer current_price, List<Portfolio> portfolios, Stocks stocks) {
        this.info_id = info_id;
        this.stock_symbol = stock_symbol;
        this.current_price = current_price;
        this.portfolios = portfolios;
        this.stocks = stocks;
    }

    public StocksInfo() {

    }

    public Integer getInfo_id() {
        return info_id;
    }

    public void setInfo_id(Integer info_id) {
        this.info_id = info_id;
    }

    public String getStock_symbol() {
        return stock_symbol;
    }

    public void setStock_symbol(String stock_symbol) {
        this.stock_symbol = stock_symbol;
    }

    public Integer getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(Integer current_price) {
        this.current_price = current_price;
    }

    public List<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }

    public Stocks getStocks() {
        return stocks;
    }

    public void setStocks(Stocks stocks) {
        this.stocks = stocks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StocksInfo that)) return false;

        if (!getInfo_id().equals(that.getInfo_id())) return false;
        if (!getStock_symbol().equals(that.getStock_symbol())) return false;
        if (!getCurrent_price().equals(that.getCurrent_price())) return false;
        if (!getPortfolios().equals(that.getPortfolios())) return false;
        return getStocks().equals(that.getStocks());
    }

    @Override
    public int hashCode() {
        int result = getInfo_id().hashCode();
        result = 31 * result + getStock_symbol().hashCode();
        result = 31 * result + getCurrent_price().hashCode();
        result = 31 * result + getPortfolios().hashCode();
        result = 31 * result + getStocks().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "StocksInfo{" +
                "info_id='" + info_id + '\'' +
                ", stock_symbol='" + stock_symbol + '\'' +
                ", current_price=" + current_price +
                ", portfolios=" + portfolios +
                ", stocks=" + stocks +
                '}';
    }
}
