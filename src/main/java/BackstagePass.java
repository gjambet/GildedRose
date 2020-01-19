public class BackstagePass extends ItemCreate {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);

    }
    //this method updates the quality of BackStagePasses items
    //Backstage Item's quality should increase by one more than ten days before sellIn date
    //by two between ten and five days before selling date
    //by three less then five days before sellIn date
    public static void  doUpdateQuality(Item item){
        int sellIn=item.getSellIn();
        int quality=item.getQuality();

        if (quality < 50) {
            quality++;
            if (sellIn < 11) quality++;
            if (sellIn < 6) quality++;
        }
        sellIn--;
        if (sellIn < 0) quality = 0;
        item.setQuality(quality);
        item.setSellIn(sellIn);
    }

}
