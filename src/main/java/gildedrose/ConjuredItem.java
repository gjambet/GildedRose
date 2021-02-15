package gildedrose;

public class ConjuredItem extends CustomItem {

    private static final int QUALITY_EVOLUTION_BEFORE_SELL_DATE = 2;
    private static final int QUALITY_EVOLUTION_AFTER_SELL_DATE = 4;

    public ConjuredItem(Item item){
        super(item);
    }

    /**
     * The Conjured Item DECREASES in quality :
     * - By 2, before the selling date
     * - By 4, after the selling date
     */
    @Override
    public void updateItem() {
        item.sellIn -= 1;
        if(!hasReachedLowestQualityPossible()) {

            if(!hasSellDatePassed()){
                item.quality -= QUALITY_EVOLUTION_BEFORE_SELL_DATE;
            }
            else{
                item.quality -= QUALITY_EVOLUTION_AFTER_SELL_DATE;
            }

            checkQualityLimitReached();
        }
    }
}
