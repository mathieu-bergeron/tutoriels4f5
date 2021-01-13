package demo.pages.parametres;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ntro.client.mvc.controleurs.FabriqueControleur;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.Initialisateur;
import ntro.modeles.EntrepotDeModeles;

import static demo.Constantes.*;

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
		
		ChargeurDeVue<VueParametres> chargeur;
		chargeur = new ChargeurDeVue<VueParametres>(CHEMIN_PARAMETRES_FXML,
						                            CHEMIN_PARAMETRES_CSS,
						                            CHEMIN_CHAINES);

		VueParametres vue = chargeur.getVue();
		
		Parametres parametres = EntrepotDeModeles.creerModele(Parametres.class, ID_MODELE_PAR_DEFAUT);
		
		AfficheurParametres afficheurParametres = new AfficheurParametres();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurParametres.class, parametres, vue, afficheurParametres);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS);

		fenetrePrincipale.show();
	}

}
