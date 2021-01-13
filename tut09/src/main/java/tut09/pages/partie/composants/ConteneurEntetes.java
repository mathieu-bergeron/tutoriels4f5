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


package tut09.pages.partie.composants;

import java.util.ArrayList;
import java.util.List;
import ntro.debogage.J;
import javafx.beans.NamedArg;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class ConteneurEntetes extends HBox {
    
    private String texteBouton;
    
    public ConteneurEntetes(@NamedArg("texteBouton") String texteBouton) {
        J.appel(this);
        
        this.texteBouton = texteBouton;
    }

    public void creerEntetes(int largeur) {
        J.appel(this);
        
        for(int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {
            
            this.getChildren().add(new Entete(indiceColonne, texteBouton));
        }
    }

    public void obtenirJouerIciPourEnvoi() {
        J.appel(this);

        for(Entete entete : entetes()) {
            
            entete.obtenirJouerIciPourEnvoi();
        }
    }
    
    public void installerCapteursJouerIci() {
        J.appel(this);
        
        for(Entete entete : entetes()) {
            
            entete.installerCapteurJouerIci();
        }
    }
    
    private List<Entete> entetes(){
        J.appel(this);
        
        List<Entete> entetes = new ArrayList<>();
        
        for(Node enfant : this.getChildren()) {
            
            entetes.add((Entete) enfant);
        }

        return entetes;
    }

    public void verifierCommandesPossibles() {
        J.appel(this);

        for(Entete entete : entetes()) {
            
            entete.verifierCommandePossible();
        }
    }
}
