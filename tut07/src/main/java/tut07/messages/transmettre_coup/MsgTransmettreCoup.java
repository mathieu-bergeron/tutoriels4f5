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


package tut07.messages.transmettre_coup;

import ntro.debogage.J;
import ntro.messages.Message;

public class MsgTransmettreCoup extends Message<MsgTransmettreCoupPourEnvoi, 
                                             MsgTransmettreCoupRecu>

					         implements MsgTransmettreCoupPourEnvoi, 
					                    MsgTransmettreCoupRecu {
	
	private int indiceColonne;

	@Override
	public int getIndiceColonne() {
		J.appel(this);

		return indiceColonne;
	}

	@Override
	public void setIndiceColonne(int indiceColonne) {
		J.appel(this);
		
		this.indiceColonne = indiceColonne;
	}

}
