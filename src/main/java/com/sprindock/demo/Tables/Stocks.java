package com.sprindock.demo.Tables;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "STOCKS_DATA")
public class Stocks {

    @Id
    private Integer stock_id;
    private String stock_sym;
    private String name;
    private Integer day_before_price;
    private Long market_cap;
    @OneToOne
    private StocksInfo stocksInfo;

    public Stocks(Integer stock_id, String stock_sym, String name, Integer day_before_price, Long market_cap, StocksInfo stocksInfo) {
        this.stock_id = stock_id;
        this.stock_sym = stock_sym;
        this.name = name;
        this.day_before_price = day_before_price;
        this.market_cap = market_cap;
        this.stocksInfo = stocksInfo;
    }

    public Stocks() {

    }

    public Integer getStock_id() {
        return stock_id;
    }

    public void setStock_id(Integer stock_id) {
        this.stock_id = stock_id;
    }

    public String getStock_sym() {
        return stock_sym;
    }

    public void setStock_sym(String stock_sym) {
        this.stock_sym = stock_sym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDay_before_price() {
        return day_before_price;
    }

    public void setDay_before_price(Integer day_before_price) {
        this.day_before_price = day_before_price;
    }

    public Long getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(Long market_cap) {
        this.market_cap = market_cap;
    }

    public StocksInfo getStocksInfo() {
        return stocksInfo;
    }

    public void setStocksInfo(StocksInfo stocksInfo) {
        this.stocksInfo = stocksInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stocks stocks)) return false;

        if (!getStock_id().equals(stocks.getStock_id())) return false;
        if (!getStock_sym().equals(stocks.getStock_sym())) return false;
        if (!getName().equals(stocks.getName())) return false;
        if (!getDay_before_price().equals(stocks.getDay_before_price())) return false;
        if (!getMarket_cap().equals(stocks.getMarket_cap())) return false;
        return getStocksInfo().equals(stocks.getStocksInfo());
    }

    @Override
    public int hashCode() {
        int result = getStock_id().hashCode();
        result = 31 * result + getStock_sym().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDay_before_price().hashCode();
        result = 31 * result + getMarket_cap().hashCode();
        result = 31 * result + getStocksInfo().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Stocks{" +
                "stock_id='" + stock_id + '\'' +
                ", stock_sym='" + stock_sym + '\'' +
                ", name='" + name + '\'' +
                ", day_before_price=" + day_before_price +
                ", market_cap=" + market_cap +
                ", stocksInfo=" + stocksInfo +
                '}';
    }
}
