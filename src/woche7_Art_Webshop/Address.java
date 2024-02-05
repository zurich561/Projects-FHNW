package woche7_Art_Webshop;

public class Address {
	private Integer ID = 0; 
	private String StreeetAddress; 
	private String PostCode; 
	private String Town;
	private String State;
	private String Country;
	
	public Address (String street, String postCode, String town, String state, String country) {
		this.ID+=1;
		this.StreeetAddress = street;
		this.PostCode = postCode;
		this.Town = town;
		this.State = state;
		this.Country = country;
	}
	
	public String toString() {
		return "Address ID: " + this.ID + '\n' +
				this.StreeetAddress + '\n' +
				this.PostCode + " " + this.Town + " " + 
				this.State + ", " + this.Country;
	}
	
	public Integer getAddressID () {
		return this.ID;
	}
	
	
}
