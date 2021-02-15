package gildedrose;

public class AgedBrie extends CustomItem{

    private static final int QUALITY_EVOLUTION_BEFORE_SELL_DATE = 1;
    private static final int QUALITY_EVOLUTION_AFTER_SELL_DATE = 2;

    public AgedBrie(Item item){
        super(item);
    }

    /**
     * The Aged Brie INCREASES in quality :
     * - By 1, before the selling date,
     * - By 2, after the selling date.
     */
    @Override
    public void updateItem() {
        item.sellIn -= 1;
        if(!hasReachedHighestQualityPossible()) {

            if(!hasSellDatePassed()){
                item.quality += QUALITY_EVOLUTION_BEFORE_SELL_DATE;
            }
            else{
                item.quality += QUALITY_EVOLUTION_AFTER_SELL_DATE;
            }

            checkQualityLimitReached();
        }
    }
}
