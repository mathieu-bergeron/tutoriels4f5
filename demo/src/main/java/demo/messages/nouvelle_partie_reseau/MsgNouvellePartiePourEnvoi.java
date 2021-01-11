package demo.messages.nouvelle_partie_reseau;

import ntro.messages.MessagePourEnvoi;

public interface MsgNouvellePartiePourEnvoi extends MessagePourEnvoi {
	
	void setIndiceColonne(int indiceColonne);

}
