package demo.client.pages.sauvegardes.modeles;

import java.util.ArrayList;
import java.util.List;

import ntro.debogage.J;
import ntro.modeles.Modele;

public class Sauvegardes 
       extends Modele<SauvegardesLectureSeule>
	   implements SauvegardesLectureSeule {
	
	
	private List<UneSauvegarde> lesSauvegardes = new ArrayList<>();

	@Override
	public void apresCreation() {
		J.appel(this);
	}

	@Override
	public void apresChargementJson() {
		J.appel(this);
	}
	
	@Override
	public List<UneSauvegardeLectureSeule> getLesSauvegardes() {
		J.appel(this);
		
		List<UneSauvegardeLectureSeule> lesSauvegardesLectureSeule = new ArrayList<>();
		
		for(UneSauvegarde uneSauvegarde : lesSauvegardes) {
			
			lesSauvegardesLectureSeule.add(uneSauvegarde);
		}
		
		
		return lesSauvegardesLectureSeule;
	}
	
	public void ajouterSauvegarde(String cheminDansHome) {
		J.appel(this);
		
		UneSauvegarde uneSauvegarde = new UneSauvegarde(cheminDansHome);

		lesSauvegardes.add(uneSauvegarde);
	}
	
	
	

}
