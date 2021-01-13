package demo.messages.nouvelle_partie_reseau;

import demo.pages.parametres.modeles.Parametres;
import ntro.messages.MessageRecu;

public interface MsgNouvellePartieRecu extends MessageRecu {
	
	Parametres getParametres();

}
