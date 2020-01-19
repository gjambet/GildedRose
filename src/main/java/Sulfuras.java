public class Sulfuras extends ItemCreate {
    public Sulfuras( int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }
    //this method updates the quality of Sulfuras items
  //Sulfuras item's quality should never change this is why the method is empty
    public static void  doUpdateQuality(Item item){

    }

}
