package tp02.client.pages.parametres.controleurs;

import ntro.client.mvc.controleurs.ControleurModeleVue;
import ntro.client.mvc.controleurs.RecepteurCommandeMVC;
import ntro.debogage.J;
import tp02.client.commandes.choisir_qui_commence.ChoisirQuiCommence;
import tp02.client.commandes.choisir_qui_commence.ChoisirQuiCommenceRecue;
import tp02.client.pages.parametres.afficheurs.AfficheurParametres;
import tp02.client.pages.parametres.modeles.Parametres;
import tp02.client.pages.parametres.modeles.ParametresLectureSeule;
import tp02.client.pages.parametres.vues.VueParametres;

public abstract class ControleurParametres<V extends VueParametres,
					       				     A extends AfficheurParametres<V>> 

					extends ControleurModeleVue<ParametresLectureSeule, 
											    Parametres, 
											    V, 
											    A> {
	

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(ChoisirQuiCommence.class, new RecepteurCommandeMVC<ChoisirQuiCommenceRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirQuiCommenceRecue commande) {
				J.appel(this);
				
				modele.choisirQuiCommence(commande.getMarque());
				
			}
		});
	}

	@Override
	protected void demarrer() {
		J.appel(this);

	} 
}