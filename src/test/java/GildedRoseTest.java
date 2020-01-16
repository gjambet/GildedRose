import static java.util.stream.IntStream.range;
import static org.junit.Assert.*;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;



public class GildedRoseTest {


	/////////////////////////////////////////////////////////////////
	// Aged Brie
	/////////////////////////////////////////////////////////////////

	@Test
	public void agedBrieQualityShouldIncreaseByOneBeforeSellInDate(){
		int QUALITY_INCREASE_RATE = 1;

		GildedRose inn = new GildedRose();
		Item agedBrie = inn.getItem("Aged Brie");

		int qualityBeforeUpdate;
		while(!hasSellInDatePassed(agedBrie) && !hasReachedHighestQualityPossible(agedBrie)){
			qualityBeforeUpdate = agedBrie.quality;

			inn.updateQuality();
			assertThat(agedBrie.quality).isEqualTo(qualityBeforeUpdate + QUALITY_INCREASE_RATE);
		}
	}

	@Test
	public void agedBrieQualityShouldIncreaseByTwoAfterSellInDate(){
		int QUALITY_INCREASE_RATE = 2;

		GildedRose inn = new GildedRose();
		Item agedBrie = inn.getItem("Aged Brie");

		reduceItemSellInValueTo(inn, agedBrie, 0);

		int qualityBeforeUpdate;
		while(!hasReachedHighestQualityPossible(agedBrie)){
			qualityBeforeUpdate = agedBrie.quality;

			inn.updateQuality();
			assertThat(agedBrie.quality).isEqualTo(qualityBeforeUpdate + QUALITY_INCREASE_RATE);
		}
	}


	/////////////////////////////////////////////////////////////////
	// Backstage Passes
	/////////////////////////////////////////////////////////////////

	@Test
	public void backstagePassesQualityShouldIncreaseByOneWhenMoreThanTenDaysBeforeSellInDate(){
		int QUALITY_INCREASE_RATE = 1;

		GildedRose inn = new GildedRose();
		Item backstagePasses = inn.getItem("Backstage passes to a TAFKAL80ETC concert");

		int qualityBeforeUpdate;
		while(backstagePasses.sellIn > 10 && !hasReachedHighestQualityPossible(backstagePasses)){
			qualityBeforeUpdate = backstagePasses.quality;

			inn.updateQuality();
			assertThat(backstagePasses.quality).isEqualTo(qualityBeforeUpdate + QUALITY_INCREASE_RATE);
		}
	}


	@Test
	public void backstagePassesQualityShouldIncreaseByTwoBetweenTenAndFiveDaysBeforeSellInDate(){
		int QUALITY_INCREASE_RATE = 2;

		GildedRose inn = new GildedRose();
		Item backstagePasses = inn.getItem("Backstage passes to a TAFKAL80ETC concert");

		reduceItemSellInValueTo(inn, backstagePasses, 10);

		int qualityBeforeUpdate;
		while(backstagePasses.sellIn > 5 && !hasReachedHighestQualityPossible(backstagePasses)){
			qualityBeforeUpdate = backstagePasses.quality;

			inn.updateQuality();
			assertThat(backstagePasses.quality).isEqualTo(qualityBeforeUpdate + QUALITY_INCREASE_RATE);
		}
	}


	/////////////////////////////////////////////////////////////////
	// Standard Item
	/////////////////////////////////////////////////////////////////

	@Test
	public void standardItemQualityShouldDecreaseByOneBeforeSellInDate(){
		int QUALITY_DECREASE_RATE = 1;

		GildedRose inn = new GildedRose();
		Item standardItem = inn.getItem("+5 Dexterity Vest");

		int qualityBeforeUpdate;
		while(!hasSellInDatePassed(standardItem) && !hasReachedLowestQualityPossible(standardItem)){
			qualityBeforeUpdate = standardItem.quality;

			inn.updateQuality();
			assertThat(standardItem.quality).isEqualTo(qualityBeforeUpdate - QUALITY_DECREASE_RATE);
		}
	}

	@Test
	public void standardItemQualityShouldDecreaseByTwoAfterSellInDate(){
		int QUALITY_DECREASE_RATE = 2;

		GildedRose inn = new GildedRose();
		Item standardItem = inn.getItem("+5 Dexterity Vest");

		reduceItemSellInValueTo(inn, standardItem, 0);

		int qualityBeforeUpdate;
		while(!hasReachedLowestQualityPossible(standardItem)){
			qualityBeforeUpdate = standardItem.quality;

			inn.updateQuality();
			assertThat(standardItem.quality).isEqualTo(qualityBeforeUpdate - QUALITY_DECREASE_RATE);
		}
	}


	/////////////////////////////////////////////////////////////////
	// Sulfuras
	/////////////////////////////////////////////////////////////////

	@Test
	public void sulfurasQualityShouldNeverChange(){
		GildedRose inn = new GildedRose();

		Item sulfuras = inn.getItem("Sulfuras, Hand of Ragnaros");

		int originalQuality = sulfuras.quality;

		for(int i = 0; i < 100; ++i) {
			inn.updateQuality();
			assertThat(sulfuras.quality).isEqualTo(originalQuality);
		}
	}


	/////////////////////////////////////////////////////////////////
	// Utils
	/////////////////////////////////////////////////////////////////

	private static void reduceItemSellInValueTo(GildedRose inn, Item item, int sellIn){
		while(sellIn < item.sellIn){
			inn.updateQuality();
		}
	}

	private static boolean hasSellInDatePassed(Item item){
		return item.sellIn <= 0;
	}

	private static boolean hasReachedHighestQualityPossible(Item item){
		return item.quality >= GildedRose.HIGHEST_QUALITY_POSSIBLE;
	}

	private static boolean hasReachedLowestQualityPossible(Item item){
		return item.quality <= GildedRose.LOWEST_QUALITY_POSSIBLE;
	}
}
