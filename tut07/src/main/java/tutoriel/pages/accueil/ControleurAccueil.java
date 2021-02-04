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


package tutoriel.pages.accueil;

import ntro.debogage.Erreur;
import ntro.debogage.J;
import ntro.systeme.Systeme;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.DialogueModal;
import ntro.messages.FabriqueMessage;
import ntro.mvc.controleurs.ControleurVue;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import ntro.mvc.modeles.EntrepotDeModeles;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tutoriel.commandes.fermer_parametres.FermerParametres;
import tutoriel.commandes.fermer_parametres.FermerParametresRecue;
import tutoriel.commandes.nouvelle_partie.NouvellePartieLocale;
import tutoriel.commandes.nouvelle_partie.NouvellePartieLocaleRecue;
import tutoriel.commandes.ouvrir_parametres.OuvrirParametres;
import tutoriel.commandes.ouvrir_parametres.OuvrirParametresRecue;
import tutoriel.commandes.quitter.Quitter;
import tutoriel.commandes.quitter.QuitterRecue;
import tutoriel.pages.parametres.AfficheurParametres;
import tutoriel.pages.parametres.ControleurParametres;
import tutoriel.pages.parametres.Parametres;
import tutoriel.pages.parametres.VueParametres;
import tutoriel.pages.partie.afficheurs.AfficheurPartieLocale;
import tutoriel.pages.partie.afficheurs.AfficheurPartieReseau;
import tutoriel.pages.partie.controleurs.ControleurPartieLocale;
import tutoriel.pages.partie.controleurs.ControleurPartieReseau;
import tutoriel.pages.partie.modeles.PartieLocale;
import tutoriel.pages.partie.modeles.PartieReseau;
import tutoriel.pages.partie.vues.VuePartieLocale;
import tutoriel.pages.partie.vues.VuePartieReseau;

import static tutoriel.Constantes.*;

import java.io.IOException;

public class ControleurAccueil extends ControleurVue<VueAccueil> {

	private Scene sceneParametres;
	private Stage dialogueParametres;
	private Parametres parametres;
	private PartieLocale partieLocale;

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);

		installerRecepteurCommande(NouvellePartieLocale.class, new RecepteurCommandeMVC<NouvellePartieLocaleRecue>() {
			@Override
			public void executerCommandeMVC(NouvellePartieLocaleRecue commande) {
				J.appel(this);
				
				nouvellePartieLocale();
			}
		});

		installerRecepteurCommande(OuvrirParametres.class, new RecepteurCommandeMVC<OuvrirParametresRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirParametresRecue commande) {
				J.appel(this);
				
				ouvrirParametres();
			}
		});

		installerRecepteurCommande(FermerParametres.class, new RecepteurCommandeMVC<FermerParametresRecue>() {
			@Override
			public void executerCommandeMVC(FermerParametresRecue commande) {
				J.appel(this);
				
				fermerParametres();
			}
		});

		installerRecepteurCommande(Quitter.class, new RecepteurCommandeMVC<QuitterRecue>() {
			@Override
			public void executerCommandeMVC(QuitterRecue commande) {
				J.appel(this);

				quitter();
			}
		});
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
	}

	@Override
	protected void demarrer() {
		J.appel(this);

		instancierControleurParametres();
		
		ouvrirPartieLocale();
	}

	private void instancierControleurParametres() {
		J.appel(this);

		ChargeurDeVue<VueParametres> chargeur;
		chargeur = new ChargeurDeVue<VueParametres>(CHEMIN_PARAMETRES_FXML);
		
		sceneParametres = chargeur.nouvelleScene(LARGEUR_PARAMETRES_PIXELS, 
				                                 HAUTEUR_PARAMETRES_PIXELS);
		
		parametres = EntrepotDeModeles.creerModele(Parametres.class, ID_MODELE_PAR_DEFAUT);
		
		AfficheurParametres afficheurParametres = new AfficheurParametres();
		
		VueParametres vueParametres = chargeur.getVue();
		
		FabriqueControleur.creerControleur(ControleurParametres.class, 
				                           parametres, 
				                           vueParametres, 
				                           afficheurParametres);
	}

	private void ouvrirPartieLocale() {
		J.appel(this);
		
		try {

			partieLocale = EntrepotDeModeles.obtenirModele(PartieLocale.class, ID_MODELE_PAR_DEFAUT);

		} catch (IOException e) {
			
			creerNouvellePartieLocaleSelonParametres(parametres);
		}
		
		instancierControleurPartieLocale();
	}
	
	private void nouvellePartieLocale() {
		J.appel(this);

		creerNouvellePartieLocaleSelonParametres(parametres);

		instancierControleurPartieLocale();
	}

	private void instancierControleurPartieLocale() {
		J.appel(this);

		VuePartieLocale vuePartieLocale = getVue().creerVuePartieLocale();

		AfficheurPartieLocale afficheur = new AfficheurPartieLocale();

		FabriqueControleur.creerControleur(ControleurPartieLocale.class, 
			                           	   partieLocale, 
			                           	   vuePartieLocale, 
			                           	   afficheur);
	}

	private void creerNouvellePartieLocaleSelonParametres(Parametres parametres) {
		J.appel(this);

		partieLocale = EntrepotDeModeles.creerModele(PartieLocale.class, ID_MODELE_PAR_DEFAUT);
		partieLocale.setCouleurCourante(parametres.getQuiCommence());
		partieLocale.setLargeur(parametres.getTailleGrille().getLargeur());
		partieLocale.setHauteur(parametres.getTailleGrille().getHauteur());
	}

	private void ouvrirParametres() {
		J.appel(this);
		
		dialogueParametres = DialogueModal.ouvrirDialogueModal(sceneParametres);
		
		dialogueParametres.setMinWidth(LARGEUR_PARAMETRES_PIXELS_MIN);
		dialogueParametres.setMinHeight(HAUTEUR_PARAMETRES_PIXELS_MIN);

		dialogueParametres.setWidth(LARGEUR_PARAMETRES_PIXELS);
		dialogueParametres.setHeight(HAUTEUR_PARAMETRES_PIXELS);

		dialogueParametres.setMaxWidth(LARGEUR_PARAMETRES_PIXELS_MAX);
		dialogueParametres.setMaxHeight(HAUTEUR_PARAMETRES_PIXELS_MAX);
	}

	private void fermerParametres() {
		J.appel(this);
		
		if(dialogueParametres != null) {
			dialogueParametres.close();
		}
	}

	private void quitter() {
		J.appel(this);

		sauvegarderPartieLocale();

		Systeme.quitter();
	}


	private void sauvegarderPartieLocale() {
		J.appel(this);

		if (partieLocale != null) {
			try {

				EntrepotDeModeles.sauvegarderModele(partieLocale);

			} catch (IOException e) {

				Erreur.nonFatale("Impossible de sauvegarder la partie locale", e);
			}
		}
	}
}
