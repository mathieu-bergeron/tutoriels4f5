package tp02.client.commandes.choisir_qui_commence;

import ntro.client.commandes.Commande;
import ntro.debogage.J;
import tp02.client.pages.parametres.modeles.Marque;

public class ChoisirQuiCommence extends Commande<ChoisirQuiCommencePourEnvoi, ChoisirQuiCommenceRecue> 
						   implements ChoisirQuiCommencePourEnvoi, ChoisirQuiCommenceRecue {
	
	private Marque marque;

	@Override
	public Marque getMarque() {
		J.appel(this);
		
		return marque;
	}

	@Override
	public void setMarque(Marque marque) {
		J.appel(this);
		
		this.marque = marque;
	}

}
