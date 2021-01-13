package demo.messages.transmettre_qui_commence;

import demo.pages.commun.enumerations.Couleur;
import ntro.messages.MessagePourEnvoi;

public interface MsgTransmettreQuiCommencePourEnvoi extends MessagePourEnvoi {
	
	void setQuiCommence(Couleur quiCommence);

}
