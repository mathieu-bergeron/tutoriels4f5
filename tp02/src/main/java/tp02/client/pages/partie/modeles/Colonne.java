package tp02.client.pages.partie.modeles;

import java.util.ArrayList;

import java.util.List;

import ntro.debogage.J;
import tp02.client.Couleur;

public class Colonne implements ColonneLectureSeule {
	
	private List<Jeton> jetons = new ArrayList<>();

	public void ajouterJeton(Couleur couleur) {
		J.appel(this);
		
		Jeton jeton = new Jeton();
		
		jeton.initialiser(couleur);
		
		jetons.add(jeton);
	}

	@Override
	public List<JetonLectureSeule> getJetons() {
		J.appel(this);
		
		List<JetonLectureSeule> jetonsLectureSeule = new ArrayList<>();
		
		for(Jeton jeton : jetons) {

			jetonsLectureSeule.add((JetonLectureSeule) jeton);
		}
		
		return jetonsLectureSeule;
	}
}
