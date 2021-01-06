package tp02.serveur;

import ntro.debogage.J;
import ntro.serveur.ServeurWebSocket;

public class ServeurQuatreDeSuite extends ServeurWebSocket {

	public ServeurQuatreDeSuite(int port) {
		super(port);
		J.appel(this);
	}

}
