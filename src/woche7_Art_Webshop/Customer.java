package woche7_Art_Webshop;

public class Customer {

	private Integer ID = 0;
	private String name;
	private String phone;
	private String eMail;
	private Address billingAddress;
	private Address shippingAddress;
	
	public Customer (String name, String eMail, String phone) {
		this.ID++;
		this.name = name; 
		this.eMail = eMail;
		this.phone = phone;
	}
	
	public String toString() {
		return "Customer ID: " + this.ID + '\n' + 
				"Name: " + this.name + '\n' +
				"E-Mail: " + this.eMail + '\n' +
				"Phone: " + this.phone + '\n' +
				'\n';
	}
	
	public Integer getCustomerID() {
		return this.ID;
	}
	
	public void SetBillingAddress (Address billingAddress ) {
		this.billingAddress = billingAddress;
	}
	
	public String getBillingAddress() {
		if (this.billingAddress != null) return "_Rechnungsadresse: " + '\n' + this.billingAddress.toString() + '\n' + '\n';
		else return "Keine Zustelladresse hinterlegt";
		
	}
	
	public void SetShippingAddress (Address shippingAddress ) {
		this.shippingAddress = shippingAddress;
	}
	
	public String getShippingAddress() {
		if (this.billingAddress != null) return "_Zustelladresse: " + '\n' +  this.shippingAddress.toString() + '\n' + '\n';
		else return "Keine Zustelladresse hinterlegt";
	}
	
	
}
