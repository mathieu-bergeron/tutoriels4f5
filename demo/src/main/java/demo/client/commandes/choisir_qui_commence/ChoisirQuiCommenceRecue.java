package demo.client.commandes.choisir_qui_commence;

import ntro.client.commandes.CommandeRecue;
import demo.client.pages.parametres.modeles.Marque;

public interface ChoisirQuiCommenceRecue extends CommandeRecue {
	
	Marque getMarque();

}
