package demo.commandes.choisir_qui_commence;

import demo.pages.commun.enumerations.Couleur;
import ntro.client.commandes.CommandePourEnvoi;

public interface ChoisirQuiCommencePourEnvoi extends CommandePourEnvoi {
	
	void setCouleur(Couleur marque);

}
