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


package demo.pages.accueil;

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
import demo.commandes.nouvelle_partie.NouvellePartieLocale;
import demo.commandes.nouvelle_partie.NouvellePartieLocalePourEnvoi;
import demo.commandes.nouvelle_partie_reseau.NouvellePartieReseau;
import demo.commandes.nouvelle_partie_reseau.NouvellePartieReseauPourEnvoi;
import demo.commandes.ouvrir_parametres.OuvrirParametres;
import demo.commandes.ouvrir_parametres.OuvrirParametresPourEnvoi;
import demo.commandes.quitter.Quitter;
import demo.commandes.quitter.QuitterPourEnvoi;
import demo.pages.partie.vues.VuePartieLocale;
import demo.pages.partie.vues.VuePartieReseau;

import static demo.Constantes.*;

public class VueAccueil implements Vue, Initializable {
	
	@FXML
	private MenuItem menuNouvellePartieLocale, menuNouvellePartieReseau, menuParametres, menuQuitter;
	
	@FXML
	private VBox conteneurPartie;
	
	private NouvellePartieLocalePourEnvoi nouvellePartieLocalePourEnvoi;
	private NouvellePartieReseauPourEnvoi nouvellePartieReseauPourEnvoi;
	private OuvrirParametresPourEnvoi ouvrirParametresPourEnvoi;
	private QuitterPourEnvoi quitterPourEnvoi;
	
	private String messageAlerteConnexion;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(menuNouvellePartieLocale);
		DoitEtre.nonNul(menuNouvellePartieReseau);
		DoitEtre.nonNul(menuParametres);
		DoitEtre.nonNul(menuQuitter);
		
		messageAlerteConnexion = resources.getString("messageAlerteConnexion");
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		nouvellePartieLocalePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(NouvellePartieLocale.class);
		nouvellePartieReseauPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(NouvellePartieReseau.class);
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

		menuNouvellePartieReseau.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				nouvellePartieReseauPourEnvoi.envoyerCommande();
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
		chargeur = new ChargeurDeVue<VuePartieLocale>(CHEMIN_PARTIE_LOCALE_FXML,
						                              CHEMIN_PARTIE_LOCALE_CSS,
						                              CHEMIN_CHAINES);

		VuePartieLocale vuePartieLocale = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vuePartieLocale;
	}

	public VuePartieReseau creerVuePartieReseau() {
		J.appel(this);

		ChargeurDeVue<VuePartieReseau> chargeur;
		chargeur = new ChargeurDeVue<VuePartieReseau>(CHEMIN_PARTIE_RESEAU_FXML,
				                              		  CHEMIN_PARTIE_RESEAU_CSS,
						                              CHEMIN_CHAINES);
		
		VuePartieReseau vuePartieReseau = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vuePartieReseau;
	}

	public void alerterErreurConnexion() {
		J.appel(this);

		new Alert(AlertType.ERROR, messageAlerteConnexion).show();
	}

}