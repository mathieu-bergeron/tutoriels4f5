package demo.enumerations;

import static demo.Constantes.*;

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
