package demo.client.commandes.choisir_qui_commence;

import ntro.client.commandes.CommandePourEnvoi;
import demo.client.pages.parametres.modeles.Marque;

public interface ChoisirQuiCommencePourEnvoi extends CommandePourEnvoi {
	
	void setMarque(Marque marque);

}
