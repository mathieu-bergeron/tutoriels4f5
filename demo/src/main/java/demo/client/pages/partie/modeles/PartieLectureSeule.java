package demo.client.pages.partie.modeles;

import ntro.modeles.ModeleLectureSeule;

public interface PartieLectureSeule 
       extends   ModeleLectureSeule {
	
	 GrilleLectureSeule getGrille();
	 int getLargeur();
	 int getHauteur();

	 JetonLectureSeule getDernierJetonAjoute();

}
