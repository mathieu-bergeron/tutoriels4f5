package demo.pages.partie;

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

import demo.pages.partie.afficheurs.AfficheurPartieLocale;
import demo.pages.partie.controleurs.ControleurPartieLocale;
import demo.pages.partie.modeles.PartieLocale;
import demo.pages.partie.vues.VuePartieLocale;

public class PagePartie extends Application {

	static {

		Initialisateur.initialiser();
		
		J.appel(PagePartie.class);
	}
	
	public static void main(String[] args) {
		J.appel(PagePartie.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		ChargeurDeVue<VuePartieLocale> chargeur;
		chargeur = new ChargeurDeVue<VuePartieLocale>(CHEMIN_PARTIE_LOCALE_FXML,
						                              CHEMIN_PARTIE_LOCALE_CSS,
						                              CHEMIN_CHAINES);

		VuePartieLocale vue = chargeur.getVue();
		
		PartieLocale partie = EntrepotDeModeles.creerModele(PartieLocale.class, ID_MODELE_PAR_DEFAUT);
		
		AfficheurPartieLocale afficheur = new AfficheurPartieLocale();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurPartieLocale.class, partie, vue, afficheur);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS);

		fenetrePrincipale.show();
	}
}
