package demo.client.pages.partie.modeles;

import java.net.IDN;
import java.util.ArrayList;
import java.util.List;

import ntro.debogage.J;
import demo.client.Couleur;

public class Grille implements GrilleLectureSeule {
	
	protected List<Colonne> colonnes;

	public void initialiser(int largeur) {
		J.appel(this);

		colonnes = new ArrayList<>();
		for(int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {
			Colonne nouvelleColonne = new Colonne();
			nouvelleColonne.setIdColonne(indiceColonne);
			colonnes.add(nouvelleColonne);
		}
	}

	public Jeton ajouterJeton(int idColonne, Couleur couleur) {
		J.appel(this);
		
		return colonnes.get(idColonne).ajouterJeton(couleur);
	}

	@Override
	public List<ColonneLectureSeule> getColonnes() {
		J.appel(this);
		
		List<ColonneLectureSeule> colonnesLectureSeule = new ArrayList<>();
		
		for(Colonne colonne : colonnes) {
			
			colonnesLectureSeule.add((ColonneLectureSeule) colonne);
			
		}
		
		return colonnesLectureSeule;
		
	}

	public boolean siPossibleJouerIci(int indiceColonne, int hauteur) {
		J.appel(this);

		boolean siPossible = false;
		
		if(siIndiceColonneValide(indiceColonne)){

			siPossible = colonnes.get(indiceColonne).siPossibleJouerIci(hauteur);
		}

		return siPossible;
	}

	private boolean siIndiceColonneValide(int indiceColonne) {
		J.appel(this);

		return indiceColonne >= 0 && indiceColonne < colonnes.size();
	}



	

}
