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


package tut07.pages.accueil;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.mvc.Vue;
import tut07.commandes.nouvelle_partie.NouvellePartieLocale;
import tut07.commandes.nouvelle_partie.NouvellePartieLocalePourEnvoi;
import tut07.commandes.ouvrir_parametres.OuvrirParametres;
import tut07.commandes.ouvrir_parametres.OuvrirParametresPourEnvoi;
import tut07.commandes.quitter.Quitter;
import tut07.commandes.quitter.QuitterPourEnvoi;
import tut07.pages.partie.vues.VuePartieLocale;
import tut07.pages.partie.vues.VuePartieReseau;

import static tut07.Constantes.*;

public class VueAccueil implements Vue, Initializable {
	
	@FXML
	private MenuItem menuNouvellePartieLocale, menuNouvellePartieReseau, menuParametres, menuQuitter;
	
	@FXML
	private VBox conteneurPartie;
	
	private NouvellePartieLocalePourEnvoi nouvellePartieLocalePourEnvoi;
	private OuvrirParametresPourEnvoi ouvrirParametresPourEnvoi;
	private QuitterPourEnvoi quitterPourEnvoi;
	
	private String messageAlerteConnexion;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(menuNouvellePartieLocale);
		DoitEtre.nonNul(menuParametres);
		DoitEtre.nonNul(menuQuitter);
		
		messageAlerteConnexion = "Aucune connexion au serveur";
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		nouvellePartieLocalePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(NouvellePartieLocale.class);
		ouvrirParametresPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(OuvrirParametres.class);
		quitterPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(Quitter.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);

		menuNouvellePartieLocale.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				nouvellePartieLocalePourEnvoi.envoyerCommande();
			}
		});

		menuParametres.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				ouvrirParametresPourEnvoi.envoyerCommande();
			}
		});
		
		menuQuitter.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				quitterPourEnvoi.envoyerCommande();
			}
		});
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

	public VuePartieLocale creerVuePartieLocale() {
		J.appel(this);

		ChargeurDeVue<VuePartieLocale> chargeur;
		chargeur = new ChargeurDeVue<VuePartieLocale>(CHEMIN_PARTIE_LOCALE_FXML);

		VuePartieLocale vuePartieLocale = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vuePartieLocale;
	}

	public void alerterErreurConnexion() {
		J.appel(this);

		new Alert(AlertType.ERROR, messageAlerteConnexion).show();
	}

}
