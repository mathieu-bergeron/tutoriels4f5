package tp02.client.pages.sauvegardes.controleurs;

import java.io.File;
import java.io.IOException;

import ntro.debogage.J;
import ntro.systeme.Systeme;
import ntro.utiles.Json;
import tp02.client.pages.partie.modeles.PartieLocale;
import tp02.client.pages.sauvegardes.afficheurs.AfficheurSauvegardesFX;
import tp02.client.pages.sauvegardes.vues.VueSauvegardesFX;
import javafx.application.Platform;

public class ControleurSauvegardesFX extends ControleurSauvegardes<VueSauvegardesFX, AfficheurSauvegardesFX>{
	
	@Override
	protected void demarrer(){
		super.demarrer();
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
				vue.cacherRechercheEnCours();
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

				modele.ajouterSauvegarde(Systeme.cheminDansHome(fichier));
				afficheur.rafraichirAffichage(modele, vue);
			}});
	}
	

}
