import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class GildedRose {

    private  static ArrayList<Item> items = null;


    //Constructeur qui crée la liste d'items
    public  void GildedRose(){
        ManageList ML = new ManageList();
        items = ML.create_list_item();
    }

    //Constructeur qui modifie la qualité des items
    public void updateQuality(){
        UpdateQuality UQ = new UpdateQuality();
        UQ.updateQuality(getItemList());
    }


    //Recupere l'item souhaité
    public Item get(String key) {

        Optional<Item> optional = items.stream()
                .filter(item -> item.getName().equals(key))
                .findFirst();
        if (optional.isPresent()){
            return optional.get();

        }else{
            throw new IllegalStateException("not found in shop");
        }
    }


    //Recupere la liste d'items
    public ArrayList<Item> getItemList() {
        return items;
    }

}