package demo.client;

import java.net.URI;
import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import ntro.client.mvc.controleurs.FabriqueControleur;
import ntro.debogage.DoitEtre;
import ntro.debogage.Erreur;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.DialogueModal;
import ntro.javafx.Initialisateur;
import demo.client.pages.accueil.controleurs.ControleurAccueil;
import demo.client.pages.accueil.vues.VueAccueil;

import static demo.client.Constantes.*;

public class Main extends Application {
	
	static {

		Initialisateur.initialiser();
		
		J.appel(Main.class);
	}
	
	private static ClientQuatreDeSuite client;
	
	public static void main(String[] args) {
		J.appel(Main.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		calculerAjustementPixels();
		
		J.valeurs(AJUSTEMENT_TAILLE_PIXELS);

		connecterAuServeur();
		
		DialogueModal.enregistreFenetrePrincipale(fenetrePrincipale);
		
		ChargeurDeVue<VueAccueil> chargeur = new ChargeurDeVue<VueAccueil>(CHEMIN_PRINCIPAL_FXML,
						CHEMIN_PRINCIPAL_CSS,
						CHEMIN_CHAINES);

		VueAccueil vue = chargeur.getVue();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurAccueil.class, vue);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS * AJUSTEMENT_TAILLE_PIXELS,
				                             HAUTEUR_PIXELS * AJUSTEMENT_TAILLE_PIXELS);

		ajusterTaillePolice(scene);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS_MIN * AJUSTEMENT_TAILLE_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS_MIN * AJUSTEMENT_TAILLE_PIXELS);

		fenetrePrincipale.setWidth(LARGEUR_PIXELS * AJUSTEMENT_TAILLE_PIXELS);
		fenetrePrincipale.setHeight(HAUTEUR_PIXELS * AJUSTEMENT_TAILLE_PIXELS);

		fenetrePrincipale.show();
	}
	
	private void calculerAjustementPixels() {

		double largeurEcran = Screen.getPrimary().getVisualBounds().getWidth();
		double hauteurEcran = Screen.getPrimary().getVisualBounds().getHeight();
		double tailleEcran = Math.max(largeurEcran, hauteurEcran);
		
		AJUSTEMENT_TAILLE_PIXELS = tailleEcran / 1920.0;
	}

	private void ajusterTaillePolice(Scene scene) {
		J.appel(this);
		
		int taillePolice = (int) Math.ceil(TAILLE_POLICE * AJUSTEMENT_TAILLE_PIXELS);
		
		if(taillePolice < TAILLE_POLICE_MIN) {

			taillePolice = TAILLE_POLICE_MIN;

		}else if(taillePolice > TAILLE_POLICE_MAX) {

			taillePolice = TAILLE_POLICE_MAX;
		}
		
		
		String cssTaillePolice = String.format("-fx-font-size: %dpx;", taillePolice);
		
		scene.getRoot().setStyle(cssTaillePolice);
	}

	private void connecterAuServeur() {
		J.appel(this);

		URI uriServeur = null;
		
		try {

			uriServeur = new URI(ADRESSE_SERVEUR);

		} catch (URISyntaxException e) {
			
			Erreur.fatale("L'adresse du serveur est mal formée: " + ADRESSE_SERVEUR, e);
		}

		connecterAuServeur(uriServeur);
	}

	private void connecterAuServeur(URI uriServeur) {
		J.appel(this);

		client = new ClientQuatreDeSuite(uriServeur);
		
		Erreur.avertissement("Tentative de connexion au serveur... ");
		
		try {

			client.connectBlocking();

		} catch (InterruptedException e) {
			
			Erreur.nonFatale("Tentative de connexion annulée", e);
		}
	}
	
	public static boolean siConnecteAuServeur() {
		J.appel(Main.class);
		
		return client != null && client.isOpen();
	}
	

}
