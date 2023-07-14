package com.sprindock.demo.Tables;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PORTFOLIO")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer portfolio_id;
    private Integer shares;
    private String stock_id;
    private Long current_price;
    private Long cost_basis;
    private Integer yield;
    @OneToMany(mappedBy = "portfolio")
    private List<User> user;
    @ManyToMany
    private List<StocksInfo> stocksInfos;

    public Portfolio(Integer portfolio_id, Integer shares, String stock_id, Long current_price, Long cost_basis, Integer yield, List<User> user, List<StocksInfo> stocksInfos) {
        this.portfolio_id = portfolio_id;
        this.shares = shares;
        this.stock_id = stock_id;
        this.current_price = current_price;
        this.cost_basis = cost_basis;
        this.yield = yield;
        this.user = user;
        this.stocksInfos = stocksInfos;
    }

    public Portfolio() {

    }

    public Integer getPortfolio_id() {
        return portfolio_id;
    }

    public void setPortfolio_id(Integer portfolio_id) {
        this.portfolio_id = portfolio_id;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    public String getStock_id() {
        return stock_id;
    }

    public void setStock_id(String stock_id) {
        this.stock_id = stock_id;
    }

    public Long getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(Long current_price) {
        this.current_price = current_price;
    }

    public Long getCost_basis() {
        return cost_basis;
    }

    public void setCost_basis(Long cost_basis) {
        this.cost_basis = cost_basis;
    }

    public Integer getYield() {
        return yield;
    }

    public void setYield(Integer yield) {
        this.yield = yield;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<StocksInfo> getStocksInfos() {
        return stocksInfos;
    }

    public void setStocksInfos(List<StocksInfo> stocksInfos) {
        this.stocksInfos = stocksInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Portfolio portfolio)) return false;

        if (!getPortfolio_id().equals(portfolio.getPortfolio_id())) return false;
        if (!getShares().equals(portfolio.getShares())) return false;
        if (!getStock_id().equals(portfolio.getStock_id())) return false;
        if (!getCurrent_price().equals(portfolio.getCurrent_price())) return false;
        if (!getCost_basis().equals(portfolio.getCost_basis())) return false;
        if (!getYield().equals(portfolio.getYield())) return false;
        if (!getUser().equals(portfolio.getUser())) return false;
        return getStocksInfos().equals(portfolio.getStocksInfos());
    }

    @Override
    public int hashCode() {
        int result = getPortfolio_id().hashCode();
        result = 31 * result + getShares().hashCode();
        result = 31 * result + getStock_id().hashCode();
        result = 31 * result + getCurrent_price().hashCode();
        result = 31 * result + getCost_basis().hashCode();
        result = 31 * result + getYield().hashCode();
        result = 31 * result + getUser().hashCode();
        result = 31 * result + getStocksInfos().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "portfolio_id=" + portfolio_id +
                ", shares=" + shares +
                ", stock_id='" + stock_id + '\'' +
                ", current_price=" + current_price +
                ", cost_basis=" + cost_basis +
                ", yield=" + yield +
                ", user=" + user +
                ", stocksInfos=" + stocksInfos +
                '}';
    }
}
