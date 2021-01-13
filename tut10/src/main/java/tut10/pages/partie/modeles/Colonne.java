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


package tut10.pages.partie.modeles;

import java.util.ArrayList;

import java.util.List;

import tut10.enumerations.Couleur;
import ntro.debogage.J;

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

	public void apresChargementJson() {
		J.appel(this);
		
		for(int indiceRangee = 0; indiceRangee < jetons.size(); indiceRangee++) {
			Jeton jeton = jetons.get(indiceRangee);
			jeton.setIndiceColonne(idColonne);
			jeton.setIndiceRangee(indiceRangee);
		}
	}
	
}
