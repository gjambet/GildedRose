import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Crée la liste d'items
        GildedRose GR = new GildedRose();
        GR.GildedRose();

        //Effectue la méthode updateQuality sur la liste d'items
        UpdateQuality u = new UpdateQuality();
        for (int i=0; i < 19 ; i++) {
            u.updateQuality(GR.getItemList());
            //Affiche la liste d'items
            ManageList m = new ManageList();
            m.display_list(GR.getItemList());
        }
    }
}
