public class AgedBrie extends ItemCreate {
    public AgedBrie( int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

   //this method updates the quality of Aged Brie items
  //AgedBrie Item's quality should increase by two after sellIn date and by one before SellIn date
    public static void  doUpdateQuality(Item item){
        int sellIn=item.getSellIn();
        int quality=item.getQuality();

        if (quality < 50) {
            quality++;
        }
        sellIn--;
        if (sellIn < 0 && quality < 50) {
                quality++;

            }
        item.setSellIn(sellIn);
        item.setQuality(quality);

        }

    }

