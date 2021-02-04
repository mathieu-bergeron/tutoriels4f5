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


package tutoriel;

import tutoriel.enumerations.TailleGrille;

public class Constantes {
	
	public static final String[] IDS_MODELES_TESTS = {"test01","test02","test03"};

	public static final int HAUTEUR_GRILLE_PETITE = 4;
	public static final int HAUTEUR_GRILLE_MOYENNE = 6;
	public static final int HAUTEUR_GRILLE_GRANDE = 10;

	public static final int LARGEUR_GRILLE_PETITE = 4;
	public static final int LARGEUR_GRILLE_MOYENNE = 5;
	public static final int LARGEUR_GRILLE_GRANDE = 8;
	
	public static final TailleGrille TAILLE_GRILLE_PAR_DEFAUT = TailleGrille.PETITE;
}
