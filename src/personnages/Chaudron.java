package personnages;

public class Chaudron {
	int quantitePotion;
	int forcePotion;

	public Chaudron(int quantitePotion, int forcePotion) {
		this.quantitePotion = quantitePotion;
		this.forcePotion = forcePotion;
	}

	public boolean rester_potion() {
		if (quantitePotion == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void remplirChaudron(int quantite, int forcePotion) {
		this.forcePotion = quantite;
		this.forcePotion = forcePotion;
	}

}
