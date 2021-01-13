package demo.messages.transmettre_qui_commence;

import demo.enumerations.Couleur;
import ntro.messages.MessagePourEnvoi;

public interface MsgTransmettreQuiCommencePourEnvoi extends MessagePourEnvoi {
	
	void setQuiCommence(Couleur quiCommence);

}
