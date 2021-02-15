
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;


public class GildedRoseTest {


    //Effectue un test permettant de savoir si la valeur de l'item sulfuras reste bien le même que l'original.
    @Test
    public void sulfuras_should_be_same_quality() {
        GildedRose GR = new GildedRose();
        GR.GildedRose();
        Item sulfuras = GR.get("Sulfuras, Hand of Ragnaros");
        int originQuality = sulfuras.quality;
        for (int i = 0; i < 100; i++) {
            GR.updateQuality();
            assertTrue(originQuality == sulfuras.quality);
        }
    }

    //Permet de verifier que l'item sulfuras ne peut pas être vendu.
    @Test
    public void sulfuras_cant_be_selled() {
        GildedRose GR = new GildedRose();
        GR.GildedRose();
        Item sulfuras = GR.get("Sulfuras, Hand of Ragnaros");
        int originSellIn = sulfuras.sellIn;
        for (int i = 0; i < 100; i++) {
            GR.updateQuality();
            assertTrue(originSellIn == sulfuras.sellIn);
        }
    }

    //Effectue un test permettant qu'un item ne depasse jamais 50 de qualité.
    @Test
    public void item_never_more_50quality() {

        GildedRose GR = new GildedRose();
        GR.GildedRose();
        ArrayList<Item> items = GR.getItemList();
        Item sulfuras = GR.get("Sulfuras, Hand of Ragnaros");


        for (int i = 0; i < 100; i++) {
            GR.updateQuality();
            items.stream()
                    .forEach(
                            item -> {
                                if (item != sulfuras) {
                                    assertThat(item.getQuality()).isLessThan(51);
                                }
                            }
                    );

        }
    }


    //Effectue un test permettant de verifier que la qualité d'un item n'est jamais inférieur a 0.
    @Test
    public void Quality_of_an_item_is_never_negative() {

        GildedRose GR = new GildedRose();
        GR.GildedRose();
        ArrayList<Item> items = GR.getItemList();

        for (int i = 0; i < 100; i++) {

            GR.updateQuality();
            items.stream()
                    .forEach(item ->
                            assertThat(item.getQuality()).isGreaterThan(-1)
                    );

        }
    }

    //Permet de verfier que la qualité de l'item Brie augmente avec son age.
    @Test
    public void brie_should_increase_of_quality() {
        GildedRose GR = new GildedRose();
        GR.GildedRose();
        Item brie = GR.get("Aged Brie");
        int originQuality = brie.getQuality();
        for (int i = 0; i < 100; i++) {
            GR.updateQuality();
            assertThat(originQuality).isLessThanOrEqualTo(brie.quality);
        }
    }

    //Permet de verifier que la qualité de l'item Backstage prend de sa valeur plus la date de vente diminue.
    @Test
    public void backstage_should_increase_of_quality() {
        GildedRose GR = new GildedRose();
        GR.GildedRose();
        Item backstage = GR.get("Backstage passes to a TAFKAL80ETC concert");

        for (int i = 0; i < 100; i++) {
            int lastQualityBackstage = backstage.getQuality();
            GR.updateQuality();
            int actualQualityBackstage = backstage.getQuality();
            int sellInBackstage = backstage.getSellIn();

            if (actualQualityBackstage < 50) {
                if (sellInBackstage < 10 && sellInBackstage >= 5) {
                    assertThat(lastQualityBackstage + 2).isEqualTo(actualQualityBackstage);
                } else if (sellInBackstage < 5 && sellInBackstage >= 0) {
                    assertThat(lastQualityBackstage + 3).isEqualTo(actualQualityBackstage);

                } else if (sellInBackstage < 0) {
                    assertThat(actualQualityBackstage).isEqualTo(0);
                } else {
                    assertThat(lastQualityBackstage + 1).isEqualTo(actualQualityBackstage);
                }
            }

        }
    }

    //Permet de vérifier que la qualité de l'item conjuré diminue deux fois plus rapidement qu'un autre item.
    @Test
    public void quality_degrade__twice_item_conjured() {
        GildedRose GR = new GildedRose();
        GR.GildedRose();
        Item conjured = GR.get("Conjured Mana Cake");

        for (int i = 0; i < 100; i++) {
            int lastQualityConjured = conjured.getQuality();
            GR.updateQuality();
            int actualQualityConjured = conjured.getQuality();
            if (lastQualityConjured - 2 >= 0 && conjured.getSellIn() >= 0) {
                assertThat(lastQualityConjured - 2).isEqualTo(actualQualityConjured);
            } else if (lastQualityConjured - 4 >= 0 && conjured.getSellIn() < 0) {
                assertThat(lastQualityConjured - 4).isEqualTo(actualQualityConjured);
            }
        }
    }

    //Permet de vérifier qu'un item perd de sa valeur deux fois plus rapidement quand sa date de vente est dépassée
    @Test
    public void quality_degrade_twice_when_sell_passed() {
        GildedRose GR = new GildedRose();
        GR.GildedRose();
        ArrayList<Item> items = GR.getItemList();
        Item dexterity = GR.get("+5 Dexterity Vest");
        Item elixir = GR.get("Elixir of the Mongoose");
        Item conjured = GR.get("Conjured Mana Cake");

        for (int i = 0; i < 100; i++) {
            int lastQualityDexterity = dexterity.getQuality();
            int lastQualityElixir = elixir.getQuality();
            int lastQualityConjured = conjured.getQuality();
            GR.updateQuality();
            items.stream()
                    .forEach(
                            item -> {
                                if (item == elixir && elixir.getSellIn() < 0 && elixir.getQuality() != 0) {
                                    assertThat(lastQualityElixir - 2).isEqualTo(elixir.getQuality());
                                } else if (item == dexterity && dexterity.getSellIn() < 0 && dexterity.getQuality() != 0) {
                                    assertThat(lastQualityDexterity - 2).isEqualTo(dexterity.getQuality());
                                } else if (item == conjured && conjured.getSellIn() < 0 && lastQualityConjured - 4 >= 0) {
                                    assertThat(lastQualityConjured - 4).isEqualTo(conjured.getQuality());
                                }
                            }
                    );

        }
    }

    //Permet de vérifier qu'un item standard pert bien un de valeur avant que sa date de vente soit inferieur a 0.
    @Test
    public void quality_degrade_standard_item() {
		GildedRose GR = new GildedRose();
		GR.GildedRose();
		ArrayList<Item> items = GR.getItemList();
        Item dexterity = GR.get("+5 Dexterity Vest");
        Item elixir = GR.get("Elixir of the Mongoose");


        for (int i = 0; i < 100; i++) {
            int lastQualityDexterity = dexterity.getQuality();
            int lastQualityElixir = elixir.getQuality();
            GR.updateQuality();
            items.stream()
                    .forEach(
                            item -> {
                                if (item == elixir && elixir.getSellIn() >= 0 && elixir.getQuality() != 0) {
                                    assertThat(lastQualityElixir - 1).isEqualTo(elixir.getQuality());
                                } else if (item == dexterity && dexterity.getSellIn() >= 0 && dexterity.getQuality() != 0) {
                                    assertThat(lastQualityDexterity - 1).isEqualTo(dexterity.getQuality());
                                }
                            }
                    );

        }
    }
}




