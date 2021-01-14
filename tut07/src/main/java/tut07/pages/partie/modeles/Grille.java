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


package tut07.pages.partie.modeles;

import java.util.ArrayList;
import java.util.List;

import tut07.enumerations.Couleur;
import ntro.debogage.J;

public class Grille implements GrilleLectureSeule {
	
	protected List<Colonne> colonnes;

	public void apresCreation(int largeur) {
		J.appel(this);

		colonnes = new ArrayList<>();
		for(int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {
			Colonne nouvelleColonne = new Colonne();
			nouvelleColonne.setIdColonne(indiceColonne);
			colonnes.add(nouvelleColonne);
		}
	}

	public void apresChargementJson() {
		for(int indiceColonne = 0; indiceColonne < colonnes.size(); indiceColonne++) {
			Colonne colonne = colonnes.get(indiceColonne);
			colonne.setIdColonne(indiceColonne);
			colonne.apresChargementJson();
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
