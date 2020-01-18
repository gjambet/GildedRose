
public class ItemCreate extends Item {

    public String name;
    public int sellIn;
    public int quality;



    public ItemCreate(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    ;

    public static Item createItem(String name, int sellIn, int quality) {

        switch (name) {
            case "Aged Brie":
                return new AgedBrie(sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePass(sellIn, quality);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(sellIn, quality);
            default:
                return new Item(name, sellIn, quality);
        }

    }

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
            default:
                DefaultItem.doUpdateQuality(item);
                break;
        }

    }
}
