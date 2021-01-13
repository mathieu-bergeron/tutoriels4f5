package demo.pages.commun.enumerations;

import static demo.client.Constantes.*;

public enum TailleGrille {
	
	PETITE, MOYENNE, GRANDE;
	
	public int getHauteur(){
		
		int hauteur = HAUTEUR_GRILLE_DEFAUT;
		
		switch(this) {
			case PETITE:
				hauteur = HAUTEUR_GRILLE_PETITE;
				break;

			case MOYENNE:
				hauteur = HAUTEUR_GRILLE_MOYENNE;
				break;

			case GRANDE:
				hauteur = HAUTEUR_GRILLE_GRANDE;
				break;
		}
		
		return hauteur;
	}

	public int getLargeur(){

		int largeur = LARGEUR_GRILLE_DEFAUT;
		
		switch(this) {
			case PETITE:
				largeur = LARGEUR_GRILLE_PETITE;
				break;

			case MOYENNE:
				largeur = LARGEUR_GRILLE_MOYENNE;
				break;

			case GRANDE:
				largeur = LARGEUR_GRILLE_GRANDE;
				break;
		}
		
		return largeur;
	}

}
