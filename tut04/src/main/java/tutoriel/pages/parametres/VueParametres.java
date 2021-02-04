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


package tutoriel.pages.parametres;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import tutoriel.enumerations.Couleur;
import tutoriel.enumerations.TailleGrille;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class VueParametres implements Vue, Initializable {

	@FXML 
	private Button caseRouge, caseJaune;
	
	@FXML
	private CheckBox checkRouge, checkJaune;

	@FXML
	private ComboBox<String> choixTaille;
	
	private Map<String, TailleGrille> tailleSelonNom = new HashMap<>();
	private Map<TailleGrille, String> nomSelonTaille = new HashMap<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(caseRouge);
		DoitEtre.nonNul(caseJaune);
		DoitEtre.nonNul(checkRouge);
		DoitEtre.nonNul(checkJaune);
		DoitEtre.nonNul(choixTaille);

		caseRouge.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		caseJaune.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
		
		initialiserChoixTaille(resources);
	}

	private void initialiserChoixTaille(ResourceBundle resources) {
		J.appel(this);

		for(TailleGrille tailleGrille : TailleGrille.values()) {
			
			String nomTaille = tailleGrille.name();
			
			choixTaille.getItems().add(nomTaille);
			
			tailleSelonNom.put(nomTaille, tailleGrille);
			nomSelonTaille.put(tailleGrille, nomTaille);
		}

		choixTaille.getSelectionModel().clearAndSelect(0);
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

	public void afficherQuiCommence(Couleur couleur) {
		J.appel(this);
		
		DoitEtre.nonNul(couleur);

		switch(couleur) {
		
		case ROUGE:
			checkRouge.setSelected(true);
			checkJaune.setSelected(false);
			break;

		case JAUNE:
			checkRouge.setSelected(false);
			checkJaune.setSelected(true);
			break;
		
		}
	}

	public void afficherTailleGrille(TailleGrille tailleGrille) {
		J.appel(this);
		
		String nomTaille = nomSelonTaille.get(tailleGrille);
		
		int indiceTaille = choixTaille.getItems().indexOf(nomTaille);
		
		if(indiceTaille != -1) {
			choixTaille.getSelectionModel().clearAndSelect(indiceTaille);
		}
	}
}
