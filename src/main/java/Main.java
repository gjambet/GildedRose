import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        GildedRose rose = new GildedRose();
        ArrayList<Item> items= rose.initItems();
        rose.updateQuality(items);
    }
}



