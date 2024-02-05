package woche7_Art_Webshop;

import java.sql.Date;
import java.time.LocalDate;

public class Transaction {

	public enum PaymentMethod {
		CASH,
		PAYPAL,
		VISA,
		MASTERCARD,
		BANKTRANSFER
	}
	
	private static int nextID = 0;
	private int ID;
	private Number CustomerID;
	private LocalDate localDate;
	private PaymentMethod payment;
	private Number catalogNr;
	private Number quantity;
	private Number price;
	private String finalPrice;
	private LineItem lineItem1;
	
	
	public Transaction (PaymentMethod payment, Artwork b, Number CustomerID) {
		nextID++;
		this.CustomerID = CustomerID;
		this.payment = payment;
		this.catalogNr = b.getCatalogNr();
		this.quantity = 1;
		this.price = b.getPrice();
		this.localDate = LocalDate.now();
		
		lineItem1 = new LineItem(Transaction.nextID, b , this.quantity);

	}
	
	public String toString() {
		return  '\n' +   "Transaktion Nr. " + lineItem1.getTransactionNr() + " vom " + this.localDate + ". Betrag bezahlt via: " + this.payment +
				+ '\n' + '\n' + lineItem1.toString()  + '\n' +  '\n' + "--------" +  '\n';
	}
	
	
	public static String getAllPaymentMethods () {
		return "1. " + PaymentMethod.CASH.toString() + '\n' + "2. " + PaymentMethod.PAYPAL.toString() + '\n' + 
				"3. " + PaymentMethod.VISA.toString() + '\n' + "4. " + PaymentMethod.MASTERCARD.toString() + '\n' +
				"5. " + PaymentMethod.BANKTRANSFER.toString();
	}
}
