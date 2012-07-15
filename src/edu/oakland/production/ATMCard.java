package edu.oakland.production;

public class ATMCard {
	private int persID;
	private String userInfo;

	public ATMCard(String userInfo, int persID) {
		this.persID = persID;
		this.userInfo = userInfo;
	}

	public int getPersID() {
		return persID;
	}
}