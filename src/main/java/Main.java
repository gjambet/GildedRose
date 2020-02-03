import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");
        GildedRose g1 = new GildedRose();
        g1.CreateItem();

        //test
        System.out.println(g1.item.size());
        for(int i = 0; i < g1.item.size(); i++){
            System.out.print(g1.item.get(i).getItem().getName()+" : ");
            System.out.println(g1.item.get(i).getItem().quality);
        }


        QualityManager.updateQuality(g1.item);
        //test
        for(int i = 0; i < g1.item.size(); i++){
            System.out.print(g1.item.get(i).getItem().getName()+" : ");
            System.out.println(g1.item.get(i).getItem().quality);
        }
    }
}
