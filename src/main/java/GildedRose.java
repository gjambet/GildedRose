import java.util.ArrayList;



public class GildedRose  {

	private static ArrayList<Item> items = null;

    public GildedRose() {

    }
    
	public ArrayList<Item> initItems() {
        System.out.println("OMGHAI!");

        items = new ArrayList<>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        return items;
}

     //updates quality for all items in the 'items' list
     protected void updateQuality(ArrayList<Item> items)
    {
        for (int i = 0; i < items.size(); i++)
        {
            Item item=  items.get(i);
           ItemCreate.doUpdateQuality(item);
        }
    }

}
