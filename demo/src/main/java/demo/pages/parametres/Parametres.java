package demo.pages.parametres;

import demo.enumerations.Couleur;
import demo.enumerations.TailleGrille;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.modeles.Modele;

public class Parametres extends Modele<ParametresLectureSeule> implements ParametresLectureSeule {
	
	private Couleur quiCommence;
	private TailleGrille tailleGrille;

	@Override
	public void apresCreation() {
		J.appel(this);

		quiCommence = Couleur.JAUNE;
		tailleGrille = TailleGrille.MOYENNE;
	}

	@Override
	public void apresChargementJson() {
		J.appel(this);
		
		DoitEtre.nonNul(quiCommence);
		DoitEtre.nonNul(tailleGrille);
	}

	@Override
	public Couleur getQuiCommence() {
		J.appel(this);

		return quiCommence;
	}

	public void choisirQuiCommence(Couleur joueurQuiCommence) {
		J.appel(this);
		
		this.quiCommence = joueurQuiCommence;
	}

	public void choisirTailleGrille(TailleGrille tailleGrille) {
		J.appel(this);
		
		this.tailleGrille = tailleGrille;
	}

	@Override
	public TailleGrille getTailleGrille() {
		return tailleGrille;
	}
}
