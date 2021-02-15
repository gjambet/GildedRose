import java.util.ArrayList;

public class ManageList {

    //Crée la liste des objets
    public ArrayList<Item> create_list_item() {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 21));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 10));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 25));
        return items;
    }

    public void display_list(ArrayList<Item> items) {
        //Affiche les items avec leurs données
        for (Item elem : items) {
            System.out.println("nom: " + elem.getName());
            System.out.println("Nombre de jours restants pour vendre l'item: " + elem.getSellIn());
            System.out.println("Qualité: " + elem.getQuality());
            System.out.println("--------------------------------------------");
        }
    }


}
