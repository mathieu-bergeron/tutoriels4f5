package demo.client.commandes.ouvrir_sauvegarde;

import ntro.debogage.J;
import ntro.client.commandes.Commande;

public class OuvrirSauvegarde 
       extends    Commande<OuvrirSauvegardePourEnvoi,
                        OuvrirSauvegardeRecue>
	   implements OuvrirSauvegardePourEnvoi,
	              OuvrirSauvegardeRecue {
	
	private String cheminDansHome;

	@Override
	public String getCheminDansHome() {
		J.appel(this);
		
		return cheminDansHome;
	}

	@Override
	public void setCheminDansHome(String cheminDansHome) {
		J.appel(this);
		
		this.cheminDansHome = cheminDansHome;
	}

}
