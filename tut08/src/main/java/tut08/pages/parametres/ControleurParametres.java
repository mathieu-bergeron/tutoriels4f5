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


package tut08.pages.parametres;

import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.messages.FabriqueMessage;
import ntro.mvc.controleurs.ControleurModeleVue;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import ntro.mvc.controleurs.RecepteurMessageMVC;
import tut08.commandes.choisir_qui_commence.ChoisirQuiCommence;
import tut08.commandes.choisir_qui_commence.ChoisirQuiCommenceRecue;
import tut08.commandes.choisir_taille_grille.ChoisirTailleGrille;
import tut08.commandes.choisir_taille_grille.ChoisirTailleGrilleRecue;
import tut08.enumerations.Couleur;
import tut08.enumerations.TailleGrille;
import tut08.messages.transmettre_qui_commence.MsgTransmettreQuiCommence;
import tut08.messages.transmettre_qui_commence.MsgTransmettreQuiCommencePourEnvoi;
import tut08.messages.transmettre_qui_commence.MsgTransmettreQuiCommenceRecu;
import tut08.messages.transmettre_taille.MsgTransmettreTaille;
import tut08.messages.transmettre_taille.MsgTransmettreTaillePourEnvoi;
import tut08.messages.transmettre_taille.MsgTransmettreTailleRecu;

public class   ControleurParametres 
       extends ControleurModeleVue<ParametresLectureSeule, 
                                   Parametres,
                                   VueParametres,
                                   AfficheurParametres> {
	
	private MsgTransmettreQuiCommencePourEnvoi msgTransmettreQuiCommence;
	private MsgTransmettreTaillePourEnvoi msgTransmettreTaille;

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(ChoisirQuiCommence.class, new RecepteurCommandeMVC<ChoisirQuiCommenceRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirQuiCommenceRecue commande) {
				J.appel(this);
				
				Couleur quiCommence = commande.getCouleur();

				DoitEtre.nonNul(quiCommence);

				getModele().choisirQuiCommence(quiCommence);
				
				msgTransmettreQuiCommence.setQuiCommence(quiCommence);
				msgTransmettreQuiCommence.envoyerMessage();
			}
		});
		
		installerRecepteurCommande(ChoisirTailleGrille.class, new RecepteurCommandeMVC<ChoisirTailleGrilleRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirTailleGrilleRecue commande) {
				J.appel(this);
				
				TailleGrille tailleGrille = commande.getTailleGrille();
				
				DoitEtre.nonNul(tailleGrille);
				
				getModele().choisirTailleGrille(tailleGrille);

				msgTransmettreTaille.setTailleGrille(tailleGrille);
				msgTransmettreTaille.envoyerMessage();
			}
		});
	}

	@Override
	protected void demarrer() {
		J.appel(this);
	} 

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
		
		msgTransmettreQuiCommence = FabriqueMessage.obtenirMessagePourEnvoi(MsgTransmettreQuiCommence.class);
		msgTransmettreTaille = FabriqueMessage.obtenirMessagePourEnvoi(MsgTransmettreTaille.class);
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
		
		installerRecepteurMessage(MsgTransmettreQuiCommence.class, new RecepteurMessageMVC<MsgTransmettreQuiCommenceRecu>() {

			@Override
			public void recevoirMessageMVC(MsgTransmettreQuiCommenceRecu messageRecu) {
				J.appel(this);
				
				Couleur quiCommence = messageRecu.getQuiCommence();
				
				DoitEtre.nonNul(quiCommence);
				
				getModele().choisirQuiCommence(quiCommence);
			}
		});
		
		installerRecepteurMessage(MsgTransmettreTaille.class, new RecepteurMessageMVC<MsgTransmettreTailleRecu>() {
			@Override
			public void recevoirMessageMVC(MsgTransmettreTailleRecu messageRecu) {
				J.appel(this);
				
				TailleGrille tailleGrille = messageRecu.getTailleGrille();
				
				DoitEtre.nonNul(tailleGrille);
				
				getModele().choisirTailleGrille(tailleGrille);
			}
		});
	}
}
