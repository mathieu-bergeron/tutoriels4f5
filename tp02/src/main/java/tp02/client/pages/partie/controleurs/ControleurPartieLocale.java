package tp02.client.pages.partie.controleurs;

import tp02.client.pages.partie.afficheurs.AfficheurPartieLocale;
import tp02.client.pages.partie.modeles.PartieLocale;
import tp02.client.pages.partie.modeles.PartieLocaleLectureSeule;
import tp02.client.pages.partie.vues.VuePartieLocale;

public abstract class ControleurPartieLocale<V extends VuePartieLocale, 
                                             A extends AfficheurPartieLocale<V>>

                extends ControleurPartie<PartieLocaleLectureSeule, 
                                         PartieLocale, 
                                         V, 
                                         A> {
	
}
