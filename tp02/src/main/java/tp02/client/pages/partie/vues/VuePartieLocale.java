package tp02.client.pages.partie.vues;

import tp02.client.Couleur;

public interface VuePartieLocale extends VuePartie {

	void creerGrille(int largeur, int hauteur);
	void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur);

}
