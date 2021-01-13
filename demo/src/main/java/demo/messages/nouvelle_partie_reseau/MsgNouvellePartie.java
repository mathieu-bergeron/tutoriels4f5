package demo.messages.nouvelle_partie_reseau;

import demo.pages.parametres.Parametres;
import ntro.debogage.J;
import ntro.messages.Message;

public class MsgNouvellePartie extends Message<MsgNouvellePartiePourEnvoi, 
                                             MsgNouvellePartieRecu>

					         implements MsgNouvellePartiePourEnvoi, 
					                    MsgNouvellePartieRecu {
	
	private Parametres parametres;

	@Override
	public Parametres getParametres() {
		J.appel(this);

		return parametres;
	}

	@Override
	public void setParametres(Parametres parametres) {
		J.appel(this);
		
		this.parametres = parametres;
	}
}
