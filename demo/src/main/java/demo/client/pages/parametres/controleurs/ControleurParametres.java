package demo.client.pages.parametres.controleurs;

import ntro.client.mvc.controleurs.ControleurModeleVue;
import ntro.client.mvc.controleurs.RecepteurCommandeMVC;
import ntro.debogage.J;
import demo.client.commandes.choisir_qui_commence.ChoisirQuiCommence;
import demo.client.commandes.choisir_qui_commence.ChoisirQuiCommenceRecue;
import demo.client.pages.parametres.afficheurs.AfficheurParametres;
import demo.client.pages.parametres.modeles.Parametres;
import demo.client.pages.parametres.modeles.ParametresLectureSeule;
import demo.client.pages.parametres.vues.VueParametres;

public class   ControleurParametres 
       extends ControleurModeleVue<ParametresLectureSeule, 
                                   Parametres,
                                   VueParametres,
                                   AfficheurParametres> {
	

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(ChoisirQuiCommence.class, new RecepteurCommandeMVC<ChoisirQuiCommenceRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirQuiCommenceRecue commande) {
				J.appel(this);
				
				getModele().choisirQuiCommence(commande.getCouleur());
				
			}
		});
	}

	@Override
	protected void demarrer() {
		J.appel(this);

	} 

	@Override
	protected void obtenirMessagesPourEnvoi() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void installerReceptionMessages() {
		// TODO Auto-generated method stub
		
	}
}