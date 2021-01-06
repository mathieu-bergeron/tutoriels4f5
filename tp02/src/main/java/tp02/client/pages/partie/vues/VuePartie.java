package tp02.client.pages.partie.vues;

import ntro.client.mvc.Vue;
import tp02.client.Couleur;

public interface VuePartie extends Vue {

	void creerGrille(int largeur, int hauteur);
	void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur);

}
