package tp02.client.pages.accueil.vues;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import ntro.client.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import tp02.client.commandes.nouvelle_partie.NouvellePartieLocale;
import tp02.client.commandes.nouvelle_partie.NouvellePartieLocalePourEnvoi;
import tp02.client.commandes.nouvelle_partie_reseau.NouvellePartieReseau;
import tp02.client.commandes.nouvelle_partie_reseau.NouvellePartieReseauPourEnvoi;
import tp02.client.commandes.ouvrir_parametres.OuvrirParametres;
import tp02.client.commandes.ouvrir_parametres.OuvrirParametresPourEnvoi;
import tp02.client.commandes.quitter.Quitter;
import tp02.client.commandes.quitter.QuitterPourEnvoi;
import tp02.client.pages.partie.vues.VuePartieLocaleFX;
import tp02.client.pages.partie.vues.VuePartieReseauFX;

import static tp02.client.Constantes.*;

public class VueAccueilFX implements VueAccueil, Initializable {
	
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


	public VuePartieLocaleFX creerVuePartieLocale() {
		J.appel(this);

		ChargeurDeVue<VuePartieLocaleFX> chargeur = new ChargeurDeVue<VuePartieLocaleFX>(CHEMIN_PARTIE_LOCALE_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARTIE_LOCALE_CSS);
		
		VuePartieLocaleFX vuePartieLocale = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vuePartieLocale;
	}

	public VuePartieReseauFX creerVuePartieReseau() {
		J.appel(this);

		ChargeurDeVue<VuePartieReseauFX> chargeur = new ChargeurDeVue<VuePartieReseauFX>(CHEMIN_PARTIE_RESEAU_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARTIE_RESEAU_CSS);
		
		VuePartieReseauFX vuePartieReseau = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vuePartieReseau;
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);

	}


}
