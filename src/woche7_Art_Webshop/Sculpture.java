package woche7_Art_Webshop;

public class Sculpture extends Artwork {
	
	public enum Material {WOOD,CLAY,BRONZE}
	private String Material;
	

	public Sculpture(Number price, Material SculptureMaterial) {
		super(price);
		this.Material = SculptureMaterial.toString();
		this.OriginalStatus(SculptureMaterial.toString());
	}
	
	public void changeSculptureMaterial (Material SculptureType) {
		this.Material = SculptureType.toString();
	}
	
	public String getSculptureMaterial () {
		return this.Material;
	}
	
	public String toString() {
		return '\n' + "Skulptur Nr.: " + this.getCatalogNr().toString() + '\n' +
				"Preis: CHF " + this.getPrice().toString() + '\n' + 
				"Material: " + this.Material + '\n' +
				"Originalität: " + this.getIsOriginal().toString() + '\n' +  "--------" +  '\n';
	}
	
	
}
