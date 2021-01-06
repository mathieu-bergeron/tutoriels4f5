package tp02.client.commandes.quitter;

import ntro.client.commandes.Commande;

public class Quitter extends Commande<QuitterPourEnvoi, 
                                      QuitterRecue> 

					 implements QuitterPourEnvoi,
					            QuitterRecue {
}
