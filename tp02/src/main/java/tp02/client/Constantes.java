package tp02.client;

public class Constantes {

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

	public static final int LARGEUR_PIXELS = 340;
	public static final int HAUTEUR_PIXELS = 500;
	
	public static final int PORT = 8765;
	public static final String ADRESSE_SERVEUR = String.format("ws://localhost:%s", PORT);

}
