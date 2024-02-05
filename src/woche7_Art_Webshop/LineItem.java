package woche7_Art_Webshop;

public class LineItem {
	
	private Number TransactionID;
	private Number CatalogNr;
	private Number Quantity;
	private Number Price;
	private Artwork a;
	
	public LineItem(Integer transcationID, Artwork b, Number Quantity) {
		this.TransactionID = transcationID;
		this.CatalogNr = b.getCatalogNr();
		this.Quantity = Quantity;
		this.Price = b.getPrice();
		a = b;
	}
	
	public String toString () {
		return  + '\n' + "Produkt | Nummer | Anzahl | Preis in CHF " + '\n' +
				a.getCatalogNr() + " | " + checkArtworkType(a) + " | "  +  this.Quantity.toString() + " | CHF " + a.getPrice().toString();
	} 
	
    public String checkArtworkType(Artwork artwork) {
        if (artwork instanceof Painting) {
            return "Gemälde";
        } else return "Skulptur";
    }
    
    public String getTransactionNr () {
    	return this.TransactionID.toString();
    }
	
	

}
