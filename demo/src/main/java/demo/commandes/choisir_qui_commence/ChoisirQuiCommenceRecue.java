package demo.commandes.choisir_qui_commence;

import demo.enumerations.Couleur;
import ntro.client.commandes.CommandeRecue;

public interface ChoisirQuiCommenceRecue extends CommandeRecue {
	
	Couleur getCouleur();

}
