package edu.oakland.production;

import edu.oakland.production.ATMCard;
import edu.oakland.production.Account;
import edu.oakland.helper.DataBase;
import java.lang.*;

public class ATM {
	private DataBase d;
	private ATMCard atmCard;
	private int pin;
	private double fundsDispursed = 0;
	private ATMState atmState = ATMState.NONE;
	private boolean userAuthenticated;
	private Account currentAcct;

	private enum ATMState {NONE, WITHDRAW, DEPOSIT};

	public ATM(DataBase d) {
		this.d = d;
	}

	public boolean processATMCard(ATMCard atmCard, int pin) {
		this.atmCard = atmCard;
		this.pin = pin;
		Account acct = new Account(atmCard, pin);

		userAuthenticated = d.contains(acct);
		if(userAuthenticated) {
			currentAcct = acct;
		}
		return userAuthenticated;
	}

	private Account createAccount(ATMCard atmCard, int pin) {
		Account acct = new Account(atmCard, pin);
		return acct;
	}

	public double receiveFunds() {
		double result = fundsDispursed;
		fundsDispursed = 0;
		return result;
	}

	public void chooseWithdrawMoney() {
		if(userAuthenticated) {
			atmState = ATMState.WITHDRAW;
		} else {
			throw(new IllegalStateException());
		}
	}

	public void enterAmount(double amount) {
		switch(atmState)
		{
			case NONE:
				throw(new IllegalStateException());

			case WITHDRAW:
				withdrawMoney(amount);
				atmState = ATMState.NONE;
				break;

			case DEPOSIT:
				throw(new UnsupportedOperationException());

			default:
				throw(new IllegalStateException());
		}
	}

	public void chooseNone() {
		atmState = ATMState.NONE;
		userAuthenticated = false;
		currentAcct = null;
	}

	private void withdrawMoney(double amount) {
		fundsDispursed += d.withdraw(amount);
	}

	public boolean removeATMCard() {
		// anything to do here?
		return true;
	}



}