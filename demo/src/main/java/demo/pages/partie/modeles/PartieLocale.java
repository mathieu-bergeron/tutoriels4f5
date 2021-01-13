package demo.pages.partie.modeles;

import java.util.Random;

import ntro.debogage.J;

public class      PartieLocale 
       extends    Partie<PartieLocaleLectureSeule> 
       implements PartieLocaleLectureSeule { 
	
	public PartieLocale() {
		super();
		J.appel(this);
		
		 largeur =  3 + (new Random().nextInt(5));
		 hauteur = 4 + (new Random().nextInt(8));
	}
	
	public boolean siInitialisee() {
		J.appel(this);

		return largeur > 0 && 
			   hauteur > 0 && 
			   couleurCourante != null &&
			   grille != null;
	}
	
}
