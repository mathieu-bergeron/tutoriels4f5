package tp02.client.pages.parametres.modeles;

import java.util.Random;
import ntro.debogage.J;
import ntro.modeles.Modele;

public class Parametres extends Modele<ParametresLectureSeule> implements ParametresLectureSeule {
	
	private Marque quiCommence = (new Random().nextBoolean()) ? Marque.X : Marque.O;

	@Override
	public Marque getQuiCommence() {
		J.appel(this);

		return quiCommence;
	}

	public void choisirQuiCommence(Marque joueurQuiCommence) {
		J.appel(this);
		
		this.quiCommence = joueurQuiCommence;
	}

}
