package demo.messages.transmettre_taille;

import demo.pages.commun.enumerations.TailleGrille;
import ntro.debogage.J;
import ntro.messages.Message;

public class MsgTransmettreTaille extends Message<MsgTransmettreTaillePourEnvoi, 
                                             MsgTransmettreTailleRecu>

					         implements MsgTransmettreTaillePourEnvoi, 
					                    MsgTransmettreTailleRecu {
	
	private TailleGrille tailleGrille;

	@Override
	public TailleGrille getTailleGrille() {
		J.appel(this);

		return tailleGrille;
	}

	@Override
	public void setTailleGrille(TailleGrille tailleGrille) {
		J.appel(this);
		
		this.tailleGrille = tailleGrille;
	}
}
