// Copyright (C) (2020) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)
//
// This file is part of tutoriels4f5
//
// tutoriels4f5 is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// tutoriels4f5 is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
//
// You should have received a copy of the GNU Affero General Public License
// along with aquiletour.  If not, see <https://www.gnu.org/licenses/>


package tut04.pages.partie.afficheurs;

import java.util.List;

import ntro.debogage.J;
import ntro.mvc.Afficheur;
import tut04.enumerations.Couleur;
import tut04.pages.partie.modeles.ColonneLectureSeule;
import tut04.pages.partie.modeles.GrilleLectureSeule;
import tut04.pages.partie.modeles.JetonLectureSeule;
import tut04.pages.partie.modeles.PartieLectureSeule;
import tut04.pages.partie.vues.VuePartie;


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
