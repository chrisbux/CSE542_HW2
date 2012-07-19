package edu.oakland.test;

import junit.framework.*;
import edu.oakland.production.*;
import edu.oakland.helper.DataBase;

public class ATMEndSession extends TestCase {
	public void testCompleteAtmTest() {
		// This mock database is crafted so any request for accts passes and the entire
		// database only stores a single account balance.  In essence, account information
		// does nothing.
		DataBase db = new DataBase();
		ATMCard card = new ATMCard("John Doe", 1002);
		ATM atm = new ATM(db);
		atm.processATMCard(card, 1234);
		db.setBalance(200.00);
		atm.chooseWithdrawMoney();
		atm.enterAmount(150.00);
		assertEquals(150.00, atm.receiveFunds());

		// test overdrawing account
		atm.chooseWithdrawMoney();
		atm.enterAmount(150.00);
		assertEquals(0.0, atm.receiveFunds());

		// remove card
		atm.chooseNone();
		assertTrue(atm.removeATMCard());
	}
}
