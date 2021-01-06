package tp02.client.pages.accueil.controleurs;

import ntro.client.mvc.controleurs.ControleurVue;
import ntro.debogage.J;
import tp02.client.pages.accueil.vues.VueAccueil;

public abstract class ControleurAccueil<V extends VueAccueil> extends ControleurVue<V> {
	
	
	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
	}
	
}
