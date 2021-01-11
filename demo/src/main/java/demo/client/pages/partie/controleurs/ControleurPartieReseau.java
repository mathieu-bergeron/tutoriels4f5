package demo.client.pages.partie.controleurs;

import ntro.client.mvc.controleurs.RecepteurMessageMVC;
import ntro.debogage.J;
import ntro.messages.FabriqueMessage;
import demo.client.commandes.jouer_ici.JouerIciRecue;
import demo.client.pages.partie.afficheurs.AfficheurPartieReseau;
import demo.client.pages.partie.modeles.PartieReseau;
import demo.client.pages.partie.modeles.PartieReseauLectureSeule;
import demo.client.pages.partie.vues.VuePartieReseau;
import demo.messages.transmettre_coup.MsgTransmettreCoup;
import demo.messages.transmettre_coup.MsgTransmettreCoupPourEnvoi;
import demo.messages.transmettre_coup.MsgTransmettreCoupRecu;

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
