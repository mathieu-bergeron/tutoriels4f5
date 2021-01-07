package tp02.client.pages.accueil;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ntro.client.mvc.controleurs.FabriqueControleur;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.Initialisateur;
import tp02.client.pages.accueil.controleurs.ControleurAccueilFX;
import tp02.client.pages.accueil.vues.VueAccueilFX;
import static tp02.client.Constantes.*;

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
		
		ChargeurDeVue<VueAccueilFX> chargeur = new ChargeurDeVue<VueAccueilFX>(CHEMIN_PRINCIPAL_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PRINCIPAL_CSS);

		VueAccueilFX vue = chargeur.getVue();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurAccueilFX.class, vue);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS);

		fenetrePrincipale.setMaxWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMaxHeight(HAUTEUR_PIXELS);

		fenetrePrincipale.show();
	}

}
