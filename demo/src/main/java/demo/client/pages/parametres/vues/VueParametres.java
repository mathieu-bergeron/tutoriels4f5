package demo.client.pages.parametres.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ntro.client.commandes.FabriqueCommande;
import ntro.client.mvc.Vue;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import demo.client.Couleur;
import demo.client.commandes.choisir_qui_commence.ChoisirQuiCommence;
import demo.client.commandes.choisir_qui_commence.ChoisirQuiCommencePourEnvoi;
import demo.client.commandes.fermer_parametres.FermerParametres;
import demo.client.commandes.fermer_parametres.FermerParametresPourEnvoi;
import demo.client.pages.commun.composants.CaseAjustable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class VueParametres implements Vue, Initializable {
	
	private FermerParametresPourEnvoi fermerParametres;
	private ChoisirQuiCommencePourEnvoi choisirQuiCommence;

	@FXML 
	private CaseAjustable caseRouge, caseJaune;
	
	@FXML
	private CheckBox checkRouge, checkJaune;
	
	@FXML
	private Button boutonOk;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(caseRouge);
		DoitEtre.nonNul(caseJaune);
		DoitEtre.nonNul(checkRouge);
		DoitEtre.nonNul(checkJaune);
		DoitEtre.nonNul(boutonOk);
		
		caseRouge.afficherJeton(Couleur.ROUGE);
		caseJaune.afficherJeton(Couleur.JAUNE);
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		fermerParametres = FabriqueCommande.obtenirCommandePourEnvoi(FermerParametres.class);
		choisirQuiCommence = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirQuiCommence.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		checkRouge.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				choisirQuiCommence.setCouleur(Couleur.ROUGE);
				choisirQuiCommence.envoyerCommande();
			}
		});
		
		checkJaune.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				choisirQuiCommence.setCouleur(Couleur.JAUNE);
				choisirQuiCommence.envoyerCommande();
			}
		});

		boutonOk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				fermerParametres.envoyerCommande();
			}
		});
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

	public void afficherQuiCommence(Couleur couleur) {
		J.appel(this);
		
		switch(couleur) {
		
		case ROUGE:
			checkRouge.setSelected(true);
			checkJaune.setSelected(false);
			break;

		case JAUNE:
			checkRouge.setSelected(false);
			checkJaune.setSelected(true);
			break;
		
		}
	}
}
