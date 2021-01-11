package demo.client;

public class Constantes {
	
	public static final String ID_MODELE_PAR_DEFAUT = "defaut";

	public static final int HAUTEUR_GRILLE_PAR_DEFAUT = 5;
	public static final int LARGEUR_GRILLE_PAR_DEFAUT = 6;
	
	public static final String CHEMIN_CHAINES = "traductions.chaines";

	public static final String CHEMIN_PRINCIPAL_FXML = "/accueil/structure.xml";
	public static final String CHEMIN_PRINCIPAL_CSS = "/accueil/style.css";

	public static final String CHEMIN_PARAMETRES_FXML = "/parametres/structure.xml";
	public static final String CHEMIN_PARAMETRES_CSS = "/parametres/style.css";

	public static final String CHEMIN_PARTIE_LOCALE_FXML = "/partie/locale/structure.xml";
	public static final String CHEMIN_PARTIE_LOCALE_CSS = "/partie/locale/style.css";

	public static final String CHEMIN_PARTIE_RESEAU_FXML = "/partie/reseau/structure.xml";
	public static final String CHEMIN_PARTIE_RESEAU_CSS = "/partie/reseau/style.css";

	public static final String CHEMIN_SAUVEGARDES_FXML = "/sauvegardes/structure.xml";
	public static final String CHEMIN_SAUVEGARDES_CSS = "/sauvegardes/style.css";

	public static final int TAILLE_POLICE = 15;
	public static final int TAILLE_POLICE_MIN = 11;
	public static final int TAILLE_POLICE_MAX = 18;

	public static final int LARGEUR_PIXELS_MIN = 400;
	public static final int HAUTEUR_PIXELS_MIN = 600;

	public static final int LARGEUR_PIXELS = 600;
	public static final int HAUTEUR_PIXELS= 800;

	public static final int LARGEUR_PARAMETRES_PIXELS_MIN = 375;
	public static final int HAUTEUR_PARAMETRES_PIXELS_MIN = 500;

	public static final int LARGEUR_PARAMETRES_PIXELS = 375;
	public static final int HAUTEUR_PARAMETRES_PIXELS = 500;

	public static final int LARGEUR_PARAMETRES_PIXELS_MAX = 500;
	public static final int HAUTEUR_PARAMETRES_PIXELS_MAX = 665;
	
	public static final int PORT = 8765;
	public static final String ADRESSE_SERVEUR = String.format("ws://localhost:%s", PORT);
	
	public static double AJUSTEMENT_TAILLE_PIXELS = 1.0;

}
