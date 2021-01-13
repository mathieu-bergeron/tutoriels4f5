package demo.messages.transmettre_taille;

import demo.pages.commun.enumerations.TailleGrille;
import ntro.messages.MessagePourEnvoi;

public interface MsgTransmettreTaillePourEnvoi extends MessagePourEnvoi {
	
	void setTailleGrille(TailleGrille tailleGrille);

}
