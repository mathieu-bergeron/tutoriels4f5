package demo.client.pages.sauvegardes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ntro.client.mvc.controleurs.FabriqueControleur;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.Initialisateur;
import demo.client.pages.sauvegardes.afficheurs.AfficheurSauvegardes;
import demo.client.pages.sauvegardes.controleurs.ControleurSauvegardes;
import demo.client.pages.sauvegardes.modeles.Sauvegardes;
import demo.client.pages.sauvegardes.vues.VueSauvegardes;

import static demo.client.Constantes.*;

public class PageSauvegardes extends Application {

	static {

		Initialisateur.initialiser();
		
		J.appel(PageSauvegardes.class);
	}
	
	public static void main(String[] args) {
		J.appel(PageSauvegardes.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		ChargeurDeVue<VueSauvegardes> chargeur = new ChargeurDeVue<VueSauvegardes>(CHEMIN_SAUVEGARDES_FXML,
						CHEMIN_SAUVEGARDES_CSS,
						CHEMIN_CHAINES);

		VueSauvegardes vue = chargeur.getVue();
		
		Sauvegardes sauvegardes = new Sauvegardes();
		
		AfficheurSauvegardes afficheurSauvegardes = new AfficheurSauvegardes();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurSauvegardes.class, sauvegardes, vue, afficheurSauvegardes);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS);

		fenetrePrincipale.show();
	}

}
