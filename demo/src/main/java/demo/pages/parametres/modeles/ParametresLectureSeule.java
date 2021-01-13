package demo.pages.parametres.modeles;

import demo.pages.commun.enumerations.Couleur;
import demo.pages.commun.enumerations.TailleGrille;
import ntro.modeles.ModeleLectureSeule;

public interface ParametresLectureSeule extends ModeleLectureSeule {
	
	Couleur getQuiCommence();
	TailleGrille getTailleGrille();

}
