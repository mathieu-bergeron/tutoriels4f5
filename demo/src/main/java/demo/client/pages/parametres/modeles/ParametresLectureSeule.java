package demo.client.pages.parametres.modeles;

import demo.client.pages.commun.enumerations.Couleur;
import demo.client.pages.commun.enumerations.TailleGrille;
import ntro.modeles.ModeleLectureSeule;

public interface ParametresLectureSeule extends ModeleLectureSeule {
	
	Couleur getQuiCommence();
	TailleGrille getTailleGrille();

}
