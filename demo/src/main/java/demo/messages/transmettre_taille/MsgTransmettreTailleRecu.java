package demo.messages.transmettre_taille;

import demo.pages.commun.enumerations.TailleGrille;
import ntro.messages.MessageRecu;

public interface MsgTransmettreTailleRecu extends MessageRecu {
	
	TailleGrille getTailleGrille();

}
