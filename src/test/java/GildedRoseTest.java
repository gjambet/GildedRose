

import inn.GildedRose;
import inn.Item;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GildedRoseTest {


	//Qualite

	@Test
	public void testQualiteSupperieur() {

		GildedRose gil = new GildedRose();
		for (int i = 0; i < 100; i++) {
			gil.updateQuality();
		}
		gil.getGoods().getItems().stream()
				.forEach(x -> {
					if (x.name == "Sulfuras, Hand of Ragnaros") {
						testSulfuras();
					} else {
						assertThat(x.quality).isLessThanOrEqualTo(50);
					}
				});
	}

	@Test
	public void testQualiteInferieur() {
		GildedRose gil = new GildedRose();
		for (int i = 0; i < 100; i++) {
			gil.updateQuality();
		}
		gil.getGoods().getItems().stream()
				.forEach(x -> {
					assertThat(x.quality).isGreaterThanOrEqualTo(0);
				});
	}


	//Sulfuras


	@Test
	public void testSulfuras() {

		GildedRose gil = new GildedRose();
		Item sulfuras = gil.get("Sulfuras, Hand of Ragnaros");
		int initQualite = 80;

		for (int i = 0; i < 100; i++) {
			gil.updateQuality(sulfuras);
			assertThat(sulfuras.quality).isEqualTo(initQualite);
		}

	}


	//BACKSTAGE
	@Test
	public void testBackstagesellInHaute() {
		GildedRose gil = new GildedRose();
		Item backstage = gil.get("Backstage passes to a TAFKAL80ETC concert");
		int initQualite = backstage.quality;
		while (backstage.sellIn > 10) {
			gil.updateQuality(backstage);
			assertThat(backstage.quality).isEqualTo(initQualite + 1);
			initQualite = backstage.quality;
		}
	}

	@Test
	public void testBackstagSellInmoyen() {

		GildedRose gil = new GildedRose();
		Item backstage = gil.get("Backstage passes to a TAFKAL80ETC concert");
		int initQualite = backstage.quality;
		for (int i = 0; i < 100; i++) {
			gil.updateQuality(backstage);
			if (backstage.sellIn < 10 && backstage.sellIn > 5) {
				assertThat(backstage.quality).isEqualTo(initQualite + 2);
			}
			initQualite = backstage.quality;
		}
	}

	@Test
	public void testBackstageSellInPetit() {
		GildedRose gil = new GildedRose();
		Item backstage = gil.get("Backstage passes to a TAFKAL80ETC concert");
		int initQualite = backstage.quality;
		for (int i = 0; i < 100; i++) {
			gil.updateQuality(backstage);
			if (backstage.sellIn < 5 && backstage.sellIn > 0) {
				assertThat(backstage.quality).isEqualTo(initQualite + 3);
			}
			initQualite = backstage.quality;
		}
	}

	@Test
	public void testBackstageNonSellIn() {
		GildedRose gil = new GildedRose();
		Item backstage = gil.get("Backstage passes to a TAFKAL80ETC concert");
		for (int i = 0; i < 100; ++i) {
			gil.updateQuality(backstage);
			if (backstage.sellIn == 0) {
				gil.updateQuality(backstage);
				assertThat(backstage.quality).isEqualTo(0);
			}

		}
	}


	//Aged Brie

	@Test
	public void testBriePlusUnQualite() {
		GildedRose gil = new GildedRose();
		Item brie = gil.get("Aged Brie");
		int initQualite = brie.quality;
		while (brie.sellIn > 0) {
			gil.updateQuality(brie);
			assertThat(brie.quality).isEqualTo(initQualite + 1);
			initQualite = brie.quality;
		}
	}

	@Test
	public void testBriePlusDeuxQualite() {
		GildedRose gil = new GildedRose();
		Item brie = gil.get("Aged Brie");
		int initQualite = brie.quality;
		for (int i = 0; i < 100; i++) {
			gil.updateQuality(brie);
			if (brie.sellIn < 0 && brie.quality < 50) {
				assertThat(brie.quality).isEqualTo(initQualite + 2);
			}
			initQualite = brie.quality;
		}
	}


	//		Conjured Mana Cake
	@Test
	public void testManaMoinsDeuxQualite() {

		GildedRose gil = new GildedRose();
		Item cake = gil.get("Conjured Mana Cake");
		int initQualite = cake.quality;
		for (int i = 0; i < 100; i++) {
			gil.updateQuality(cake);
			if (cake.sellIn >= 0) {
				assertThat(cake.quality).isEqualTo(initQualite - 2);
			}
			initQualite = cake.quality;
		}
	}

	@Test
	public void testManaCakeMoinsQuateQualite() {
		GildedRose gil = new GildedRose();
		Item cake = gil.get("Conjured Mana Cake");
		int initQualite = cake.quality;
		for (int i = 0; i < 100; i++) {
			gil.updateQuality(cake);
			if (cake.sellIn < 0 && cake.quality ==50) {
				assertThat(cake.quality).isEqualTo(initQualite - 4);
			}
			initQualite = cake.quality;
		}
	}

}


