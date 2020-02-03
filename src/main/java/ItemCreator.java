import java.util.ArrayList;

public class ItemCreator {
    ArrayList<CorruptedItem> items;
    public ItemCreator(){
        items = new ArrayList<CorruptedItem>();
    }
    public void createItem(){
        items.add(new CorruptedItem(new Item("+5 Dexterity Vest", 10, 19), false));
        items.add(new CorruptedItem(new Item("Aged Brie", 2, 0), false));
        items.add(new CorruptedItem(new Item("Elixir of the Mongoose", 5, 7), false));
        items.add(new CorruptedItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80), true));
        items.add(new CorruptedItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), false));
        items.add(new CorruptedItem(new Item("Conjured Mana Cake", 3, 1), true));
    }
    public  ArrayList<CorruptedItem> getItems(){
        return this.items;
    }
    public static ArrayList<CorruptedItem> staticCreateItem(){
        ItemCreator item = new ItemCreator();
        item.createItem();
        return item.getItems();
    }

}
