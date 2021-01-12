package demo.client.commandes.choisir_qui_commence;

import demo.client.pages.commun.enumerations.Couleur;
import ntro.client.commandes.Commande;
import ntro.debogage.J;

public class ChoisirQuiCommence extends Commande<ChoisirQuiCommencePourEnvoi, ChoisirQuiCommenceRecue> 
						   implements ChoisirQuiCommencePourEnvoi, ChoisirQuiCommenceRecue {
	
	private Couleur couleur;

	@Override
	public Couleur getCouleur() {
		J.appel(this);
		
		return couleur;
	}

	@Override
	public void setCouleur(Couleur marque) {
		J.appel(this);
		
		this.couleur = marque;
	}

}
