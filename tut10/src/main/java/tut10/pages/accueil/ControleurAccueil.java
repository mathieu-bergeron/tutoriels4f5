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


package tut10.pages.accueil;

import ntro.debogage.Erreur;
import ntro.debogage.J;
import ntro.systeme.Systeme;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.DialogueModal;
import ntro.messages.FabriqueMessage;
import ntro.messages.RecepteurMessage;
import ntro.mvc.controleurs.ControleurVue;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import ntro.mvc.modeles.EntrepotDeModeles;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tut10.client.MonClient;
import tut10.commandes.fermer_parametres.FermerParametres;
import tut10.commandes.fermer_parametres.FermerParametresRecue;
import tut10.commandes.nouvelle_partie.NouvellePartieLocale;
import tut10.commandes.nouvelle_partie.NouvellePartieLocaleRecue;
import tut10.commandes.nouvelle_partie_reseau.NouvellePartieReseau;
import tut10.commandes.nouvelle_partie_reseau.NouvellePartieReseauRecue;
import tut10.commandes.ouvrir_parametres.OuvrirParametres;
import tut10.commandes.ouvrir_parametres.OuvrirParametresRecue;
import tut10.commandes.quitter.Quitter;
import tut10.commandes.quitter.QuitterRecue;
import tut10.pages.parametres.AfficheurParametres;
import tut10.pages.parametres.ControleurParametres;
import tut10.pages.parametres.Parametres;
import tut10.pages.parametres.VueParametres;
import tut10.pages.partie.afficheurs.AfficheurPartieLocale;
import tut10.pages.partie.afficheurs.AfficheurPartieReseau;
import tut10.pages.partie.controleurs.ControleurPartieLocale;
import tut10.pages.partie.controleurs.ControleurPartieReseau;
import tut10.pages.partie.modeles.PartieLocale;
import tut10.pages.partie.modeles.PartieReseau;
import tut10.pages.partie.vues.VuePartieLocale;
import tut10.pages.partie.vues.VuePartieReseau;
import tut10.messages.nouvelle_partie_reseau.MsgNouvellePartie;
import tut10.messages.nouvelle_partie_reseau.MsgNouvellePartiePourEnvoi;
import tut10.messages.nouvelle_partie_reseau.MsgNouvellePartieRecu;

import static tut10.Constantes.*;

import java.io.IOException;

public class ControleurAccueil extends ControleurVue<VueAccueil> {

	private Scene sceneParametres;
	private Stage dialogueParametres;
	private Parametres parametres;
	private PartieLocale partieLocale;

	private MsgNouvellePartiePourEnvoi messageNouvellePartieReseau;

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

		installerRecepteurCommande(NouvellePartieReseau.class, new RecepteurCommandeMVC<NouvellePartieReseauRecue>() {
			@Override
			public void executerCommandeMVC(NouvellePartieReseauRecue commande) {
				J.appel(this);
				
				initierNouvellePartieReseau();
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
		
		messageNouvellePartieReseau = FabriqueMessage.obtenirMessagePourEnvoi(MsgNouvellePartie.class);
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
		
		FabriqueMessage.installerRecepteur(MsgNouvellePartie.class, new RecepteurMessage<MsgNouvellePartieRecu>() {

			@Override
			public void recevoirMessage(MsgNouvellePartieRecu messageRecu) {
				J.appel(this);
				
				creerNouvellePartieReseau(messageRecu.getParametres());
			}
		});
	}

	@Override
	protected void demarrer() {
		J.appel(this);

		instancierControleurParametres();
		
		ouvrirPartie();
	}

	private void instancierControleurParametres() {
		J.appel(this);

		ChargeurDeVue<VueParametres> chargeur;
		chargeur = new ChargeurDeVue<VueParametres>(CHEMIN_PARAMETRES_FXML,
										            CHEMIN_PARAMETRES_CSS,
				                            		CHEMIN_CHAINES);
		
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

	private void ouvrirPartie() {
		J.appel(this);

		if(MonClient.siConnecteAuServeur()) {
			
			initierNouvellePartieReseau();

		}else {

			ouvrirPartieLocale();
		}
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

	private void initierNouvellePartieReseau() {
		J.appel(this);
		
		if(MonClient.siConnecteAuServeur()) {
			
			messageNouvellePartieReseau.setParametres(parametres);
			messageNouvellePartieReseau.envoyerMessage();

			creerNouvellePartieReseau(parametres);
			
		}else {
			
			getVue().alerterErreurConnexion();
		}
	}

	private void creerNouvellePartieReseau(Parametres parametres) {
		J.appel(this);

		VuePartieReseau vuePartieReseau = getVue().creerVuePartieReseau();
		
		PartieReseau partie = creerPartieReseauSelonParametres(parametres);
		
		AfficheurPartieReseau afficheur = new AfficheurPartieReseau();
		
		FabriqueControleur.creerControleur(ControleurPartieReseau.class, partie, vuePartieReseau, afficheur);
	}


	private PartieReseau creerPartieReseauSelonParametres(Parametres parametres) {
		J.appel(this);

		PartieReseau partie = EntrepotDeModeles.creerModele(PartieReseau.class, ID_MODELE_PAR_DEFAUT);
		
		partie.setCouleurCourante(parametres.getQuiCommence());
		partie.setHauteur(parametres.getTailleGrille().getHauteur());
		partie.setLargeur(parametres.getTailleGrille().getLargeur());
		return partie;
	}
	
	private void ouvrirParametres() {
		J.appel(this);
		
		dialogueParametres = DialogueModal.ouvrirDialogueModal(sceneParametres);
		
		dialogueParametres.setMinWidth(LARGEUR_PARAMETRES_PIXELS_MIN * AJUSTEMENT_TAILLE_PIXELS);
		dialogueParametres.setMinHeight(HAUTEUR_PARAMETRES_PIXELS_MIN * AJUSTEMENT_TAILLE_PIXELS);

		dialogueParametres.setWidth(LARGEUR_PARAMETRES_PIXELS * AJUSTEMENT_TAILLE_PIXELS);
		dialogueParametres.setHeight(HAUTEUR_PARAMETRES_PIXELS * AJUSTEMENT_TAILLE_PIXELS);

		dialogueParametres.setMaxWidth(LARGEUR_PARAMETRES_PIXELS_MAX * AJUSTEMENT_TAILLE_PIXELS);
		dialogueParametres.setMaxHeight(HAUTEUR_PARAMETRES_PIXELS_MAX * AJUSTEMENT_TAILLE_PIXELS);
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
