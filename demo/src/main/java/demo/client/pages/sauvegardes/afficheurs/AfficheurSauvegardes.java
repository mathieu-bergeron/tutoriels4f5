package demo.client.pages.sauvegardes.afficheurs;

import ntro.debogage.J;
import demo.client.pages.sauvegardes.modeles.SauvegardesLectureSeule;
import demo.client.pages.sauvegardes.modeles.UneSauvegardeLectureSeule;
import demo.client.pages.sauvegardes.vues.VueSauvegardes;
import ntro.client.mvc.Afficheur;

public class   AfficheurSauvegardes
       extends Afficheur<SauvegardesLectureSeule, VueSauvegardes> {

	@Override
	public void initialiserAffichage(SauvegardesLectureSeule modeleLectureSeule, VueSauvegardes vue) {
		J.appel(this);
		

		afficherLesSauvegardes(modeleLectureSeule, vue);
	}

	@Override
	public void rafraichirAffichage(SauvegardesLectureSeule modeleLectureSeule, VueSauvegardes vue) {
		J.appel(this);
		
		vue.viderLesSauvegardes();
		
		afficherLesSauvegardes(modeleLectureSeule, vue);
	}

	private void afficherLesSauvegardes(SauvegardesLectureSeule modeleLectureSeule, VueSauvegardes vue) {
		J.appel(this);
		
		for(UneSauvegardeLectureSeule uneSauvegarde : modeleLectureSeule.getLesSauvegardes()) {
			
			vue.ajouterSauvegarde(uneSauvegarde);
		}
	}
	

}
