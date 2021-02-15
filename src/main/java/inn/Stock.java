package inn;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    //Classe Stock qui gere les donnees : les differents
    //items disponibles dans la taverne avec les caracteristiques
    //propre a chacun

    private List<Item> items = null;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Stock() {

        this.items = new ArrayList<>();
        //On cree un item en lui donnant un nom, un tps restant pour la vente et une qualite
        this.items.add(new Item("+5 Dexterity Vest", 10, 20));
        this.items.add(new Item("Aged Brie", 2, 0));
        this.items.add(new Item("Elixir of the Mongoose", 5, 7));
        this.items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        this.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        this.items.add(new Item("Conjured Mana Cake", 3, 6));

    }

}
