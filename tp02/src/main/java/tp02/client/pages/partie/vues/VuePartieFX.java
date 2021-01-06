package tp02.client.pages.partie.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ntro.debogage.J;
import tp02.client.Couleur;
import tp02.client.pages.vues.composants.ConteneurEntetes;
import tp02.client.pages.vues.composants.ConteneurGrille;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public abstract class VuePartieFX implements VuePartie, Initializable {

    @FXML
    private Text nomJoueurUn, nomJoueurDeux;
    
    @FXML
    private ConteneurEntetes conteneurEntetes;

    @FXML
    private ConteneurGrille conteneurGrille;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
	} 

    @Override
    public void creerGrille(int largeur, int hauteur) {
        J.appel(this);
        
        conteneurEntetes.creerEntetes(largeur);
        
        conteneurGrille.creerGrille(largeur, hauteur);

    }

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		conteneurEntetes.obtenirJouerIciPourEnvoi();
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		conteneurEntetes.installerCapteursJouerIci();
	}

	@Override
	public void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur) {
		J.appel(this);
		
		conteneurGrille.afficherJeton(indiceColonne, indiceRangee, couleur);
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
		
	}
}
