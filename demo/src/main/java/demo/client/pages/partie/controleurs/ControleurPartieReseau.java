package demo.client.pages.partie.controleurs;

import ntro.client.mvc.controleurs.RecepteurMessageMVC;
import ntro.debogage.J;
import ntro.messages.FabriqueMessage;
import demo.client.commandes.jouer_ici.JouerIciRecue;
import demo.client.pages.partie.afficheurs.AfficheurPartieReseau;
import demo.client.pages.partie.modeles.PartieReseau;
import demo.client.pages.partie.modeles.PartieReseauLectureSeule;
import demo.client.pages.partie.vues.VuePartieReseau;
import demo.messages.transmettre_coup.TransmettreCoup;
import demo.messages.transmettre_coup.TransmettreCoupPourEnvoi;
import demo.messages.transmettre_coup.TransmettreCoupRecu;

public abstract class ControleurPartieReseau

                extends ControleurPartie<PartieReseauLectureSeule, 
                        PartieReseau, 
                        VuePartieReseau, 
                        AfficheurPartieReseau> {
	
	private TransmettreCoupPourEnvoi transmettreCoup;
	

	@Override
	protected void obtenirMessagesPourEnvoi() {
		super.obtenirMessagesPourEnvoi();
		J.appel(this);
		
		transmettreCoup = FabriqueMessage.obtenirMessagePourEnvoi(TransmettreCoup.class);
	}

	@Override
	protected void installerReceptionMessages() {
		super.installerReceptionMessages();
		J.appel(this);
		
		installerRecepteurMessage(TransmettreCoup.class, new RecepteurMessageMVC<TransmettreCoupRecu>() {

			@Override
			public void recevoirMessageMVC(TransmettreCoupRecu messageRecu) {
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
