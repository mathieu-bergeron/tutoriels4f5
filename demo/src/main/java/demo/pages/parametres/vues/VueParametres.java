package demo.pages.parametres.vues;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import ntro.client.commandes.FabriqueCommande;
import ntro.client.mvc.Vue;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import demo.commandes.choisir_qui_commence.ChoisirQuiCommence;
import demo.commandes.choisir_qui_commence.ChoisirQuiCommencePourEnvoi;
import demo.commandes.choisir_taille_grille.ChoisirTailleGrillePourEnvoi;
import demo.commandes.choisir_taille_grille.ChoisirTailleGrille;
import demo.commandes.fermer_parametres.FermerParametres;
import demo.commandes.fermer_parametres.FermerParametresPourEnvoi;
import demo.pages.commun.composants.CaseAjustable;
import demo.pages.commun.enumerations.Couleur;
import demo.pages.commun.enumerations.TailleGrille;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class VueParametres implements Vue, Initializable {
	
	private FermerParametresPourEnvoi fermerParametres;
	private ChoisirQuiCommencePourEnvoi choisirQuiCommence;
	private ChoisirTailleGrillePourEnvoi choisirTailleGrille;

	@FXML 
	private CaseAjustable caseRouge, caseJaune;
	
	@FXML
	private CheckBox checkRouge, checkJaune;
	
	@FXML
	private Button boutonOk;

	@FXML
	private ComboBox<String> choixTaille;
	
	// FIXME: utiliser un BiMap plutôt?
	private Map<String, TailleGrille> tailleSelonNom = new HashMap<>();
	private Map<TailleGrille, String> nomSelonTaille = new HashMap<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(caseRouge);
		DoitEtre.nonNul(caseJaune);
		DoitEtre.nonNul(checkRouge);
		DoitEtre.nonNul(checkJaune);
		DoitEtre.nonNul(boutonOk);
		DoitEtre.nonNul(choixTaille);

		caseRouge.afficherJeton(Couleur.ROUGE);
		caseJaune.afficherJeton(Couleur.JAUNE);
		
		// TODO
		for(TailleGrille tailleGrille : TailleGrille.values()) {
			
			String nomTaille = resources.getString(tailleGrille.name());
			
			choixTaille.getItems().add(nomTaille);
			
			tailleSelonNom.put(nomTaille, tailleGrille);
			nomSelonTaille.put(tailleGrille, nomTaille);
		}

		choixTaille.getSelectionModel().clearAndSelect(0);
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		fermerParametres = FabriqueCommande.obtenirCommandePourEnvoi(FermerParametres.class);
		choisirQuiCommence = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirQuiCommence.class);
		choisirTailleGrille = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirTailleGrille.class);
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

		choixTaille.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				String nomTailleChoisie = choixTaille.getSelectionModel().getSelectedItem();
				
				TailleGrille tailleChoisie = tailleSelonNom.get(nomTailleChoisie);
				
				choisirTailleGrille.setTailleGrille(tailleChoisie);
				choisirTailleGrille.envoyerCommande();
			}
		});
		
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

	public void afficherQuiCommence(Couleur couleur) {
		J.appel(this);
		
		DoitEtre.nonNul(couleur);

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

	public void afficherTailleGrille(TailleGrille tailleGrille) {
		J.appel(this);
		
		String nomTaille = nomSelonTaille.get(tailleGrille);
		
		int indiceTaille = choixTaille.getItems().indexOf(nomTaille);
		
		if(indiceTaille != -1) {
			choixTaille.getSelectionModel().clearAndSelect(indiceTaille);
		}
	}
}
