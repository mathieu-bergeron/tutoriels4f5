package tp02.client.pages.sauvegardes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ntro.client.mvc.controleurs.FabriqueControleur;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.Initialisateur;
import tp02.client.pages.parametres.controleurs.ControleurParametresFX;
import tp02.client.pages.sauvegardes.afficheurs.AfficheurSauvegardes;
import tp02.client.pages.sauvegardes.afficheurs.AfficheurSauvegardesFX;
import tp02.client.pages.sauvegardes.modeles.Sauvegardes;
import tp02.client.pages.sauvegardes.vues.VueSauvegardesFX;

import static tp02.client.Constantes.*;

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
		
		ChargeurDeVue<VueSauvegardesFX> chargeur = new ChargeurDeVue<VueSauvegardesFX>(CHEMIN_SAUVEGARDES_FXML,
						CHEMIN_CHAINES,
						CHEMIN_SAUVEGARDES_CSS);

		VueSauvegardesFX vue = chargeur.getVue();
		
		Sauvegardes sauvegardes = new Sauvegardes();
		
		AfficheurSauvegardes<VueSauvegardesFX> afficheurSauvegardes = new AfficheurSauvegardesFX();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurParametresFX.class, sauvegardes, vue, afficheurSauvegardes);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS);

		fenetrePrincipale.show();
	}

}
