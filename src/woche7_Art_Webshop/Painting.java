package woche7_Art_Webshop;

public class Painting extends Artwork{

	public enum Paint {WATERCOLOR,OIL}
	private String Paint;
	
	public Painting(Number price, Paint paint, Boolean OriginalStatus) {
		super(price);
		this.Paint = paint.toString();
		this.setOriginalManually(OriginalStatus);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return '\n' + "Gemälde Nr.: " + this.getCatalogNr().toString() + '\n' +
		"Preis: CHF " + this.getPrice().toString() + '\n' + 
		"Farbe: " + this.Paint + '\n' +
		"Originalität: " + this.getIsOriginal().toString() + '\n' +  "--------" +  '\n';
	}
	
	
}
