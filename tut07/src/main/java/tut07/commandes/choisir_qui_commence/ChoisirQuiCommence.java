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


package tut07.commandes.choisir_qui_commence;

import tut07.enumerations.Couleur;
import ntro.commandes.Commande;
import ntro.debogage.J;

public class ChoisirQuiCommence extends Commande<ChoisirQuiCommencePourEnvoi, ChoisirQuiCommenceRecue> 
						   implements ChoisirQuiCommencePourEnvoi, ChoisirQuiCommenceRecue {
	
	private Couleur couleur;

	@Override
	public Couleur getCouleur() {
		J.appel(this);
		
		return couleur;
	}

	@Override
	public void setCouleur(Couleur marque) {
		J.appel(this);
		
		this.couleur = marque;
	}

}
