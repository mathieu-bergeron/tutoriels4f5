package tp02.client;

import java.net.URI;
import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ntro.client.mvc.controleurs.FabriqueControleur;
import ntro.debogage.DoitEtre;
import ntro.debogage.Erreur;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.DialogueModal;
import ntro.javafx.Initialisateur;
import tp02.client.pages.accueil.controleurs.ControleurAccueil;
import tp02.client.pages.accueil.vues.VueAccueil;

import static tp02.client.Constantes.*;

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
		
		connecterAuServeur();
		
		DialogueModal.enregistreFenetrePrincipale(fenetrePrincipale);
		
		ChargeurDeVue<VueAccueil> chargeur = new ChargeurDeVue<VueAccueil>(CHEMIN_PRINCIPAL_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PRINCIPAL_CSS);

		VueAccueil vue = chargeur.getVue();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurAccueil.class, vue);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS);

		fenetrePrincipale.setMaxWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMaxHeight(HAUTEUR_PIXELS);

		fenetrePrincipale.show();
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
