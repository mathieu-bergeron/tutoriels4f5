package demo.client.pages.accueil.vues;

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
import ntro.client.commandes.FabriqueCommande;
import ntro.client.mvc.Vue;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import demo.client.commandes.nouvelle_partie.NouvellePartieLocale;
import demo.client.commandes.nouvelle_partie.NouvellePartieLocalePourEnvoi;
import demo.client.commandes.nouvelle_partie_reseau.NouvellePartieReseau;
import demo.client.commandes.nouvelle_partie_reseau.NouvellePartieReseauPourEnvoi;
import demo.client.commandes.ouvrir_parametres.OuvrirParametres;
import demo.client.commandes.ouvrir_parametres.OuvrirParametresPourEnvoi;
import demo.client.commandes.quitter.Quitter;
import demo.client.commandes.quitter.QuitterPourEnvoi;
import demo.client.pages.partie.vues.VuePartieLocale;
import demo.client.pages.partie.vues.VuePartieReseau;

import static demo.client.Constantes.*;

public class VueAccueil implements Vue, Initializable {
	
	@FXML
	MenuItem menuNouvellePartieLocale, menuNouvellePartieReseau, menuParametres, menuQuitter;
	
	@FXML
	VBox conteneurPartie;
	
	NouvellePartieLocalePourEnvoi nouvellePartieLocalePourEnvoi;
	NouvellePartieReseauPourEnvoi nouvellePartieReseauPourEnvoi;
	OuvrirParametresPourEnvoi ouvrirParametresPourEnvoi;
	QuitterPourEnvoi quitterPourEnvoi;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(menuNouvellePartieLocale);
		DoitEtre.nonNul(menuNouvellePartieReseau);
		DoitEtre.nonNul(menuParametres);
		DoitEtre.nonNul(menuQuitter);
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


	public VuePartieLocale creerVuePartieLocale() {
		J.appel(this);

		ChargeurDeVue<VuePartieLocale> chargeur = new ChargeurDeVue<VuePartieLocale>(CHEMIN_PARTIE_LOCALE_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARTIE_LOCALE_CSS);
		
		VuePartieLocale vuePartieLocale = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vuePartieLocale;
	}

	public VuePartieReseau creerVuePartieReseau() {
		J.appel(this);

		ChargeurDeVue<VuePartieReseau> chargeur = new ChargeurDeVue<VuePartieReseau>(CHEMIN_PARTIE_RESEAU_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARTIE_RESEAU_CSS);
		
		VuePartieReseau vuePartieReseau = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vuePartieReseau;
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);

	}

	public void alerterErreurConnexion() {
		J.appel(this);

		new Alert(AlertType.ERROR, "Aucune connexion au serveur").show();
	}


}
