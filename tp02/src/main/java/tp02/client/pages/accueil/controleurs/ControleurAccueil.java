package tp02.client.pages.accueil.controleurs;

import ntro.debogage.J;
import ntro.systeme.Systeme;
import ntro.client.mvc.controleurs.ControleurVue;
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
import tp02.client.pages.accueil.vues.VueAccueil;
import tp02.client.pages.partie.afficheurs.AfficheurPartieLocale;
import tp02.client.pages.partie.afficheurs.AfficheurPartieReseau;
import tp02.client.pages.partie.controleurs.ControleurPartieLocale;
import tp02.client.pages.partie.controleurs.ControleurPartieReseau;
import tp02.client.pages.partie.modeles.PartieLocale;
import tp02.client.pages.partie.modeles.PartieReseau;
import tp02.client.pages.partie.vues.VuePartieLocale;
import tp02.client.pages.partie.vues.VuePartieReseau;
import static tp02.client.Constantes.*;

@SuppressWarnings("rawtypes")
public class ControleurAccueil extends ControleurVue<VueAccueil> {

	private Scene sceneParametres;
	private Stage dialogueParametres;
	
	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
	}
	

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
		
		VuePartieLocale vuePartieLocale = vue.creerVuePartieLocale();
		
		PartieLocale partie = new PartieLocale();
		partie.initialiser();
		
		AfficheurPartieLocale afficheur = new AfficheurPartieLocale();
		
		FabriqueControleur.creerControleur(ControleurPartieLocale.class, partie, vuePartieLocale, afficheur);
		
	}

	private void nouvellePartieReseau() {
		J.appel(this);
		
		VuePartieReseau vuePartieReseau = vue.creerVuePartieReseau();
		
		PartieReseau partie = new PartieReseau();
		partie.initialiser();
		
		AfficheurPartieReseau afficheur = new AfficheurPartieReseau();
		
		FabriqueControleur.creerControleur(ControleurPartieReseau.class, partie, vuePartieReseau, afficheur);
		
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
