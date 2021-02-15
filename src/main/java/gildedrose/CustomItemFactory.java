package gildedrose;

import java.util.HashMap;
import java.util.Map;

public class CustomItemFactory {

    private final static String AGED_BRIE_ITEM = "Aged Brie";
    private final static String BACKSTAGE_PASSES_ITEM = "Backstage passes";
    private final static String CONJURED_ITEM = "Conjured";
    private final static String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";

    private Map<String, CustomItem> itemTypeList;

    public CustomItemFactory(Item item){
        itemTypeList = new HashMap<>();

        itemTypeList.put(AGED_BRIE_ITEM, new AgedBrie(item));
        itemTypeList.put(BACKSTAGE_PASSES_ITEM, new BackstagePasses(item));
        itemTypeList.put(CONJURED_ITEM, new ConjuredItem(item));
        itemTypeList.put(SULFURAS_ITEM, new Sulfuras(item));
    }

    public CustomItem getCustomItem(Item item){

        // Check if the given item is one of the special item in the itemTypeList
        for(String itemTypeName: itemTypeList.keySet()){
            if(item.name.contains(itemTypeName)){
                return itemTypeList.get(itemTypeName);
            }
        }
        return new StandardItem(item);
    }

}
