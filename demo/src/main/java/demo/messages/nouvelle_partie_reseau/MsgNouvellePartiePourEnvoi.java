package demo.messages.nouvelle_partie_reseau;

import demo.pages.parametres.modeles.Parametres;
import ntro.messages.MessagePourEnvoi;

public interface MsgNouvellePartiePourEnvoi extends MessagePourEnvoi {
	
	void setParametres(Parametres parametres);

}
