package demo.messages.transmettre_coup;

import ntro.debogage.J;
import ntro.messages.Message;

public class MsgTransmettreCoup extends Message<MsgTransmettreCoupPourEnvoi, 
                                             MsgTransmettreCoupRecu>

					         implements MsgTransmettreCoupPourEnvoi, 
					                    MsgTransmettreCoupRecu {
	
	private int indiceColonne;

	@Override
	public int getIndiceColonne() {
		J.appel(this);

		return indiceColonne;
	}

	@Override
	public void setIndiceColonne(int indiceColonne) {
		J.appel(this);
		
		this.indiceColonne = indiceColonne;
	}

}
