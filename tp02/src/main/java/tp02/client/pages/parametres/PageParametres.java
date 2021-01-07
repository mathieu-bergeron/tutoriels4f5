package tp02.client.pages.parametres;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ntro.client.mvc.controleurs.FabriqueControleur;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.Initialisateur;
import tp02.client.pages.parametres.afficheurs.AfficheurParametres;
import tp02.client.pages.parametres.afficheurs.AfficheurParametresFX;
import tp02.client.pages.parametres.controleurs.ControleurParametresFX;
import tp02.client.pages.parametres.modeles.Parametres;
import tp02.client.pages.parametres.vues.VueParametresFX;

import static tp02.client.Constantes.*;

public class PageParametres extends Application {

	static {

		Initialisateur.initialiser();
		
		J.appel(PageParametres.class);
	}
	
	public static void main(String[] args) {
		J.appel(PageParametres.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		ChargeurDeVue<VueParametresFX> chargeur = new ChargeurDeVue<VueParametresFX>(CHEMIN_PARAMETRES_FXML,
						CHEMIN_CHAINES,
						CHEMIN_PARAMETRES_CSS);

		VueParametresFX vue = chargeur.getVue();
		
		Parametres parametres = new Parametres();
		
		AfficheurParametres<VueParametresFX> afficheurParametres = new AfficheurParametresFX();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurParametresFX.class, parametres, vue, afficheurParametres);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS);

		fenetrePrincipale.show();
	}

}
