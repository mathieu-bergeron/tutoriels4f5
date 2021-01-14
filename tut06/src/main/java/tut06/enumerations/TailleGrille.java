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


package tut06.enumerations;

import static tut06.Constantes.*;

import ntro.debogage.J;

public enum TailleGrille {
	
	PETITE(HAUTEUR_GRILLE_PETITE, LARGEUR_GRILLE_PETITE), 
	MOYENNE(HAUTEUR_GRILLE_MOYENNE, LARGEUR_GRILLE_MOYENNE), 
	GRANDE(HAUTEUR_GRILLE_GRANDE, LARGEUR_GRILLE_GRANDE);

	private int hauteur;
	private int largeur;
	
	private TailleGrille(int hauteur, int largeur) {
		J.appel(this);

		this.hauteur = hauteur;
		this.largeur = largeur;
	}
	
	public int getHauteur(){
		return hauteur;
	}

	public int getLargeur(){
		return largeur;
	}
}
