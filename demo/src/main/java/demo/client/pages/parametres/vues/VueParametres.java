package demo.client.pages.parametres.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ntro.client.commandes.FabriqueCommande;
import ntro.client.mvc.Vue;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import demo.client.commandes.choisir_qui_commence.ChoisirQuiCommence;
import demo.client.commandes.choisir_qui_commence.ChoisirQuiCommencePourEnvoi;
import demo.client.commandes.fermer_parametres.FermerParametres;
import demo.client.commandes.fermer_parametres.FermerParametresPourEnvoi;
import demo.client.pages.parametres.modeles.Marque;
import demo.client.pages.parametres.vues.composants.CaseAjustable;
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
	private CaseAjustable caseX, caseO;
	
	@FXML
	private CheckBox checkX, checkO;
	
	@FXML
	private Button boutonOk;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(caseX);
		DoitEtre.nonNul(caseO);
		DoitEtre.nonNul(checkX);
		DoitEtre.nonNul(checkO);
		DoitEtre.nonNul(boutonOk);
		
		caseX.afficherMarque(Marque.X);
		caseO.afficherMarque(Marque.O);
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
		
		checkX.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				choisirQuiCommence.setMarque(Marque.X);
				choisirQuiCommence.envoyerCommande();
			}
		});
		
		checkO.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				choisirQuiCommence.setMarque(Marque.O);
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

	public void afficherQuiCommence(Marque marque) {
		J.appel(this);
		
		switch(marque) {
		
		case X:
			checkX.setSelected(true);
			checkO.setSelected(false);
			break;

		case O:
			checkX.setSelected(false);
			checkO.setSelected(true);
			break;
		
		}
	}
}
