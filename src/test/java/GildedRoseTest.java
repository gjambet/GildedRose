
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GildedRoseTest {

	@Test
	public void testTheTruth_Sulfuras() {

		GildedRose inn = new GildedRose();
		Item sulfuras = inn.get("Sulfuras, Hand of Ragnaros");
		int initialQuality = 80;

		for (int i = 0; i < 100; i++) {
			inn.updateQuality(sulfuras);
			assertThat(sulfuras.quality).isEqualTo(initialQuality);
		}

	}

	@Test
	public void testBackstageMidSellIn() {

		GildedRose inn = new GildedRose();
		Item backstage = inn.get("Backstage passes to a TAFKAL80ETC concert");
		int initialQuality = backstage.quality;
		for (int i = 0; i < 100; i++) {
			inn.updateQuality(backstage);
			if (backstage.sellIn < 10 && backstage.sellIn > 5) {
				assertThat(backstage.quality).isEqualTo(initialQuality + 2);
			}
			initialQuality = backstage.quality;
		}
	}


	@Test
	public void testUpperLimitQualityNeverHigher50() {

		GildedRose inn = new GildedRose();
		for (int i = 0; i < 100; i++) {
			inn.updateQuality();
		}
		inn.getGoods().getItems().stream()
				.forEach(x -> {
					if (x.name == "Sulfuras, Hand of Ragnaros") {
						testTheTruth_Sulfuras();
					} else {
						assertThat(x.quality).isLessThanOrEqualTo(50);
					}
				});
	}

	@Test
	public void testLowerLimitQualityNeverUnder0() {
		GildedRose inn = new GildedRose();
		for (int i = 0; i < 10; i++) {
			inn.updateQuality();
		}
		inn.getGoods().getItems().stream()
				.forEach(x -> {
					assertThat(x.quality).isGreaterThanOrEqualTo(0);
				});
	}


	@Test
	public void testBriePlusOneQuality() {
		GildedRose inn = new GildedRose();
		Item brie = inn.get("Aged Brie");
		int initialQuality = brie.quality;
		while (brie.sellIn > 0) {
			inn.updateQuality(brie);
			assertThat(brie.quality).isEqualTo(initialQuality + 1);
			initialQuality = brie.quality;
		}
	}

	@Test
	public void testBriePlusTwoQuality() {
		GildedRose inn = new GildedRose();
		Item brie = inn.get("Aged Brie");
		int initialQuality = brie.quality;
		for (int i = 0; i < 100; i++) {
			inn.updateQuality(brie);
			if (brie.sellIn < 0 && brie.quality < 50) {
				assertThat(brie.quality).isEqualTo(initialQuality + 2);
			}
			initialQuality = brie.quality;
		}
	}


	@Test
	public void testManaCakeMinusTwoQuality() {

		GildedRose inn = new GildedRose();
		Item cake = inn.get("Conjured Mana Cake");
		int initialQuality = cake.quality;
		for (int i = 0; i < 100; i++) {
			inn.updateQuality(cake);
			if (cake.sellIn >= 0) {
				assertThat(cake.quality).isEqualTo(initialQuality - 2);
			}
			initialQuality = cake.quality;
		}
	}

	@Test
	public void testCommonItemMinusTwoQuality() {

		GildedRose inn = new GildedRose();
		Item vest = inn.get("+5 Dexterity Vest");
		Item elixir = inn.get("Elixir of the Mongoose");

		int initialQualityVest = vest.quality;
		int initialQualityElixir = elixir.quality;

		for (int i = 0; i < 30; i++) {
			inn.updateQuality(vest);
			if (vest.sellIn < 0 /*&& vest.quality < 50*/ && vest.quality > 0) {
				assertThat(vest.quality).isEqualTo(initialQualityVest - 2);
			}
			inn.updateQuality(elixir);
			if (elixir.sellIn < 0 && elixir.quality < 50 && elixir.quality > 0) {
				assertThat(elixir.quality).isEqualTo(initialQualityElixir - 2);
			}
			initialQualityVest = vest.quality;
			initialQualityElixir = elixir.quality;

		}
	}
}