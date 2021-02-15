package gildedrose;

public class BackstagePasses extends CustomItem{

    private static final int CLOSE_CONCERT_DATE = 10;
    private static final int IMMINENT_CONCERT_DATE = 5;

    public BackstagePasses(Item item){
        super(item);
    }

    /**
     * The Backstage Passes increase in quality :
     * - By 1 if the selling date is above 10
     * - By 2 if the selling date is between 5 and 10
     * - By 3 if the selling date is below 5
     *
     * The quality drops to 0 after the selling date has passed.
     */
    @Override
    public void updateItem() {
        item.quality += 1;
        if(item.sellIn <= CLOSE_CONCERT_DATE) item.quality += 1;
        if(item.sellIn <= IMMINENT_CONCERT_DATE) item.quality += 1;

        item.sellIn -= 1;

        if(hasSellDatePassed()) item.quality = GildedRose.LOWEST_QUALITY_POSSIBLE;

        checkQualityLimitReached();
    }
}
