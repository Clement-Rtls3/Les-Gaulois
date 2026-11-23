package personnages;

import objets.Equipement;
import village_gaulois.Musee;
import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;
	private int nbTrophees = 0;
	private Equipement[] trophees = new Equipement[100];

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
		return "Le gaulois " + nom + " : ";
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
		Equipement[] tropheesGagnes = romain.recevoirCoup((force / 2) * effetPotion);
		if (effetPotion > 1) {
			effetPotion--;
		}
		for (int i = 0; tropheesGagnes != null && i < tropheesGagnes.length; i++, nbTrophees++) {
			trophees[nbTrophees] = tropheesGagnes[i];
		}
	}

	public void faireUneDonnation(Musee musee) {
		if (nbTrophees == 0) {
			return;
		}
		String texte = "Je donne au musee tous mes trophees :";
		for (int i = 0; i < nbTrophees; i++) {
			texte += "\n- " + trophees[i];
			musee.donnerTrophees(this, trophees[i]);
		}
		parler(texte);
		nbTrophees = 0;
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
