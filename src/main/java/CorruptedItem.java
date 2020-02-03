public class CorruptedItem {
    private Item item;
    private boolean corrupted;
    public CorruptedItem(Item item, Boolean corrupted){
        this.item = item;
        this.corrupted = corrupted;
    }
    public void setItem(Item item){
        this.item = item;
    }
    public Item getItem(){
        return this.item;
    }
    public void setCorrupted(Boolean corrupted){
        this.corrupted = corrupted;
    }
    public Boolean getCorrupted(){
        return this.corrupted;
    }

}
