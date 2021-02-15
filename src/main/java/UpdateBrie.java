public class UpdateBrie {

    UpdateStandard US = new UpdateStandard();

    protected void updateExpiredBrie(Item item) {
        US.incrementQuality(item);
    }

    protected void updateQualityBrie(Item item) {
        US.incrementQuality(item);
    }
}
