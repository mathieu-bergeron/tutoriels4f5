package demo.client.commandes.choisir_taille_grille;

import demo.client.pages.commun.enumerations.TailleGrille;
import ntro.client.commandes.CommandeRecue;

public interface ChoisirTailleGrilleRecue extends CommandeRecue {
	
	TailleGrille getTailleGrille();

}
