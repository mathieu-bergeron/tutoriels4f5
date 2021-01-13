package demo.commandes.nouvelle_partie;

import ntro.client.commandes.Commande;

public class NouvellePartieLocale extends Commande<NouvellePartieLocalePourEnvoi, 
                                             NouvellePartieLocaleRecue>

							implements NouvellePartieLocalePourEnvoi, 
							           NouvellePartieLocaleRecue {
}
