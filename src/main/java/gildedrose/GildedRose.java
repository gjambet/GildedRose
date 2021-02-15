package gildedrose;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class GildedRose {

	private ArrayList<Item> items;
	static final int LOWEST_QUALITY_POSSIBLE = 0;
	static final int HIGHEST_QUALITY_POSSIBLE = 50;

    public GildedRose(){
        System.out.println("OMGHAI!");

        items = new ArrayList<>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
    }

    public void updateQuality() {
        for (Item item: items) {
            CustomItem customItem = getCustomItemFromItem(item);
            customItem.updateItem();
        }
    }

    private CustomItem getCustomItemFromItem(Item item){
        return new CustomItemFactory(item).getCustomItem(item);
    }

    public Item getItem(String key){

        Optional<Item> optionalItem = items.stream()
                .filter( item -> item.name.equals(key) )
                .findFirst();

        if(optionalItem.isPresent()){
            return optionalItem.get();
        }
        else {
            throw new IllegalAccessError("Item not found in shop");
        }
    }

    public ArrayList<Item> getItems(){
        return items;
    }
}