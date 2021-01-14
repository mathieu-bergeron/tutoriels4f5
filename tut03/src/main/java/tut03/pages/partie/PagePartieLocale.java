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


package tut03.pages.partie;

import javafx.application.Application;
import javafx.stage.Stage;
import ntro.debogage.J;
import ntro.javafx.Initialisateur;
import ntro.mvc.modeles.EntrepotDeModeles;
import ntro.systeme.Systeme;
import tut03.pages.partie.modeles.ColonneLectureSeule;
import tut03.pages.partie.modeles.JetonLectureSeule;
import tut03.pages.partie.modeles.PartieLocale;

import static tut03.Constantes.*;

import java.util.Random;


public class PagePartieLocale extends Application {

	static {

		Initialisateur.initialiser();
		
		J.appel(PagePartieLocale.class);
	}

	private Random alea = new Random();
	
	public static void main(String[] args) {
		J.appel(PagePartieLocale.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		String idModeleTest = IDS_MODELES_TESTS[alea.nextInt(IDS_MODELES_TESTS.length)];
		PartieLocale partie = EntrepotDeModeles.obtenirModele(PartieLocale.class, idModeleTest);
		
		J.valeurs(partie.getId(), partie.getLargeur(), partie.getLargeur());
		
		for(int i = 0; i < partie.getLargeur(); i++) {
			
			ColonneLectureSeule colonne = partie.getGrille().getColonnes().get(i);
			
			for(int j = 0; j < colonne.getJetons().size(); j++) {
				
				JetonLectureSeule jeton = colonne.getJetons().get(j);

				J.valeurs(jeton.getIndiceColonne(), jeton.getIndiceRangee(), jeton.getCouleur().name());
			}
		}

		Systeme.quitter();
	}
}
