package edu.oakland.helper;

import edu.oakland.production.Account;

public class DataBase {
	double balance;

	public DataBase() {
	}

	public boolean contains(Account acct) {
		return true;
	}

	public void Add(Account acct) {
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double withdraw(double amount) {
		if(balance >= amount) {
			balance -= amount;
			return amount;
		} else {
			return 0;
		}
	}

}