package demo.client.pages.partie.modeles;

import ntro.debogage.J;
import demo.client.Couleur;

public class Jeton implements JetonLectureSeule {
	
	private Couleur couleur;

	public void initialiser(Couleur couleur) {
		J.appel(this);

		this.couleur = couleur;
	}

	@Override
	public Couleur getCouleur() {
		J.appel(this);

		return couleur;
	}
}
