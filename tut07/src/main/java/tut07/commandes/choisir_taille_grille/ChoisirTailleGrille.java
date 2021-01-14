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


package tut07.commandes.choisir_taille_grille;

import tut07.enumerations.TailleGrille;
import ntro.commandes.Commande;
import ntro.debogage.J;

public class ChoisirTailleGrille extends Commande<ChoisirTailleGrillePourEnvoi, ChoisirTailleGrilleRecue> 
						   implements ChoisirTailleGrillePourEnvoi, ChoisirTailleGrilleRecue {
	
	private TailleGrille tailleGrille;

	@Override
	public TailleGrille getTailleGrille() {
		J.appel(this);
		
		return tailleGrille;
	}

	@Override
	public void setTailleGrille(TailleGrille taille) {
		J.appel(this);
		
		this.tailleGrille = taille;
	}
	

}
