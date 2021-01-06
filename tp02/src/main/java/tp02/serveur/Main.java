package tp02.serveur;

import ntro.debogage.J;
import static tp02.client.Constantes.*;

public class Main {
	
	public static void main(String[] args) {
		J.appel(Main.class);
		
		demarrerServeur();
	}
	
	private static void demarrerServeur() {
		J.appel(Main.class);
		
		ServeurQuatreDeSuite serveur = new ServeurQuatreDeSuite(PORT);
		serveur.start();
	}

}
