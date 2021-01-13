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


package tut10.pages.partie.composants;

import ntro.commandes.FabriqueCommande;
import ntro.debogage.J;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import tut10.commandes.jouer_ici.JouerIci;
import tut10.commandes.jouer_ici.JouerIciPourEnvoi;

public class Entete extends HBox {
	
	private Button bouton;
	private int indiceColonne;
	private JouerIciPourEnvoi jouerIciPourEnvoi;

	public Entete(int indiceColonne, String texteBouton) {
		J.appel(this);

		HBox.setHgrow(this, Priority.ALWAYS);
		this.getStyleClass().add("conteneurBouton");
		
		this.indiceColonne = indiceColonne;

		this.bouton = new Button(texteBouton);
		bouton.getStyleClass().add("boutonCoup");
		this.getChildren().add(bouton);
	}

	public void installerCapteurJouerIci() {
		J.appel(this);
		
		this.bouton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				jouerIciPourEnvoi.setIndiceColonne(indiceColonne);
				jouerIciPourEnvoi.envoyerCommande();
			}
		});
	}

	public void obtenirJouerIciPourEnvoi() {
		J.appel(this);
		
		jouerIciPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(JouerIci.class);
	}

    public void verifierCommandePossible(){
        J.appel(this);

        jouerIciPourEnvoi.setIndiceColonne(indiceColonne);
        setActif(jouerIciPourEnvoi.siCommandePossible());
    }

    public void setActif(boolean enteteActive) {
        J.appel(this);
        
        this.bouton.setDisable(!enteteActive);
    }
}
