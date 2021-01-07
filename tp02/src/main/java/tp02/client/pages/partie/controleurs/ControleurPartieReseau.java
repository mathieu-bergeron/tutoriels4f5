package tp02.client.pages.partie.controleurs;

import ntro.client.mvc.controleurs.RecepteurMessageMVC;
import ntro.debogage.J;
import ntro.messages.FabriqueMessage;
import tp02.client.commandes.jouer_ici.JouerIciRecue;
import tp02.client.pages.partie.afficheurs.AfficheurPartieReseau;
import tp02.client.pages.partie.modeles.PartieReseau;
import tp02.client.pages.partie.modeles.PartieReseauLectureSeule;
import tp02.client.pages.partie.vues.VuePartieReseau;
import tp02.messages.transmettre_coup.TransmettreCoup;
import tp02.messages.transmettre_coup.TransmettreCoupPourEnvoi;
import tp02.messages.transmettre_coup.TransmettreCoupRecu;

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
