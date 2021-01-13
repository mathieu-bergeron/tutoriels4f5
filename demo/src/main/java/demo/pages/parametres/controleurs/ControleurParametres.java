package demo.pages.parametres.controleurs;

import ntro.client.mvc.controleurs.ControleurModeleVue;
import ntro.client.mvc.controleurs.RecepteurCommandeMVC;
import ntro.client.mvc.controleurs.RecepteurMessageMVC;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.messages.FabriqueMessage;
import demo.client.Main;
import demo.commandes.choisir_qui_commence.ChoisirQuiCommence;
import demo.commandes.choisir_qui_commence.ChoisirQuiCommenceRecue;
import demo.commandes.choisir_taille_grille.ChoisirTailleGrille;
import demo.commandes.choisir_taille_grille.ChoisirTailleGrilleRecue;
import demo.pages.parametres.afficheurs.AfficheurParametres;
import demo.pages.parametres.modeles.Parametres;
import demo.pages.parametres.modeles.ParametresLectureSeule;
import demo.pages.parametres.vues.VueParametres;
import demo.messages.transmettre_qui_commence.MsgTransmettreQuiCommence;
import demo.messages.transmettre_qui_commence.MsgTransmettreQuiCommencePourEnvoi;
import demo.messages.transmettre_qui_commence.MsgTransmettreQuiCommenceRecu;
import demo.messages.transmettre_taille.MsgTransmettreTaille;
import demo.messages.transmettre_taille.MsgTransmettreTaillePourEnvoi;
import demo.messages.transmettre_taille.MsgTransmettreTailleRecu;

public class   ControleurParametres 
       extends ControleurModeleVue<ParametresLectureSeule, 
                                   Parametres,
                                   VueParametres,
                                   AfficheurParametres> {
	
	private MsgTransmettreQuiCommencePourEnvoi msgTransmettreQuiCommence;
	private MsgTransmettreTaillePourEnvoi msgTransmettreTaille;

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(ChoisirQuiCommence.class, new RecepteurCommandeMVC<ChoisirQuiCommenceRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirQuiCommenceRecue commande) {
				J.appel(this);
				
				DoitEtre.nonNul(commande.getCouleur());
				
				getModele().choisirQuiCommence(commande.getCouleur());
				
				if(Main.siConnecteAuServeur()) {
					msgTransmettreQuiCommence.setQuiCommence(commande.getCouleur());
					msgTransmettreQuiCommence.envoyerMessage();
				}
			}
		});
		
		installerRecepteurCommande(ChoisirTailleGrille.class, new RecepteurCommandeMVC<ChoisirTailleGrilleRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirTailleGrilleRecue commande) {
				J.appel(this);
				
				DoitEtre.nonNul(commande.getTailleGrille());
				
				getModele().choisirTailleGrille(commande.getTailleGrille());

				if(Main.siConnecteAuServeur()) {
					msgTransmettreTaille.setTailleGrille(commande.getTailleGrille());
					msgTransmettreTaille.envoyerMessage();
				}
			}
		});
	}

	@Override
	protected void demarrer() {
		J.appel(this);

	} 

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
		
		msgTransmettreQuiCommence = FabriqueMessage.obtenirMessagePourEnvoi(MsgTransmettreQuiCommence.class);
		msgTransmettreTaille = FabriqueMessage.obtenirMessagePourEnvoi(MsgTransmettreTaille.class);
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
		
		installerRecepteurMessage(MsgTransmettreQuiCommence.class, new RecepteurMessageMVC<MsgTransmettreQuiCommenceRecu>() {

			@Override
			public void recevoirMessageMVC(MsgTransmettreQuiCommenceRecu messageRecu) {
				J.appel(this);
				
				getModele().choisirQuiCommence(messageRecu.getQuiCommence());
			}
		});
		
		installerRecepteurMessage(MsgTransmettreTaille.class, new RecepteurMessageMVC<MsgTransmettreTailleRecu>() {
			@Override
			public void recevoirMessageMVC(MsgTransmettreTailleRecu messageRecu) {
				J.appel(this);
				
				getModele().choisirTailleGrille(messageRecu.getTailleGrille());
			}
		});
	}
}
