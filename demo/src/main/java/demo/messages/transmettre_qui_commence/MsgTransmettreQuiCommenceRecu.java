package demo.messages.transmettre_qui_commence;

import demo.enumerations.Couleur;
import ntro.messages.MessageRecu;

public interface MsgTransmettreQuiCommenceRecu extends MessageRecu {
	
	Couleur getQuiCommence();

}
