package inn;

public class Item {

	//Gestion de l'objet Item
	//3 attributs:
	//	son nom, le tps pour effectuer la vente et sa qualite

    public String name;
	public int sellIn; 
    public int quality; 
    
    public Item(String name, int sellIn, int quality) {
		this.setName(name);
		this.setSellIn(sellIn);
		this.setQuality(quality);
	}
    

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
}
