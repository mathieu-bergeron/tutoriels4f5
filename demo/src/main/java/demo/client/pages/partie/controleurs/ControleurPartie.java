package demo.client.pages.partie.controleurs;

import ntro.client.mvc.controleurs.ControleurModeleVue;
import ntro.client.mvc.controleurs.RecepteurCommandeMVC;
import ntro.debogage.J;
import demo.client.commandes.jouer_ici.JouerIci;
import demo.client.commandes.jouer_ici.JouerIciRecue;
import demo.client.pages.partie.afficheurs.AfficheurPartie;
import demo.client.pages.partie.modeles.Partie;
import demo.client.pages.partie.modeles.PartieLectureSeule;
import demo.client.pages.partie.vues.VuePartie;

public abstract class  ControleurPartie<PLS extends PartieLectureSeule, 
							    P extends Partie<PLS>,
                                V extends VuePartie, 
                                A extends AfficheurPartie<PLS, V>>

	            extends ControleurModeleVue<PLS, P, V, A> {

	@Override
	protected void demarrer() {
		J.appel(this);
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
		
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
		
	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(JouerIci.class, new RecepteurCommandeMVC<JouerIciRecue>() {
			@Override
			public void executerCommandeMVC(JouerIciRecue commande) {
				J.appel(this);
				
				reagirCommandeJouerIci(commande);
			}
			
			@Override
			public boolean siCommandePossible(JouerIciRecue commande) {
				J.appel(this);
				
				return getModele().siPossibleJouerIci(commande.getIndiceColonne());
			}
		});
	} 
	
	protected void reagirCommandeJouerIci(JouerIciRecue jouerIciRecue) {
		J.appel(this);

			getModele().jouerIci(jouerIciRecue.getIndiceColonne());
	}
}
