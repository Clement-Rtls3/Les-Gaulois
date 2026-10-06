package test_fonctionnel;


import personnages.Romain;

import personnages.Gaulois;


public class TestGaulois {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obelix", 16);
		asterix.parler("salut");
		obelix.parler("Bonjour Astérix. Ca te dirais d'aller chasser des sangliers ?");
		asterix.parler("Oui très bonne idée.");
		Romain minus = new Romain("Minus", 6);
		System.out.println("Dans la forêt Astérix et Obélix tombent nez à nez sur le romain Minus.");
		asterix.frapper(minus);
		

	}

}
