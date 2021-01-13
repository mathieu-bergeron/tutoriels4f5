package demo.pages.parametres.afficheurs;

import ntro.client.mvc.Afficheur;
import ntro.debogage.J;
import demo.pages.parametres.modeles.ParametresLectureSeule;
import demo.pages.parametres.vues.VueParametres;

public class   AfficheurParametres 
       extends Afficheur<ParametresLectureSeule, VueParametres> {

	@Override
	public void initialiserAffichage(ParametresLectureSeule modeleLectureSeule, VueParametres vue) {
		J.appel(this);
		
	}

	@Override
	public void rafraichirAffichage(ParametresLectureSeule modeleLectureSeule, VueParametres vue) {
		J.appel(this);

		vue.afficherQuiCommence(modeleLectureSeule.getQuiCommence());
		vue.afficherTailleGrille(modeleLectureSeule.getTailleGrille());
	}

}
