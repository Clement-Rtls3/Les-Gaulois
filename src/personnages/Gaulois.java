
package personnages;

import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Gaulois " + nom + " : ";
	}

	@Override
	public String toString() {
		return nom;
	}

	public void prendreLouche(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());

		int forceCoup = (force * effetPotion) / 3;
		romain.recevoirCoup(forceCoup);

		if (effetPotion > 1) {
			effetPotion--;
		}
	}

	public void sePresenter() {
		if (village != null && village.getChef() == this) {
			System.out.println(prendreParole() + "Bonjour je m'apelle " + nom + ". Je suis le chef le village : "
					+ village.getNom());
		} else if (village == null) {
			System.out.println(prendreParole() + "Bonjour je m'apelle " + nom + ". Je voyage de villages en villages");
		} else {
			System.out.println(
					prendreParole() + "Bonjour je m'apelle " + nom + ". J'habite le village " + village.getNom());
		}

	}
}
