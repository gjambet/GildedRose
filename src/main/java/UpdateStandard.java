public class UpdateStandard {

    protected void decrementQualityStandard(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void updateExpiredStandard(Item item) {
        decrementQualityStandard(item);
    }

    protected void updateQualityStandard(Item item) {
        decrementQualityStandard(item);
    }

    /////////////////////////////////////////

    protected void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    protected void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }


}
