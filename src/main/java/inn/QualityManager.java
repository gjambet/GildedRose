package inn;

import java.util.List;

//Gestion du tps restant pour la vente et de la qualite d'un item
public class QualityManager {
    //Gestion generale du stock:
    //on parcourt la liste d'item et on met a jour le tps restant pour la vente et la qualite
    //en fonction des regles de la taverne
  public static void updateQuality2(Item item){
      switch(item.getName())
      {
          case "Backstage passes to a TAFKAL80ETC concert":
              if (item.sellIn > 10) { item.setQuality(item.getQuality() + 1);}
              if (item.sellIn <= 10 && item.sellIn > 5) { item.setQuality(item.getQuality() + 2);}
              if (item.sellIn <= 5 && item.sellIn > 0) { item.setQuality(item.getQuality() + 3);}
              if (item.sellIn == 0) { item.setQuality(0);}
              break;
          case "Aged Brie":
              if (item.sellIn > 0 && item.quality < 50) { item.setQuality(item.getQuality() + 1);}
              if (item.sellIn <= 0 && item.quality < 50) { item.setQuality(item.getQuality() + 2);}
              break;
          case "Conjured Mana Cake":
              if (item.sellIn > 0 && decreaseQualityPossibleTwo(item)){ item.setQuality(item.getQuality() - 2);}
              if (item.sellIn <= 0 && item.quality < 50 && decreaseQualityPossibleFour(item)){ item.setQuality(item.getQuality() - 4);}
              break;
          case "Sulfuras, Hand of Ragnaros":
              //System.out.println("Never touch Ragnaros");
              break;
          default:
              if (item.sellIn > 0 && decreaseQualityPossibleOne(item)) {  item.setQuality(item.getQuality() -1);}
              if (item.sellIn <= 0 && item.quality > 0 && decreaseQualityPossibleTwo(item)) {  item.setQuality(item.getQuality() -2);}
      }
      if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) { item.setSellIn(item.sellIn - 1); }
  }

    private static boolean decreaseQualityPossibleFour(Item item) {
      return item.quality > 3;
    }

    private static boolean decreaseQualityPossibleTwo(Item item) {
      return item.quality > 1;
    }

    private static boolean decreaseQualityPossibleOne(Item item) {
      return item.quality > 0;
    }


}
