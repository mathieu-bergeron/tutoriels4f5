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


package tutoriel.pages.partie.controleurs;

import ntro.debogage.J;
import ntro.messages.FabriqueMessage;
import ntro.mvc.controleurs.RecepteurMessageMVC;
import tutoriel.commandes.jouer_ici.JouerIciRecue;
import tutoriel.pages.partie.afficheurs.AfficheurPartieReseau;
import tutoriel.pages.partie.modeles.PartieReseau;
import tutoriel.pages.partie.modeles.PartieReseauLectureSeule;
import tutoriel.pages.partie.vues.VuePartieReseau;
import tutoriel.messages.transmettre_coup.MsgTransmettreCoup;
import tutoriel.messages.transmettre_coup.MsgTransmettreCoupPourEnvoi;
import tutoriel.messages.transmettre_coup.MsgTransmettreCoupRecu;

public class ControleurPartieReseau

                extends ControleurPartie<PartieReseauLectureSeule, 
                        PartieReseau, 
                        VuePartieReseau, 
                        AfficheurPartieReseau> {
	
	private MsgTransmettreCoupPourEnvoi transmettreCoup;
	

	@Override
	protected void obtenirMessagesPourEnvoi() {
		super.obtenirMessagesPourEnvoi();
		J.appel(this);
		
		transmettreCoup = FabriqueMessage.obtenirMessagePourEnvoi(MsgTransmettreCoup.class);
	}

	@Override
	protected void installerReceptionMessages() {
		super.installerReceptionMessages();
		J.appel(this);
		
		installerRecepteurMessage(MsgTransmettreCoup.class, new RecepteurMessageMVC<MsgTransmettreCoupRecu>() {

			@Override
			public void recevoirMessageMVC(MsgTransmettreCoupRecu messageRecu) {
				J.appel(this);
				
				getModele().jouerIci(messageRecu.getIndiceColonne());
			}
		});
	}
	
	@Override
	protected void reagirCommandeJouerIci(JouerIciRecue jouerIciRecue) {
		super.reagirCommandeJouerIci(jouerIciRecue);
		J.appel(this);
		
		transmettreCoup.setIndiceColonne(jouerIciRecue.getIndiceColonne());
		transmettreCoup.envoyerMessage();
	}
}
