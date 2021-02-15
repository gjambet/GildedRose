import java.util.ArrayList;

public class UpdateQuality {

    UpdateLegendary UL = new UpdateLegendary();
    UpdateBrie UB = new UpdateBrie();
    UpdateBackstage UBa = new UpdateBackstage();
    UpdateConjured UJ = new UpdateConjured();
    UpdateStandard US = new UpdateStandard();

    //Met à jour les données des items
    public void updateQuality(ArrayList<Item> items) {
        for (Item item : items) {
            identifyItem(item);
        }
    }

    ///////////////////////////////////////////////
    private void identifyItem(Item item) {

        if (item.name.startsWith("Sulfuras")) {

            UL.updateQualityLegendary(item);
            UL.updateSellInLegendary(item);
            UL.updateExpiredLegendary(item);
        }

        if (item.name.equals("Aged Brie")) {

            UB.updateQualityBrie(item);
            US.updateSellIn(item);
            if (item.sellIn < 0) {
                UB.updateExpiredBrie(item);
            }
        }

        if (item.name.startsWith("Backstage")) {

            UBa.updateQualityBackstage(item);
            US.updateSellIn(item);
            if (item.sellIn < 0) {
                UBa.updateExpiredBackstage(item);
            }
        }

        if (item.name.startsWith("Conjured ")) {

            UJ.updateQualityConjured(item);
            US.updateSellIn(item);
            if (item.sellIn < 0) {
                UJ.updateExpiredConjured(item);
            }
        }

        if (item.name.startsWith("Elixir") || item.name.startsWith("+5 ")) {

            US.updateQualityStandard(item);
            US.updateSellIn(item);
            if (item.sellIn < 0) {
                US.updateExpiredStandard(item);
            }
        }

    }

}
