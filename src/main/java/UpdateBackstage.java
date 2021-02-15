public class UpdateBackstage {

    UpdateStandard US = new UpdateStandard();

    protected void updateExpiredBackstage(Item item) {
        item.quality = 0;
    }

    protected void updateQualityBackstage(Item item) {
        US.incrementQuality(item);
        if (item.sellIn <= 10) {
            US.incrementQuality(item);
        }
        if (item.sellIn <= 5) {
            US.incrementQuality(item);
        }
    }
}
