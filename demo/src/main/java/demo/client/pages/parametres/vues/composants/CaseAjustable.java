package demo.client.pages.parametres.vues.composants;


import java.util.ArrayList;
import java.util.List;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import ntro.client.commandes.FabriqueCommande;
import ntro.debogage.J;
import ntro.javafx.vues.composants.CanvasAjustable;
import demo.client.commandes.jouer_ici.JouerIci;
import demo.client.commandes.jouer_ici.JouerIciPourEnvoi;
import demo.client.pages.parametres.modeles.Marque;
import demo.client.pages.parametres.vues.Bordure;

public class CaseAjustable extends CanvasAjustable {
    
    private final double TAILLE_POURCENTAGE = 0.6;
    
    private Marque marque;
    
    private JouerIciPourEnvoi jouerIci;
    
    private List<Bordure> bordures = new ArrayList<>();

    public CaseAjustable() {
        super();
        J.appel(this);
        
        initialiserPinceau();
    }

    public void afficherMarque(Marque marque) {
        J.appel(this);
        
        this.marque = marque;
        
        viderDessin();
        
        afficherBordures();

        dessinerMarque(marque);
    }

    @Override
    protected void reagirLargeurInitiale(double largeurInitiale) {
        J.appel(this);
        
		afficherBordures();

        if(marque != null) {

        	dessinerMarque(this.marque);
        }
    }

    @Override
    protected void reagirHauteurInitiale(double hauteurInitiale) {
        J.appel(this);

		afficherBordures();

        if(marque != null) {
        	
        	dessinerMarque(this.marque);
        }
    }

    @Override
    protected void reagirNouvelleLargeur(double ancienneLargeur, double nouvelleLargeur) {
        J.appel(this);

		viderDessin();
		afficherBordures();

        if(marque != null) {
        	
        	dessinerMarque(this.marque);
        }
    }

    @Override
    protected void reagirNouvelleHauteur(double ancienneHauteur, double nouvelleHauteur) {
        J.appel(this);

		viderDessin();
		afficherBordures();

        if(marque != null) {

        	dessinerMarque(this.marque);
        }
    }

    private void initialiserPinceau() {
        J.appel(this);

        pinceau.setFill(Color.WHITE);
        pinceau.setStroke(Color.BLACK);
        pinceau.setLineWidth(0.01*getWidth());
    }
    
    private void viderDessin() {
        J.appel(this);

        pinceau.clearRect(0, 0, getWidth(), getHeight());
    }
    
    private void dessinerMarque(Marque marque) {
        J.appel(this);
        
        dessinerMarque(TAILLE_POURCENTAGE, marque);
    }

    private class Case {
        public double caseHautGaucheX;
        public double caseHautGaucheY;
        public double tailleCase;
    }
    
    private void dessinerMarque(double taillePourcentage, Marque marque) {
        J.appel(this);
        
        Case laCase = calculerCase(taillePourcentage);
        
        switch(marque) {
        
        case X:
        	dessinerX(laCase);
        	break;

        case O:
        	dessinerO(laCase);
        	break;
        }
    }

    private void dessinerX(Case laCase) {
        J.appel(this);
        
        pinceau.strokeLine(laCase.caseHautGaucheX,
        				   laCase.caseHautGaucheY, 
        				   laCase.caseHautGaucheX + laCase.tailleCase, 
        				   laCase.caseHautGaucheY + laCase.tailleCase);

        pinceau.strokeLine(laCase.caseHautGaucheX + laCase.tailleCase,
        				   laCase.caseHautGaucheY, 
        				   laCase.caseHautGaucheX, 
        				   laCase.caseHautGaucheY + laCase.tailleCase);

    }

    private void dessinerO(Case laCase) {
        J.appel(this);

        pinceau.strokeArc(laCase.caseHautGaucheX, 
                          laCase.caseHautGaucheY, 
                          laCase.tailleCase, 
                          laCase.tailleCase, 
                          0, 
                          360, 
                          ArcType.OPEN);
    }

    private Case calculerCase(double taillePourcentage) {
        J.appel(this);
        
        Case laCase = new Case();

        double largeurDessin = getWidth();
        double hauteurDessin = getHeight();
        
        laCase.tailleCase = largeurDessin * taillePourcentage;

        if(hauteurDessin < largeurDessin) {
            laCase.tailleCase = hauteurDessin * taillePourcentage;
        }
        
        laCase.caseHautGaucheX = (largeurDessin - laCase.tailleCase) / 2;
        laCase.caseHautGaucheY = (hauteurDessin - laCase.tailleCase) / 2;
        
        return laCase;
    }

	public void obtenirCommandePourEnvoi(int indiceColonne, int indiceRangee) {
		J.appel(this);
		
		jouerIci = FabriqueCommande.obtenirCommandePourEnvoi(JouerIci.class);
		
		jouerIci.setIndiceColonne(indiceColonne);
	}

	public void installerCapteurUsager() {
		J.appel(this);
		
		this.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				J.appel(this);

				jouerIci.envoyerCommande();
			}
		});
	}

	public void ajouterBordures(List<Bordure> bordures) {
		J.appel(this);
		
		this.bordures = bordures;
		afficherBordures();
	}


	private void afficherBordures() {
		J.appel(this);
		
		for(Bordure bordure : this.bordures) {
			
			J.valeurs(bordure.name());
			
			switch(bordure) {
			
			case GAUCHE:
				pinceau.strokeLine(0, 0, 0, getHeight());
				break;

			case DROITE:
				pinceau.strokeLine(getWidth(), 0, getWidth(), getHeight());
				break;

			case HAUT:
				pinceau.strokeLine(0, 0, getWidth(), 0);
				break;

			case BAS:
				pinceau.strokeLine(0, getHeight(), getWidth(), getHeight());
				break;
			}
			
			
		}
	}
}
