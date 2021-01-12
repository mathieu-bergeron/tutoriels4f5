package demo.client.commandes.choisir_qui_commence;

import demo.client.pages.commun.enumerations.Couleur;
import ntro.client.commandes.CommandePourEnvoi;

public interface ChoisirQuiCommencePourEnvoi extends CommandePourEnvoi {
	
	void setCouleur(Couleur marque);

}
