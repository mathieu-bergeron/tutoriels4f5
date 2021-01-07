package tp02.client.pages.sauvegardes.controleurs;

import ntro.debogage.J;
import ntro.systeme.Systeme;
import ntro.utiles.Json;
import tp02.client.pages.partie.modeles.PartieLocale;
import tp02.client.pages.sauvegardes.afficheurs.AfficheurSauvegardes;
import tp02.client.pages.sauvegardes.modeles.Sauvegardes;
import tp02.client.pages.sauvegardes.modeles.SauvegardesLectureSeule;
import tp02.client.pages.sauvegardes.vues.VueSauvegardes;

import java.io.File;
import java.io.IOException;

import javafx.application.Platform;
import ntro.client.mvc.controleurs.ControleurModeleVue;

public class   ControleurSauvegardes
	   extends ControleurModeleVue<SauvegardesLectureSeule, 
	                               Sauvegardes,
	                               VueSauvegardes,
	                               AfficheurSauvegardes> {
	
	@Override
	protected void demarrer(){
		J.appel(this);
		
		new Thread() {
			
			@Override
			public void run() {
				chercherSauvegardes();
			}
		}.start();
	}

	private void chercherSauvegardes() {
		J.appel(this);
		
		File home = Systeme.getHome().toFile();
		
		chercherSauvegardes(home);
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				getVue().cacherRechercheEnCours();
			}
		});
	}
	
	
	private void chercherSauvegardes(File repertoire) {
		J.appel(this);
		
		// XXX: en Windows, listFiles() peut retourner null
		if(repertoire.listFiles() == null) return;
		
		for(File fichier : repertoire.listFiles()) {

			if(fichier.isFile() && fichier.getName().endsWith("json")) {
				
				ajouterSauvegardeSiPossible(fichier);
				
			} else if(fichier.isDirectory() && !fichier.getName().startsWith(".")) {
				
				chercherSauvegardes(fichier);
			}
		}
	}

	private void ajouterSauvegardeSiPossible(File fichier) {
		J.appel(this);

		PartieLocale sauvegardePartie = null;

		try {

			sauvegardePartie = Json.aPartirFichier(fichier, PartieLocale.class);

		}catch(IOException e) { }

		if(sauvegardePartie != null && sauvegardePartie.siInitialisee()) {

			ajouterSauvegarde(fichier);
		}
	}

	private void ajouterSauvegarde(File fichier) {
		J.appel(this);

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				J.appel(this);

				getModele().ajouterSauvegarde(Systeme.cheminDansHome(fichier));
				getAfficheur().rafraichirAffichage(getModele(), getVue());
			}});
	}
	


	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);

	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
		
	}
}
