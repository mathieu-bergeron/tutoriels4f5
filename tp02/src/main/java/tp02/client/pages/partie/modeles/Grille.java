package tp02.client.pages.partie.modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ntro.debogage.J;
import tp02.client.Couleur;

public class Grille implements GrilleLectureSeule {
	
	protected List<Colonne> colonnes;

	public void initialiser(int largeur) {
		J.appel(this);

		colonnes = new ArrayList<>();
		for(int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {
			colonnes.add(new Colonne());
		}
	}

	public void ajouterJeton(int idColonne, Couleur couleur) {
		J.appel(this);
		
		colonnes.get(idColonne).ajouterJeton(couleur);
		
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



	

}
