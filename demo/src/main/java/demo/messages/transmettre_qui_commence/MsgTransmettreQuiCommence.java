package demo.messages.transmettre_qui_commence;

import demo.enumerations.Couleur;
import ntro.debogage.J;
import ntro.messages.Message;

public class MsgTransmettreQuiCommence extends Message<MsgTransmettreQuiCommencePourEnvoi, 
                                             MsgTransmettreQuiCommenceRecu>

					         implements MsgTransmettreQuiCommencePourEnvoi, 
					                    MsgTransmettreQuiCommenceRecu {
	
	private Couleur quiCommence;

	@Override
	public Couleur getQuiCommence() {
		J.appel(this);
		
		return quiCommence;
	}

	@Override
	public void setQuiCommence(Couleur quiCommence) {
		J.appel(this);
		
		this.quiCommence = quiCommence;
	}
}
