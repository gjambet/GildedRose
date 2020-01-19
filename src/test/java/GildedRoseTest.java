import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;


public class GildedRoseTest {
	GildedRose gr = new GildedRose();
	ArrayList<Item> items = gr.initItems();

	//Default item tests

	@Test
	public void testLowerQuality() {
		Item normalItem=new Item("normal",10,20);
        items.add(normalItem);
		gr.updateQuality(items);
		assertEquals(19,normalItem.getQuality());
	}

	@Test
	public void testlowerSellIn(){
		Item normalItem=new Item("normal",10,20);
		items.add(normalItem);
		gr.updateQuality(items);
		assertEquals(9,normalItem.getSellIn());
	}

   @Test
   public void  allowNegativeSellIn(){
	   Item normalItem=new Item("normal",1,20);
	   items.add(normalItem);
	   gr.updateQuality(items);//-1
	   gr.updateQuality(items);//-2
	   assertEquals(-1,normalItem.getSellIn());
   }

	@Test
	public void  decreaseQualityByTwoAfterSellInReachesZero(){
		Item normalItem=new Item("normal",1,50);
		items.add(normalItem);
		gr.updateQuality(items);//-1
		gr.updateQuality(items);//-2
		gr.updateQuality(items);//-2

		assertEquals(45,normalItem.getQuality());
	}

	@Test
	public void  floorQualityAtZero(){
		Item normalItem=new Item("normal",10,1);
		items.add(normalItem);
		gr.updateQuality(items);//-1
		gr.updateQuality(items);//-2

		assertEquals(0,normalItem.getQuality());
	}



	//Aged Brie items Test
	@Test
	public void  agedBrieIncreaseQualityByOneBeforeDaySellInDate(){
		Item normalItem=new Item("Aged Brie",40,5);
		items.add(normalItem);
		gr.updateQuality(items);//+1
		assertEquals(6,normalItem.getQuality());
	}
	@Test
	public void  agedBrieIncreaseQualityByTwoAfterDaySellInDate(){
		Item agedBrieItem=new Item("Aged Brie",0,5);
		items.add(agedBrieItem);
		gr.updateQuality(items);
		assertEquals(7,agedBrieItem.getQuality());
	}




	//BackstagePasses items tests

	@Test
	public void  backstagePassesQualityShouldIncreaseByOneWhenMoreThanTenDaysBeforeSellInDate(){
		Item backStageItem=new Item("Backstage passes to a TAFKAL80ETC concert",11,5);
		items.add(backStageItem);
		gr.updateQuality(items);
		assertEquals(6,backStageItem.getQuality());
	}
	@Test
	public void  backstagePassesQualityShouldIncreaseByTwoBetweenTenAndFiveDaysBeforeSellInDate(){
		Item backStageItem=new Item("Backstage passes to a TAFKAL80ETC concert",6,5);
		items.add(backStageItem);
		gr.updateQuality(items);
		assertEquals(7,backStageItem.getQuality());
	}

	@Test
	public void backstagePassesQualityShouldIncreaseByThreeWhenLessEqualThanFiveDaysBeforeSellInDate(){
		Item backStageItem=new Item("Backstage passes to a TAFKAL80ETC concert",5,5);
		items.add(backStageItem);
		gr.updateQuality(items);
		assertEquals(8,backStageItem.getQuality());
	}

	@Test
	public void backstagePassesQualityShouldDropToZeroAfterSellInDate(){
		Item backStageItem=new Item("Backstage passes to a TAFKAL80ETC concert",0,5);
		items.add(backStageItem);
		gr.updateQuality(items);
		assertEquals(0,backStageItem.getQuality());
	}


   //Sulfuras items tests
	@Test
	public void sulfurasQualityShouldNeverChange(){
		Item sulfurasItem=new Item("Sulfuras, Hand of Ragnaros",6,5);
		items.add(sulfurasItem);
		gr.updateQuality(items);
		assertEquals(5,sulfurasItem.getQuality());
	}

	//ConjuredItem tests
	@Test
	public void conjuredItemQualityShouldDecreaseByFourAfterSellInDate(){
		Item sulfurasItem=new Item("Conjured Mana Cake",0,5);
		items.add(sulfurasItem);
		gr.updateQuality(items);
		assertEquals(-1,sulfurasItem.getQuality());
	}

	@Test
	public void conjuredItemQualityShouldDecreaseByTwoBeforeSellInDate(){
		Item sulfurasItem=new Item("Conjured Mana Cake",5,5);
		items.add(sulfurasItem);
		gr.updateQuality(items);
		assertEquals(3,sulfurasItem.getQuality());
	}


   //GildedRose test General test
	@Test
	public void gildedRoseTest() {
		gr.updateQuality(items);
	}


}
