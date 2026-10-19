
package objets;

public class Chaudron {
	private int quantitePotion = 0;
	private int forcePotion = 0;

	public boolean resterPotion() {
		return quantitePotion > 0;
	}

	public void remplirChaudron(int quantite, int forcePotion) {
		quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}

	public int getForcePotion() {
		return forcePotion;
	}

	public void consommerPotion() {
		if (quantitePotion > 0) {
			quantitePotion--;
		}
	}
}
