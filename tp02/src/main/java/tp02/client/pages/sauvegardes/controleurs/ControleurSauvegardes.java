package tp02.client.pages.sauvegardes.controleurs;

import ntro.debogage.J;
import tp02.client.pages.sauvegardes.afficheurs.AfficheurSauvegardes;
import tp02.client.pages.sauvegardes.modeles.Sauvegardes;
import tp02.client.pages.sauvegardes.modeles.SauvegardesLectureSeule;
import tp02.client.pages.sauvegardes.vues.VueSauvegardes;
import ntro.client.mvc.controleurs.ControleurModeleVue;

public abstract class ControleurSauvegardes<V extends VueSauvegardes, 
                                   A extends AfficheurSauvegardes<V>>

	   extends ControleurModeleVue<SauvegardesLectureSeule, 
	                               Sauvegardes,
	                               V,
	                               A> {

	@Override
	protected void demarrer() {
		J.appel(this);
		
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);

	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
		
	}
}
