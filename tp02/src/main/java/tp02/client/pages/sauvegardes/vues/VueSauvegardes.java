package tp02.client.pages.sauvegardes.vues;

import ntro.client.mvc.Vue;
import tp02.client.pages.sauvegardes.modeles.UneSauvegardeLectureSeule;

public interface VueSauvegardes extends Vue {
	
	void viderLesSauvegardes();
	void ajouterSauvegarde(UneSauvegardeLectureSeule laSauvegarde);
	
	void cacherRechercheEnCours();
}
