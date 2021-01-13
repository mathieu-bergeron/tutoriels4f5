package demo.commandes.choisir_taille_grille;

import demo.enumerations.TailleGrille;
import ntro.client.commandes.CommandePourEnvoi;

public interface ChoisirTailleGrillePourEnvoi extends CommandePourEnvoi {
	
	void setTailleGrille(TailleGrille taille);

}
