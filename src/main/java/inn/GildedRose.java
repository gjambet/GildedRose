package inn;
import java.util.Optional;


public class GildedRose {

	private Stock goods;
	private QualityManager qm;

	public Stock getGoods() {
		return goods;
	}

	public QualityManager getQm() {
		return qm;
	}

	public GildedRose() {
		//On cree l'inventaire de la taverne sous forme de liste
		//puis on applique l'algorithme de gestion de qualite/tps restant pour la vente sur cette liste
		this.goods = new Stock();
		this.qm = new QualityManager();
	}

	public Item get(String itemName) {
		Stock goods = new Stock();
		Optional<Item> optional =
				goods.getItems().stream()
						.filter(item -> item.getName().equals(itemName))
						.findFirst();

		if (optional.isPresent()){
			return optional.get();
		}else {
			throw new IllegalStateException("pas trouvé");
		}


	}

	public void updateQuality() {

		goods.getItems().stream()
				.forEach(x -> {
					qm.updateQuality2(x);
				});
	}

	public void updateQuality(Item item){
		qm.updateQuality2(item);
	}

}