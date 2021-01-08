package demo.client.pages.accueil.controleurs;

import ntro.debogage.J;
import ntro.systeme.Systeme;
import ntro.client.mvc.controleurs.ControleurVue;
import ntro.client.mvc.controleurs.FabriqueControleur;
import ntro.client.mvc.controleurs.RecepteurCommandeMVC;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.DialogueModal;
import javafx.scene.Scene;
import javafx.stage.Stage;
import demo.client.Main;
import demo.client.commandes.fermer_parametres.FermerParametres;
import demo.client.commandes.fermer_parametres.FermerParametresRecue;
import demo.client.commandes.nouvelle_partie.NouvellePartieLocale;
import demo.client.commandes.nouvelle_partie.NouvellePartieLocaleRecue;
import demo.client.commandes.nouvelle_partie_reseau.NouvellePartieReseau;
import demo.client.commandes.nouvelle_partie_reseau.NouvellePartieReseauRecue;
import demo.client.commandes.ouvrir_parametres.OuvrirParametres;
import demo.client.commandes.ouvrir_parametres.OuvrirParametresRecue;
import demo.client.commandes.quitter.Quitter;
import demo.client.commandes.quitter.QuitterRecue;
import demo.client.pages.accueil.vues.VueAccueil;
import demo.client.pages.partie.afficheurs.AfficheurPartieLocale;
import demo.client.pages.partie.afficheurs.AfficheurPartieReseau;
import demo.client.pages.partie.controleurs.ControleurPartieLocale;
import demo.client.pages.partie.controleurs.ControleurPartieReseau;
import demo.client.pages.partie.modeles.PartieLocale;
import demo.client.pages.partie.modeles.PartieReseau;
import demo.client.pages.partie.vues.VuePartieLocale;
import demo.client.pages.partie.vues.VuePartieReseau;
import static demo.client.Constantes.*;

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
		
		VuePartieLocale vuePartieLocale = getVue().creerVuePartieLocale();
		
		PartieLocale partie = new PartieLocale();
		
		AfficheurPartieLocale afficheur = new AfficheurPartieLocale();
		
		FabriqueControleur.creerControleur(ControleurPartieLocale.class, partie, vuePartieLocale, afficheur);
		
	}

	private void nouvellePartieReseau() {
		J.appel(this);
		
		VuePartieReseau vuePartieReseau = getVue().creerVuePartieReseau();
		
		PartieReseau partie = new PartieReseau();
		
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
