package tp02.client.pages.sauvegardes.modeles;

import java.util.List;

import ntro.modeles.ModeleLectureSeule;

public interface SauvegardesLectureSeule extends ModeleLectureSeule {
	
	List<UneSauvegardeLectureSeule> getLesSauvegardes();

}
