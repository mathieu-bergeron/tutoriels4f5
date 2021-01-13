package demo.commandes.choisir_qui_commence;

import demo.pages.commun.enumerations.Couleur;
import ntro.client.commandes.CommandeRecue;

public interface ChoisirQuiCommenceRecue extends CommandeRecue {
	
	Couleur getCouleur();

}
