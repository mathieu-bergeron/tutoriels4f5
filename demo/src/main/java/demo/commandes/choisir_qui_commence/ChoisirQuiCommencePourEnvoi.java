package demo.commandes.choisir_qui_commence;

import demo.enumerations.Couleur;
import ntro.client.commandes.CommandePourEnvoi;

public interface ChoisirQuiCommencePourEnvoi extends CommandePourEnvoi {
	
	void setCouleur(Couleur marque);

}
