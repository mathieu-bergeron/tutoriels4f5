package tp02.messages.transmettre_coup;

import ntro.debogage.J;
import ntro.messages.Message;

public class TransmettreCoup extends Message<TransmettreCoupPourEnvoi, 
                                             TransmettreCoupRecu>

					         implements TransmettreCoupPourEnvoi, 
					                    TransmettreCoupRecu {
	
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
