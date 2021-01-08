package demo.client.pages.parametres.modeles;

import java.util.Random;

import demo.client.Couleur;
import ntro.debogage.J;
import ntro.modeles.Modele;

public class Parametres extends Modele<ParametresLectureSeule> implements ParametresLectureSeule {
	
	private Couleur quiCommence = (new Random().nextBoolean()) ? Couleur.JAUNE : Couleur.ROUGE;

	@Override
	public Couleur getQuiCommence() {
		J.appel(this);

		return quiCommence;
	}

	public void choisirQuiCommence(Couleur joueurQuiCommence) {
		J.appel(this);
		
		this.quiCommence = joueurQuiCommence;
	}

}
