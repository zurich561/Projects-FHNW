package woche7_Art_Webshop;

public abstract class Artwork {
	private static Integer catalogNr = 1;
	private int catalogNumber;
	private Boolean isOriginal = false;
	private Number price;
	
	public Artwork (Number price) {
		this.price = price;
		this.catalogNumber = catalogNr++;
	}
	
	public void OriginalStatus (String type) {
		String type1 = "WOOD";
		String type2 = "CLAY";
		
		if (type.equals(type1)) this.isOriginal = true;
		else if (type.equals(type2)) this.isOriginal = true;
		
	}
	
	public void changeOriginalStatus (Boolean newStatus) {
		this.isOriginal = newStatus;
		
	}

	
	// getter and setter
	
	public Integer getCatalogNr () {
		return this.catalogNumber;
	}
	
	public void setCatalogNr (Integer newCatalogNr) {
		this.catalogNr = newCatalogNr;
	}
	
	public Boolean getIsOriginal () {
		return this.isOriginal;
	}
	
	public void setOriginalManually (Boolean answer) {
		this.isOriginal = answer;
	}
	
	public Number getPrice () {
		return this.price;
	}
	
	public void setPrice (Double newPrice) {
		this.price = newPrice;
	}
	
	public Integer getCatalogNumber () {
		return this.catalogNr;
	}

}
