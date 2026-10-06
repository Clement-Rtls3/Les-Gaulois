package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoir_coup(int forceCoup) {
		int stop = 0;
		for (int i = 0; i < forceCoup && stop == 0; i++) {
			if (this.force == 1) {
				parler("J'abandonne !");
				stop = 1;
			} else {
				parler("Aie !");
				this.force = this.force - 1;
			}
		}
	}
}