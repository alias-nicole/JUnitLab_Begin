package csc131.junit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
public class GiftCardTest
{
	double balance;
	GiftCard card; 
	int issuingStore;
	
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
		balance = 100.00;
		double amount = 50;
		card = new GiftCard(issuingStore, balance);
		assertEquals("deduct(balance)", "Remaining Balance: " + String.format("%6.2f",Math.abs(balance - amount)), 
				card.deduct(amount));
		
	}
	
	
	
	
	
}