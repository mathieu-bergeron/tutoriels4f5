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


package tut06;

import tut06.enumerations.TailleGrille;

public class Constantes {
	
	public static final String ID_MODELE_PAR_DEFAUT = "defaut";
	
	public static final String CHEMIN_PRINCIPAL_FXML = "/accueil/structure.xml";
	public static final String CHEMIN_PARAMETRES_FXML = "/parametres/structure.xml";
	public static final String CHEMIN_PARTIE_LOCALE_FXML = "/partie/locale/structure.xml";
	
	public static final int HAUTEUR_GRILLE_PETITE = 4;
	public static final int HAUTEUR_GRILLE_MOYENNE = 6;
	public static final int HAUTEUR_GRILLE_GRANDE = 10;

	public static final int LARGEUR_GRILLE_PETITE = 4;
	public static final int LARGEUR_GRILLE_MOYENNE = 5;
	public static final int LARGEUR_GRILLE_GRANDE = 8;
	
	public static final TailleGrille TAILLE_GRILLE_PAR_DEFAUT = TailleGrille.PETITE;

	public static final int TAILLE_CASE = 40;

	public static final int LARGEUR_PIXELS_MIN = 400;
	public static final int HAUTEUR_PIXELS_MIN = 600;

	public static final int LARGEUR_PIXELS = 600;
	public static final int HAUTEUR_PIXELS= 800;

	public static final int LARGEUR_PARAMETRES_PIXELS_MIN = 250;
	public static final int HAUTEUR_PARAMETRES_PIXELS_MIN = 500;

	public static final int LARGEUR_PARAMETRES_PIXELS = 300;
	public static final int HAUTEUR_PARAMETRES_PIXELS = 520;

	public static final int LARGEUR_PARAMETRES_PIXELS_MAX = 350;
	public static final int HAUTEUR_PARAMETRES_PIXELS_MAX = 540;

}
