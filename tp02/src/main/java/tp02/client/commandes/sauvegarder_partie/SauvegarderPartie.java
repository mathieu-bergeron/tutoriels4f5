package tp02.client.commandes.sauvegarder_partie;


import ntro.debogage.J;
import ntro.client.commandes.Commande;

public class SauvegarderPartie 
       extends    Commande<SauvegarderPartiePourEnvoi,
                        SauvegarderPartieRecue>
	   implements SauvegarderPartiePourEnvoi,
	              SauvegarderPartieRecue {
	
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
