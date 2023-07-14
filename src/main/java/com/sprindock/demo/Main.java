package com.sprindock.demo;

import java.util.List;

import com.sprindock.demo.Tables.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/customers")
public class Main {

	private final PortfolioRepo portfolioRepo;
	private final UserRepo userRepo;
	private final StocksInfoRepo stocksInfoRepo;
	private final StocksRepo stocksRepo;
	private final TransactionRepo transactionRepo;


	public Main(PortfolioRepo portfolioRepo, UserRepo userRepo, StocksInfoRepo stocksInfoRepo, StocksRepo stocksRepo, TransactionRepo transactionRepo) {
		this.portfolioRepo = portfolioRepo;
		this.userRepo = userRepo;
		this.stocksInfoRepo = stocksInfoRepo;
		this.stocksRepo = stocksRepo;
		this.transactionRepo = transactionRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}


}