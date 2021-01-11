package demo.messages.nouvelle_partie_reseau;

import ntro.debogage.J;
import ntro.messages.Message;

public class MsgNouvellePartie extends Message<MsgNouvellePartiePourEnvoi, 
                                             MsgNouvellePartieRecu>

					         implements MsgNouvellePartiePourEnvoi, 
					                    MsgNouvellePartieRecu {
	
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
