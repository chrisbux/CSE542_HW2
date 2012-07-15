package edu.oakland.production;

import edu.oakland.production.ATMCard;

public class Account {
	private int pin;
	private ATMCard atmCard;

	public Account(ATMCard atmCard, int pin) {
		this.atmCard = atmCard;
		this.pin = pin;
	}
}