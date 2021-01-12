package demo.client.commandes.choisir_taille_grille;

import demo.client.pages.commun.enumerations.TailleGrille;
import ntro.client.commandes.CommandePourEnvoi;

public interface ChoisirTailleGrillePourEnvoi extends CommandePourEnvoi {
	
	void setTailleGrille(TailleGrille taille);

}
