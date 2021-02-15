package gildedrose;

public abstract class CustomItem {

    protected Item item;

    public CustomItem(Item item) {
        this.item = item;
    }

    public abstract void updateItem();

    protected boolean hasSellDatePassed(){
        return item.sellIn < 0;
    }

    protected boolean hasReachedHighestQualityPossible(){
        return item.quality >= GildedRose.HIGHEST_QUALITY_POSSIBLE;
    }

    protected boolean hasReachedLowestQualityPossible(){
        return item.quality <= GildedRose.LOWEST_QUALITY_POSSIBLE;
    }

    /**
     * Check if the quality value of the item has passed the limit.
     * If that's the case, correct it.
     */
    protected void checkQualityLimitReached(){
        if(hasReachedHighestQualityPossible()){
            item.quality = GildedRose.HIGHEST_QUALITY_POSSIBLE;
        }
        else if(hasReachedLowestQualityPossible()){
            item.quality = GildedRose.LOWEST_QUALITY_POSSIBLE;
        }
    }
}
