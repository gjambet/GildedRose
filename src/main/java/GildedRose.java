import java.util.ArrayList;
import java.util.Optional;

public class GildedRose {
    public ArrayList<CorruptedItem> item;
    public GildedRose(){
        this.item = new ArrayList<CorruptedItem>();
    }
    public void CreateItem(){
        this.item = ItemCreator.staticCreateItem();
    }
    public void updateQuality(){
        QualityManager.updateQuality(this.item);
    }
    public CorruptedItem get(String key){
        Optional<CorruptedItem> first = this.item.stream().filter(item -> item.getItem().getName().equals(key)).findFirst();
        if(first != null){
            return  first.get();
        }else {
            return null;
        }
    }
}
