public class UpdateConjured {

    protected void updateExpiredConjured(Item item) {
        decrementQualityConjured(item);
        decrementQualityConjured(item);
    }

    private void decrementQualityConjured(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void updateQualityConjured(Item item) {

        decrementQualityConjured(item);
        decrementQualityConjured(item);
    }
}
