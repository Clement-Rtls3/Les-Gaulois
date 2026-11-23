package personnages;

import objets.Equipement;

public class Romain {
	private static final int RESISTANCE_BOUCLIER = 6;
	private static final int RESISTANCE_CASQUE = 3;

	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
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
		return "Le romain " + nom + " : ";
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
			} else {
				ajouterEquipement(equipement);
			}
			break;
		default:
			ajouterEquipement(equipement);
			break;
		}
	}

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec " + equipement + ".");
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		Equipement[] equipementEjecte = null;
		int forceCoupRestante = calculerResistanceEquipement(forceCoup);
		force -= forceCoupRestante;
		if (force <= 0) {
			force = 0;
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		} else {
			parler("Aïe");
		}
		assert isInvariantVerified();
		return equipementEjecte;
	}

	private int calculerResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grâce à mon équipement sa force a été ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] == Equipement.BOUCLIER) {
					resistanceEquipement += RESISTANCE_BOUCLIER;
				} else {
					resistanceEquipement += RESISTANCE_CASQUE;
				}
			}
			if (forceCoup <= resistanceEquipement) {
				texte += "complètement absorbée.";
			} else {
				texte += "diminuée de " + resistanceEquipement + " !";
			}
		}
		parler(texte);
		return Math.max(forceCoup - resistanceEquipement, 0);
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		for (int i = 0; i < nbEquipement; i++) {
			equipementEjecte[i] = equipements[i];
			equipements[i] = null;
		}
		nbEquipement = 0;
		return equipementEjecte;
	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}
}
