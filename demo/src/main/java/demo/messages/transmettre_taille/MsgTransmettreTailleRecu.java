package demo.messages.transmettre_taille;

import demo.enumerations.TailleGrille;
import ntro.messages.MessageRecu;

public interface MsgTransmettreTailleRecu extends MessageRecu {
	
	TailleGrille getTailleGrille();

}
