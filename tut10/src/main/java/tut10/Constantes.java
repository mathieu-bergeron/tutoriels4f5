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


package tut10;

import tut10.enumerations.TailleGrille;

public class Constantes {
	
	public static final String ID_MODELE_PAR_DEFAUT = "defaut";
	
	public static final String CHEMIN_CHAINES = "traductions.chaines";

	public static final String CHEMIN_PRINCIPAL_FXML = "/accueil/structure.xml";
	public static final String CHEMIN_PRINCIPAL_CSS = "/accueil/style.css";

	public static final String CHEMIN_PARAMETRES_FXML = "/parametres/structure.xml";
	public static final String CHEMIN_PARAMETRES_CSS = "/parametres/style.css";

	public static final String CHEMIN_PARTIE_LOCALE_FXML = "/partie/locale/structure.xml";
	public static final String CHEMIN_PARTIE_LOCALE_CSS = "/partie/locale/style.css";

	public static final String CHEMIN_PARTIE_RESEAU_FXML = "/partie/reseau/structure.xml";
	public static final String CHEMIN_PARTIE_RESEAU_CSS = "/partie/reseau/style.css";
	
	public static final int HAUTEUR_GRILLE_PETITE = 4;
	public static final int HAUTEUR_GRILLE_MOYENNE = 6;
	public static final int HAUTEUR_GRILLE_GRANDE = 10;

	public static final int LARGEUR_GRILLE_PETITE = 4;
	public static final int LARGEUR_GRILLE_MOYENNE = 5;
	public static final int LARGEUR_GRILLE_GRANDE = 8;
	
	public static final TailleGrille TAILLE_GRILLE_PAR_DEFAUT = TailleGrille.PETITE;

	public static final int PORT = 8765;
	public static final String ADRESSE_SERVEUR = String.format("ws://localhost:%s", PORT);

	public static final int TAILLE_POLICE = 15;
	public static final int TAILLE_POLICE_MIN = 11;
	public static final int TAILLE_POLICE_MAX = 18;

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
	
	public static double AJUSTEMENT_TAILLE_PIXELS = 1.0;

}
