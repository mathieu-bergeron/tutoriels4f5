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


package tut07.client;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.DialogueModal;
import ntro.javafx.Initialisateur;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.systeme.Systeme;
import tut07.pages.accueil.ControleurAccueil;
import tut07.pages.accueil.VueAccueil;

import static tut07.Constantes.*;

public class MonClient extends Application {
	
	static {
		Initialisateur.initialiser();
		J.appel(MonClient.class);
	}
	
	public static void main(String[] args) {
		J.appel(MonClient.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);

		DialogueModal.enregistreFenetrePrincipale(fenetrePrincipale);
		
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
		chargeur = new ChargeurDeVue<VueAccueil>(CHEMIN_PRINCIPAL_FXML);

		VueAccueil vue = chargeur.getVue();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurAccueil.class, vue);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS );
		return scene;
	}

	private void ajusterTailles(Stage fenetrePrincipale, Scene scene) {
		J.appel(this);

		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS_MIN);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS_MIN);

		fenetrePrincipale.setWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setHeight(HAUTEUR_PIXELS);
	}
}
