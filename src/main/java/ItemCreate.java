
public class ItemCreate extends Item {

    public String name;
    public int sellIn;
    public int quality;



    public ItemCreate(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    ;
     //updates the quality of one item depending on the item's name
    public static void doUpdateQuality(Item item) {


        switch (item.getName()) {
            case "Aged Brie":
                AgedBrie.doUpdateQuality(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                BackstagePass.doUpdateQuality(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                Sulfuras.doUpdateQuality(item);
                break;
            case "Conjured Mana Cake":
                ConjuredItem.doUpdateQuality(item);
                break;
            default:
                DefaultItem.doUpdateQuality(item);
                break;
        }

    }
}
