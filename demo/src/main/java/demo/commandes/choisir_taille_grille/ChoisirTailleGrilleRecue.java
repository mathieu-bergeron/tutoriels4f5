package demo.commandes.choisir_taille_grille;

import demo.pages.commun.enumerations.TailleGrille;
import ntro.client.commandes.CommandeRecue;

public interface ChoisirTailleGrilleRecue extends CommandeRecue {
	
	TailleGrille getTailleGrille();

}
