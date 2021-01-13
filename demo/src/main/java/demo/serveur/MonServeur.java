package demo.serveur;

import ntro.debogage.J;
import static demo.Constantes.*;

public class MonServeur {
	
	public static void main(String[] args) {
		J.appel(MonServeur.class);
		
		demarrerServeur();
	}
	
	private static void demarrerServeur() {
		J.appel(MonServeur.class);
		
		MonServeurWebSocket serveur = new MonServeurWebSocket(PORT);
		serveur.start();
	}

}
