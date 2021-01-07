package tp02.client.pages.accueil.controleurs;

import ntro.debogage.J;
import ntro.systeme.Systeme;
import ntro.client.mvc.controleurs.FabriqueControleur;
import ntro.client.mvc.controleurs.RecepteurCommandeMVC;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.DialogueModal;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tp02.client.Main;
import tp02.client.commandes.fermer_parametres.FermerParametres;
import tp02.client.commandes.fermer_parametres.FermerParametresRecue;
import tp02.client.commandes.nouvelle_partie.NouvellePartieLocale;
import tp02.client.commandes.nouvelle_partie.NouvellePartieLocaleRecue;
import tp02.client.commandes.nouvelle_partie_reseau.NouvellePartieReseau;
import tp02.client.commandes.nouvelle_partie_reseau.NouvellePartieReseauRecue;
import tp02.client.commandes.ouvrir_parametres.OuvrirParametres;
import tp02.client.commandes.ouvrir_parametres.OuvrirParametresRecue;
import tp02.client.commandes.quitter.Quitter;
import tp02.client.commandes.quitter.QuitterRecue;
import tp02.client.pages.accueil.vues.VueAccueilFX;
import tp02.client.pages.partie.afficheurs.AfficheurPartieLocaleFX;
import tp02.client.pages.partie.afficheurs.AfficheurPartieReseauFX;
import tp02.client.pages.partie.controleurs.ControleurPartieLocaleFX;
import tp02.client.pages.partie.controleurs.ControleurPartieReseauFX;
import tp02.client.pages.partie.modeles.PartieLocale;
import tp02.client.pages.partie.modeles.PartieReseau;
import tp02.client.pages.partie.vues.VuePartieLocaleFX;
import tp02.client.pages.partie.vues.VuePartieReseauFX;
import static tp02.client.Constantes.*;

@SuppressWarnings("rawtypes")
public class ControleurAccueilFX extends ControleurAccueil<VueAccueilFX> {

	private Scene sceneParametres;
	private Stage dialogueParametres;

	@Override
	protected void demarrer() {
		J.appel(this);
		
		if(Main.siConnecteAuServeur()) {
			
			nouvellePartieReseau();

		}else {

			nouvellePartieLocale();
		}
		
		ChargeurDeVue chargeur = new ChargeurDeVue(CHEMIN_PARAMETRES_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARAMETRES_CSS);
		
		sceneParametres = chargeur.nouvelleScene(400, 300);
		
	}


	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);

		installerRecepteurCommande(NouvellePartieLocale.class, new RecepteurCommandeMVC<NouvellePartieLocaleRecue>() {
			@Override
			public void executerCommandeMVC(NouvellePartieLocaleRecue commande) {
				J.appel(this);
				
				nouvellePartieLocale();
			}
		});

		installerRecepteurCommande(NouvellePartieReseau.class, new RecepteurCommandeMVC<NouvellePartieReseauRecue>() {
			@Override
			public void executerCommandeMVC(NouvellePartieReseauRecue commande) {
				J.appel(this);
				
				nouvellePartieReseau();
			}
		});

		installerRecepteurCommande(OuvrirParametres.class, new RecepteurCommandeMVC<OuvrirParametresRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirParametresRecue commande) {
				J.appel(this);
				
				ouvrirParametres();
			}
		});

		installerRecepteurCommande(FermerParametres.class, new RecepteurCommandeMVC<FermerParametresRecue>() {
			@Override
			public void executerCommandeMVC(FermerParametresRecue commande) {
				J.appel(this);
				
				fermerParametres();
			}
		});

		installerRecepteurCommande(Quitter.class, new RecepteurCommandeMVC<QuitterRecue>() {
			@Override
			public void executerCommandeMVC(QuitterRecue commande) {
				J.appel(this);
				
				Systeme.quitter();
			}
		});
	}
	
	private void nouvellePartieLocale() {
		J.appel(this);
		
		VuePartieLocaleFX vuePartieLocale = vue.creerVuePartieLocale();
		
		PartieLocale partie = new PartieLocale();
		
		AfficheurPartieLocaleFX afficheur = new AfficheurPartieLocaleFX();
		
		FabriqueControleur.creerControleur(ControleurPartieLocaleFX.class, partie, vuePartieLocale, afficheur);
		
	}

	private void nouvellePartieReseau() {
		J.appel(this);
		
		VuePartieReseauFX vuePartieReseau = vue.creerVuePartieReseau();
		
		PartieReseau partie = new PartieReseau();
		
		AfficheurPartieReseauFX afficheur = new AfficheurPartieReseauFX();
		
		FabriqueControleur.creerControleur(ControleurPartieReseauFX.class, partie, vuePartieReseau, afficheur);
		
	}
	
	private void ouvrirParametres() {
		J.appel(this);
		
		dialogueParametres = DialogueModal.ouvrirDialogueModal(sceneParametres);
	}

	private void fermerParametres() {
		J.appel(this);
		
		if(dialogueParametres != null) {
			
			dialogueParametres.close();
		}
	}
}
