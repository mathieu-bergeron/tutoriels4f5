package demo.pages.parametres;

import demo.enumerations.Couleur;
import demo.enumerations.TailleGrille;
import ntro.modeles.ModeleLectureSeule;

public interface ParametresLectureSeule extends ModeleLectureSeule {
	
	Couleur getQuiCommence();
	TailleGrille getTailleGrille();

}
