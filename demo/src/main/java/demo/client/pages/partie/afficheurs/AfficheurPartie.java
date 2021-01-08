package demo.client.pages.partie.afficheurs;

import java.util.List;

import ntro.client.mvc.Afficheur;
import ntro.debogage.J;
import demo.client.Couleur;
import demo.client.pages.partie.modeles.ColonneLectureSeule;
import demo.client.pages.partie.modeles.GrilleLectureSeule;
import demo.client.pages.partie.modeles.JetonLectureSeule;
import demo.client.pages.partie.modeles.PartieLectureSeule;
import demo.client.pages.partie.vues.VuePartie;


public abstract class   AfficheurPartie<PLS extends PartieLectureSeule, 
                                        V extends VuePartie> 

				extends Afficheur<PLS, V> {

	@Override
	public void initialiserAffichage(PLS partieLectureSeule, V vue) {
		J.appel(this);
		
		int largeur = partieLectureSeule.getLargeur();
		int hauteur = partieLectureSeule.getHauteur();
		
		vue.creerGrille(largeur, hauteur);
	}

	@Override
	public void rafraichirAffichage(PLS partieLectureSeule, V vue) {
		J.appel(this);

		GrilleLectureSeule grille = partieLectureSeule.getGrille();
		
		int hauteurGrille = partieLectureSeule.getHauteur();
		
		rafraichirGrille(hauteurGrille, grille, vue);
	}

	private void rafraichirGrille(int hauteurGrille, GrilleLectureSeule grille, V vue) {
		J.appel(this);

		List<ColonneLectureSeule> colonnes = grille.getColonnes();
		
		for(int indiceColonne = 0; indiceColonne < colonnes.size(); indiceColonne++) {
		
			ColonneLectureSeule colonne = colonnes.get(indiceColonne);
			List<JetonLectureSeule> jetons = colonne.getJetons();
			
			rafraichirColonne(hauteurGrille, indiceColonne, jetons, vue);

		}
	}

	private void rafraichirColonne(int hauteurGrille, 
								   int indiceColonne, 
								   List<JetonLectureSeule> jetons, 
								   V vue) {
		J.appel(this);
		
		
		for(int indiceRangee = 0; indiceRangee < jetons.size(); indiceRangee++) {
			
			JetonLectureSeule jeton = jetons.get(indiceRangee);
			Couleur couleur = jeton.getCouleur();
			
			afficherJeton(hauteurGrille, indiceColonne, indiceRangee, couleur, vue);
		}
	}
	
	private void afficherJeton(int hauteurGrille, 
			                   int indiceColonne,  
			                   int indiceRangee, 
			                   Couleur couleur,
			                   V vue) {
		J.appel(this);
		
		int indiceRangeeCoordonneesGraphiques = convertirEnCoordonneesGraphiques(hauteurGrille, indiceRangee);

		vue.afficherJeton(indiceColonne, indiceRangeeCoordonneesGraphiques, couleur);
	}
	
	private int convertirEnCoordonneesGraphiques(int hauteurGrille, int indiceRangee) {
		J.appel(this);

		return hauteurGrille - indiceRangee - 1;
	}

}
