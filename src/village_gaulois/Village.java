package village_gaulois;

import personnages.Gaulois;

public class Village {
	private static final int NB_VILLAGEOIS_MAX = 30;
	private String nom;
	private int nbVillageois = 0;

	private final Gaulois chef;

	private Gaulois[] villageois;

	public Village(String nom, Gaulois chef) {
		if (chef == null) {
			throw new IllegalArgumentException("Un village doit avoir un chef");
		}
		this.nom = nom;
		this.chef = chef;
		this.chef.setVillage(this);
		this.villageois = new Gaulois[NB_VILLAGEOIS_MAX];
	}

	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois >= NB_VILLAGEOIS_MAX) {
			System.out.println("Limite du nombre de villageois atteinte !");
		} else {
			nbVillageois++;
			for (int i = 0; i < nbVillageois; i++) {
				if (villageois[i] == null) {
					villageois[i] = gaulois;
					gaulois.setVillage(this);
				}
			}
		}
	}

	public Gaulois trouverVillageois(int numeroVillageois) {
		if (numeroVillageois > NB_VILLAGEOIS_MAX || numeroVillageois <= 0) {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		} else {
			if (villageois[numeroVillageois - 1] == null) {
				System.out.println("Il n'y a pas autant de d'habitants dans notre village !");
				return null;
			} else {
				return villageois[numeroVillageois - 1];
			}
		}
	}

	public String afficherVillage() {
		return "Village [nom=" + nom + ", nbVillageois=" + nbVillageois + ", chef=" + chef + "]";
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void afficherVillageois() {
		System.out.println(
				"Dans le village Village des Irréductibles du chef " + chef + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i]);
		}
	}

	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		asterix.sePresenter();
		abraracourcix.sePresenter();
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);
		village.afficherVillageois();
		Gaulois doublepolemix = new Gaulois("doublepolemix", 4);
		abraracourcix.sePresenter();
		obelix.sePresenter();
		doublepolemix.sePresenter();

	}

}