package demo.client.pages.accueil;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ntro.client.mvc.controleurs.FabriqueControleur;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.Initialisateur;
import demo.client.pages.accueil.controleurs.ControleurAccueil;
import demo.client.pages.accueil.vues.VueAccueil;
import static demo.client.Constantes.*;

public class PageAccueil extends Application {

	static {

		Initialisateur.initialiser();
		
		J.appel(PageAccueil.class);
	}
	
	public static void main(String[] args) {
		J.appel(PageAccueil.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		ChargeurDeVue<VueAccueil> chargeur = new ChargeurDeVue<VueAccueil>(CHEMIN_PRINCIPAL_FXML,
						CHEMIN_PRINCIPAL_CSS,
						CHEMIN_CHAINES);

		VueAccueil vue = chargeur.getVue();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurAccueil.class, vue);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS);

		fenetrePrincipale.setMaxWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMaxHeight(HAUTEUR_PIXELS);

		fenetrePrincipale.show();
	}

}
