import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	@Test
	public void testSulfuras(){
		GildedRose g1 = new GildedRose();
		g1.CreateItem();
		int quality = 80;
		CorruptedItem Citem = g1.get("Sulfuras, Hand of Ragnaros");
		for(int i = 0; i < 100; i++){
			g1.updateQuality();
			assertTrue(Citem.getItem().quality == quality);
		}

	}


	@Test
	public void testAllGeneriqueItem(){
		//dexterity vest
		generiqueItemTest("+5 Dexterity Vest");
		//Elixir
		generiqueItemTest("Elixir of the Mongoose");

	}


	public void generiqueItemTest(String key){
		GildedRose g1 = new GildedRose();
		g1.CreateItem();
		CorruptedItem Citem = g1.get(key);
		int quality = Citem.getItem().quality;
		for(int i = 0; i < 100; i++){
			g1.updateQuality();
			if(Citem.getItem().sellIn < 0) {
				quality = quality -2;
			}else if(quality>0) {
				quality = quality -1;
			}
			if(quality<0){
				quality = 0;
			}
			assertTrue(Citem.getItem().quality == quality);
			//System.out.println("quality : "+quality);
			//System.out.println("qualityO : "+Citem.getItem().quality);
			//System.out.println(Citem.getItem().quality);
		}
	}

	@Test
	public void qualityAlwaysPositiv(){
		GildedRose g1 = new GildedRose();
		g1.CreateItem();
		for (int i=0; i < 100; i++){
			g1.item.stream().forEach(item ->
					assertTrue(item.getItem().quality >= 0));
		}

	}
}
