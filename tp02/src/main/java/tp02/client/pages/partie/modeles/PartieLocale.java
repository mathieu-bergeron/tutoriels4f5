package tp02.client.pages.partie.modeles;

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
}
