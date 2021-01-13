// Copyright (C) (2020) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)
//
// This file is part of tutoriels4f5
//
// tutoriels4f5 is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// tutoriels4f5 is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
//
// You should have received a copy of the GNU Affero General Public License
// along with aquiletour.  If not, see <https://www.gnu.org/licenses/>


package tut10.client;

import java.net.URI;
import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ntro.debogage.DoitEtre;
import ntro.debogage.Erreur;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.DialogueModal;
import ntro.javafx.Initialisateur;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.systeme.Systeme;
import tut10.pages.accueil.ControleurAccueil;
import tut10.pages.accueil.VueAccueil;

import static tut10.Constantes.*;

public class MonClient extends Application {
	
	static {
		Initialisateur.initialiser();
		J.appel(MonClient.class);
	}
	
	private static MonClientWebSocket clientWebSocket;
	
	public static void main(String[] args) {
		J.appel(MonClient.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);

		DialogueModal.enregistreFenetrePrincipale(fenetrePrincipale);

		connecterAuServeur();
		
		calculerAjustementPixels();
		
		Scene scene = instancierControleurAccueil();

		fenetrePrincipale.setScene(scene);

		ajusterTailles(fenetrePrincipale, scene);
		
		capterEvenementFermeture(fenetrePrincipale);

		fenetrePrincipale.show();
	}

	private void capterEvenementFermeture(Stage fenetrePrincipale) {
		J.appel(this);

		fenetrePrincipale.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				J.appel(this);

				Systeme.quitter();
			}
		});
	}

	private Scene instancierControleurAccueil() {
		J.appel(this);

		ChargeurDeVue<VueAccueil> chargeur;
		chargeur = new ChargeurDeVue<VueAccueil>(CHEMIN_PRINCIPAL_FXML,
						                         CHEMIN_PRINCIPAL_CSS,
						                         CHEMIN_CHAINES);

		VueAccueil vue = chargeur.getVue();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurAccueil.class, vue);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS * AJUSTEMENT_TAILLE_PIXELS,
				                             HAUTEUR_PIXELS * AJUSTEMENT_TAILLE_PIXELS);
		return scene;
	}

	private void ajusterTailles(Stage fenetrePrincipale, Scene scene) {
		J.appel(this);

		ajusterTaillePolice(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS_MIN * AJUSTEMENT_TAILLE_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS_MIN * AJUSTEMENT_TAILLE_PIXELS);

		fenetrePrincipale.setWidth(LARGEUR_PIXELS * AJUSTEMENT_TAILLE_PIXELS);
		fenetrePrincipale.setHeight(HAUTEUR_PIXELS * AJUSTEMENT_TAILLE_PIXELS);
	}

	
	private void calculerAjustementPixels() {
		J.appel(this);

		double largeurEcran = Screen.getPrimary().getVisualBounds().getWidth();
		double hauteurEcran = Screen.getPrimary().getVisualBounds().getHeight();
		double tailleEcran = Math.max(largeurEcran, hauteurEcran);
		
		AJUSTEMENT_TAILLE_PIXELS = 1.2 * tailleEcran / 1920.0;
	}

	private void ajusterTaillePolice(Scene scene) {
		J.appel(this);
		
		int taillePolice = calculerTaillePolice();
		
		String cssTaillePolice = String.format("-fx-font-size: %dpx;", taillePolice);
		
		scene.getRoot().setStyle(cssTaillePolice);
	}

	private int calculerTaillePolice() {
		J.appel(this);

		int taillePolice = (int) Math.ceil(TAILLE_POLICE * AJUSTEMENT_TAILLE_PIXELS);
		
		if(taillePolice < TAILLE_POLICE_MIN) {

			taillePolice = TAILLE_POLICE_MIN;

		}else if(taillePolice > TAILLE_POLICE_MAX) {

			taillePolice = TAILLE_POLICE_MAX;
		}

		return taillePolice;
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

		clientWebSocket = new MonClientWebSocket(uriServeur);
		
		Erreur.avertissement("Tentative de connexion au serveur... ");
		
		try {

			clientWebSocket.connectBlocking();

		} catch (InterruptedException e) {
			
			Erreur.nonFatale("Tentative de connexion annulée", e);
		}
	}
	
	public static boolean siConnecteAuServeur() {
		J.appel(MonClient.class);
		
		return clientWebSocket != null && clientWebSocket.isOpen();
	}

}
