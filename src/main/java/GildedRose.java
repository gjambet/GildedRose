import java.util.Optional;


public class GildedRose {

    private StockofItems stkItems;
    private QualityItemsManager Qim;

    public StockofItems getGoods() {
        return this.stkItems;
    }

    public QualityItemsManager getQIM() {
        return Qim;
    }

    public GildedRose() {

        this.stkItems = new StockofItems();
        this.Qim = new QualityItemsManager();
    }

    public Item get(String itemName) {
        StockofItems StockofItems = new StockofItems();
        Optional<Item> optional =
                StockofItems.getItems().stream()
                        .filter(item -> item.getName().equals(itemName))
                        .findFirst();

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new IllegalStateException("item inexistant !");
        }


    }

    public void updateQuality() {

        this.stkItems.getItems().stream()
                .forEach(x -> {
                    Qim.updateQualityItem(x);
                });
    }

    public void updateQuality(Item item) {
        Qim.updateQualityItem(item);
    }
}
