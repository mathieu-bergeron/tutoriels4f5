package tp02.client.pages.parametres.afficheurs;

import ntro.client.mvc.Afficheur;
import ntro.debogage.J;
import tp02.client.pages.parametres.modeles.ParametresLectureSeule;
import tp02.client.pages.parametres.vues.VueParametres;

public class   AfficheurParametres 
       extends Afficheur<ParametresLectureSeule, VueParametres> {

	@Override
	public void initialiserAffichage(ParametresLectureSeule modeleLectureSeule, VueParametres vue) {
		J.appel(this);
		
		vue.afficherQuiCommence(modeleLectureSeule.getQuiCommence());
	}

	@Override
	public void rafraichirAffichage(ParametresLectureSeule modeleLectureSeule, VueParametres vue) {
		J.appel(this);

		vue.afficherQuiCommence(modeleLectureSeule.getQuiCommence());
	}

}
