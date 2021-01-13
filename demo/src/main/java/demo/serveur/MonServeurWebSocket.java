package demo.serveur;

import ntro.debogage.J;
import ntro.serveur.ServeurWebSocket;

public class MonServeurWebSocket extends ServeurWebSocket {

	public MonServeurWebSocket(int port) {
		super(port);
		J.appel(this);
	}

}
