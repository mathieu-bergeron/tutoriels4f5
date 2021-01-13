package demo.commandes.choisir_taille_grille;

import demo.enumerations.TailleGrille;
import ntro.client.commandes.Commande;
import ntro.debogage.J;

public class ChoisirTailleGrille extends Commande<ChoisirTailleGrillePourEnvoi, ChoisirTailleGrilleRecue> 
						   implements ChoisirTailleGrillePourEnvoi, ChoisirTailleGrilleRecue {
	
	private TailleGrille tailleGrille;

	@Override
	public TailleGrille getTailleGrille() {
		J.appel(this);
		
		return tailleGrille;
	}

	@Override
	public void setTailleGrille(TailleGrille taille) {
		J.appel(this);
		
		this.tailleGrille = taille;
	}
	

}
