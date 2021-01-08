package demo.client.pages.sauvegardes.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ntro.client.mvc.Vue;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import demo.client.pages.sauvegardes.modeles.UneSauvegardeLectureSeule;
import demo.client.pages.sauvegardes.vues.composants.ConteneurSauvegardes;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class VueSauvegardes implements Vue, Initializable {
	
	@FXML
	private Text texteRechercheEnCours;
	
	private Timeline animationRechercheEnCours;
	
	@FXML
	private ConteneurSauvegardes conteneurSauvegardes;
	
	private String texteBoutonOuvrir;
	private String texteSauvegardes;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(texteRechercheEnCours);
		DoitEtre.nonNul(conteneurSauvegardes);
		
		texteBoutonOuvrir = resources.getString("ouvrirSauvegarde");
		texteSauvegardes = resources.getString("lesSauvegardes");
		
		creerAnimationRechercheEnCours();
		animationRechercheEnCours.play();
	}
	
	private void creerAnimationRechercheEnCours() {
		J.appel(this);
		
		animationRechercheEnCours = new Timeline();
		
		String texteTotal = texteRechercheEnCours.getText();
		
		int delaiParCaractereMilisecondes = 200;
		
		animationRechercheEnCours.getKeyFrames()
		                         .add(new KeyFrame(Duration.ZERO, 
		                        		           new KeyValue(texteRechercheEnCours.textProperty(), 
		                        		        		        texteTotal)));

		String suspension = "";

		for(int i = 0; i < 10; i++) {
			
			suspension += ".";

			animationRechercheEnCours.getKeyFrames()
									 .add(new KeyFrame(new Duration(i*delaiParCaractereMilisecondes), 
													   new KeyValue(texteRechercheEnCours.textProperty(), 
																	texteTotal + suspension)));
		}
		
		animationRechercheEnCours.setCycleCount(-1);
	}
	

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
		
	}

	public void viderLesSauvegardes() {
		J.appel(this);
		
		conteneurSauvegardes.viderLesSauvegardes();
	}

	public void ajouterSauvegarde(UneSauvegardeLectureSeule uneSauvegarde) {
		J.appel(this);

		conteneurSauvegardes.ajouterSauvegarde(uneSauvegarde, texteBoutonOuvrir);
	}

	public void cacherRechercheEnCours() {
		J.appel(this);

		animationRechercheEnCours.stop();
		texteRechercheEnCours.setText(texteSauvegardes);
	}
}
