package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.rules.ExpectedException;
public class GiftCardTest
{
	double balance;
	GiftCard card; 
	int issuingStore;
	double amount;
	
	@Test
	public void getIssuingStore()
	{

		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("getIssuingStore()",
				issuingStore, card.getIssuingStore());
		
	}
	
	@Test
	public void getBalance()
	{
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}

	@Test
	public void deduct()
	{
		issuingStore = 1337;
		amount = -1;
		card = new GiftCard(issuingStore, balance);
		assertEquals("deduct(balance)", "Invalid Transaction", card.deduct(amount));
		
		amount = 50;
		balance = -1;
		assertEquals("deduct(balance)", "Amount Due: " + String.format("%6.2f",Math.abs(0-amount)), 
				card.deduct(amount));
		
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("deduct(balance)", "Remaining Balance: " + String.format("%6.2f",Math.abs(balance - amount)), 
				card.deduct(amount));	
		
	}
	
	@Test
	public void GiftCard()
	{
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});

	}
	@Test
	public void constructor_IncorrectID_Low()
	{
		int storeID = -1;
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(storeID, 100);});
		
	}
	@Test
	public void constructor_IncorrectID_High() 
	{
		int storeID = 10000;
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(storeID, 100);});
	}
	
	
}