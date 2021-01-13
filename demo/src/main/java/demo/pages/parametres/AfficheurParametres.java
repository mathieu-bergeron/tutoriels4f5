package demo.pages.parametres;

import ntro.client.mvc.Afficheur;
import ntro.debogage.J;

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
