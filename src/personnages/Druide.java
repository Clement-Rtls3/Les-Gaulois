
package personnages;

import objets.Chaudron;

public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron = new Chaudron();

	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void fabriquerPotion(int quantitePotion, int forcePotion) {
		chaudron.remplirChaudron(quantitePotion, forcePotion);
		parler("J'ai concocté " + quantitePotion + " doses de potion magique. Elle a une force de " + forcePotion
				+ ".");
	}

	public void boosterGaulois(Gaulois gaulois) {
		if (!chaudron.resterPotion()) {
			parler("Hummm... Ce chaudron n'a plus de potion !");
			return;
		}

		String nomGaulois = gaulois.getNom();

		if (nomGaulois.equals("Obélix") || nomGaulois.equals("Obelix")) {
			parler("Non, Obélix ! Non !... Et tu le sais très bien !");
			return;
		}

		gaulois.prendreLouche(chaudron.getForcePotion());
		chaudron.consommerPotion();

		parler("Tiens " + nomGaulois + " un peu de potion magique.");
	}
}
