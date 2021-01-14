// Copyright (C) (2020) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)
//
// This file is part of tutoriels4f5
//
// tutoriels4f5 is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// tutoriels4f5 is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
//
// You should have received a copy of the GNU Affero General Public License
// along with aquiletour.  If not, see <https://www.gnu.org/licenses/>


package tut04.pages.partie.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import tut04.Constantes;
import tut04.enumerations.Couleur;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public abstract class VuePartie implements Vue, Initializable {

    @FXML
    private HBox conteneurEntetes;

    @FXML
    private VBox conteneurGrille;
    
    private Button[] entetes;
    
    private Button[][] cases;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(conteneurEntetes);
		DoitEtre.nonNul(conteneurGrille);
	} 

    public void creerGrille(int largeur, int hauteur) {
        J.appel(this);

        creerEntetes(largeur);
        
        creerColonnes(largeur, hauteur);
    }
    
    private void creerEntetes(int largeur) {
        J.appel(this);
        
        entetes = new Button[largeur];
        
        for(int indiceRangee = 0; indiceRangee < largeur; indiceRangee++) {
        	
        	Button entete = new Button("|");
        	
        	entete.setMinWidth(Constantes.TAILLE_CASE);
        	entete.setMaxWidth(Constantes.TAILLE_CASE);
        	
        	entetes[indiceRangee] = entete;
        	
        	conteneurEntetes.getChildren().add(entete);
        }
    }

    private void creerColonnes(int largeur, int hauteur) {
        J.appel(this);
        
        cases = new Button[largeur][hauteur];

        for(int indiceRangee = 0; indiceRangee < hauteur; indiceRangee++) {
        	HBox ligne = creerLigne(indiceRangee, largeur);
        	
        	conteneurGrille.getChildren().add(ligne);
        }
    }

    private HBox creerLigne(int indiceRangee, int largeur) {
        J.appel(this);
        
        HBox ligne = new HBox();
        
        for(int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {
        	
        	Button _case = new Button();
        	
        	_case.setMinWidth(Constantes.TAILLE_CASE);
        	_case.setMaxWidth(Constantes.TAILLE_CASE);
        	
        	cases[indiceColonne][indiceRangee] = _case;
        	
        	ligne.getChildren().add(_case);
        }
        
        return ligne;
    }
    

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	} 
	
	private boolean siIndicesValides(int indiceColonne, int indiceRangee) {
		J.appel(this);

		boolean siValide = false;
		
		if(indiceColonne >= 0 && indiceColonne < cases.length) {
			siValide = indiceRangee >= 0 && indiceRangee < cases[indiceColonne].length;
		}
		
		return siValide;
	}

	public void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur) {
		J.appel(this);
		
		if(siIndicesValides(indiceColonne, indiceRangee)) {

			Button _case = cases[indiceColonne][indiceRangee];
			
			switch(couleur) {
				case JAUNE:
					_case.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
					break;

				case ROUGE:
					_case.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
					break;
			}
		}
	}

}
