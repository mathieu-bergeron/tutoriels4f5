package tp02.client.commandes.choisir_qui_commence;

import ntro.client.commandes.CommandePourEnvoi;
import tp02.client.pages.parametres.modeles.Marque;

public interface ChoisirQuiCommencePourEnvoi extends CommandePourEnvoi {
	
	void setMarque(Marque marque);

}
