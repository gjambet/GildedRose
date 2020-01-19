public class ConjuredItem extends ItemCreate {
    public ConjuredItem(String name, int sellIn, int quality) {
        super("Conjured Mana Cake", sellIn, quality); }

    //this method updates the quality of Conjured items
    //Conjured Item's quality should decrease by two before sellIn date and by four after SellIn date
    public static void  doUpdateQuality(Item item){
        int sellIn=item.getSellIn();
        int quality=item.getQuality();

        if (quality < 50) {
            quality -= 2;
        }
        sellIn--;
        if (sellIn < 0 && quality < 50) {
            quality -= 4;
        }
        item.setSellIn(sellIn);
        item.setQuality(quality);

    }

}
