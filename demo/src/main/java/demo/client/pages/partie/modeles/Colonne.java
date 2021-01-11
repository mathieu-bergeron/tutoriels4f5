package demo.client.pages.partie.modeles;

import java.util.ArrayList;

import java.util.List;

import ntro.debogage.J;
import demo.client.Couleur;

public class Colonne implements ColonneLectureSeule {
	
	private List<Jeton> jetons = new ArrayList<>();
	private transient int idColonne;

	public Jeton ajouterJeton(Couleur couleur) {
		J.appel(this);
		
		Jeton jeton = new Jeton();

		jeton.setCouleur(couleur);
		jeton.setIndiceColonne(idColonne);
		jeton.setIndiceRangee(jetons.size());
		
		jetons.add(jeton);
		
		return jeton;
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

	public int getIdColonne() {
		return idColonne;
	}

	public void setIdColonne(int idColonne) {
		this.idColonne = idColonne;
	}

	public boolean siPossibleJouerIci(int hauteur) {
		J.appel(this);

		return jetons.size() < hauteur;
	}
	
}
