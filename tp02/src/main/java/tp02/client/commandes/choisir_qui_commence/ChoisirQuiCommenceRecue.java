package tp02.client.commandes.choisir_qui_commence;

import ntro.client.commandes.CommandeRecue;
import tp02.client.pages.parametres.modeles.Marque;

public interface ChoisirQuiCommenceRecue extends CommandeRecue {
	
	Marque getMarque();

}
