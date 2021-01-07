package tp02.client.pages.sauvegardes.afficheurs;

import ntro.debogage.J;
import tp02.client.pages.sauvegardes.modeles.SauvegardesLectureSeule;
import tp02.client.pages.sauvegardes.modeles.UneSauvegardeLectureSeule;
import tp02.client.pages.sauvegardes.vues.VueSauvegardes;
import ntro.client.mvc.Afficheur;

public abstract class AfficheurSauvegardes<V extends VueSauvegardes> 
       extends Afficheur<SauvegardesLectureSeule, V> {

	@Override
	public void initialiserAffichage(SauvegardesLectureSeule modeleLectureSeule, V vue) {
		J.appel(this);
		

		afficherLesSauvegardes(modeleLectureSeule, vue);
	}

	@Override
	public void rafraichirAffichage(SauvegardesLectureSeule modeleLectureSeule, V vue) {
		J.appel(this);
		
		vue.viderLesSauvegardes();
		
		afficherLesSauvegardes(modeleLectureSeule, vue);
	}

	private void afficherLesSauvegardes(SauvegardesLectureSeule modeleLectureSeule, V vue) {
		J.appel(this);
		
		for(UneSauvegardeLectureSeule uneSauvegarde : modeleLectureSeule.getLesSauvegardes()) {
			
			vue.ajouterSauvegarde(uneSauvegarde);
		}
	}
	

}
