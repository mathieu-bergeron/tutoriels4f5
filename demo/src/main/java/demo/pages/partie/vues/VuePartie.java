package demo.pages.partie.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ntro.client.mvc.Vue;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import demo.enumerations.Couleur;
import demo.pages.partie.composants.ConteneurEntetes;
import demo.pages.partie.composants.ConteneurGrille;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public abstract class VuePartie implements Vue, Initializable {

    @FXML
    private ConteneurEntetes conteneurEntetes;

    @FXML
    private ConteneurGrille conteneurGrille;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(conteneurEntetes);
		DoitEtre.nonNul(conteneurGrille);
	} 

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

	public void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur) {
		J.appel(this);
		
		conteneurGrille.afficherJeton(indiceColonne, indiceRangee, couleur);
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);

		conteneurEntetes.verifierCommandesPossibles();
	}

	public void animerEntreeJeton(int indiceColonne, int indiceRangee) {
		J.appel(this);
		
		conteneurGrille.animerEntreeJeton(indiceColonne, indiceRangee);
	}
}
