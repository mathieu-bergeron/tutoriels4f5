package demo.commandes.nouvelle_partie_reseau;

import ntro.client.commandes.Commande;

public class NouvellePartieReseau extends Commande<NouvellePartieReseauPourEnvoi, 
                                             NouvellePartieReseauRecue>

							implements NouvellePartieReseauPourEnvoi, 
							           NouvellePartieReseauRecue {
}
