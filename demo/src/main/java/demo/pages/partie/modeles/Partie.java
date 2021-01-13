package demo.pages.partie.modeles;


import ntro.debogage.J;
import ntro.modeles.Modele;
import demo.client.Constantes;
import demo.pages.commun.enumerations.Couleur;

public class      Partie<PLS extends PartieLectureSeule> 
       extends    Modele<PLS>
       implements PartieLectureSeule {

	protected transient int largeur;
	protected int hauteur;
	
	protected Couleur couleurCourante;

	protected Grille grille;

	private transient Jeton dernierJetonAjoute;
	
	@Override
	public void apresCreation() {
		largeur =  Constantes.LARGEUR_GRILLE_PAR_DEFAUT;
		hauteur = Constantes.HAUTEUR_GRILLE_PAR_DEFAUT;
		couleurCourante = Couleur.ROUGE;

		initialiserGrille();
	}

	private void initialiserGrille() {
		J.appel(this);

		grille = new Grille();
		grille.apresCreation(largeur);
	}

	@Override
	public void apresChargementJson() {
		J.appel(this);
		
		largeur = grille.getColonnes().size();
		grille.apresChargementJson();
	}
	
	
    public void jouerIci(int indiceColonne){
        J.appel(this);

        effectuerCoup(indiceColonne);
    }

    public void effectuerCoup(int indiceColonne) {
        J.appel(this);

        dernierJetonAjoute = grille.ajouterJeton(indiceColonne, couleurCourante);
        prochaineCouleur();
    }

    private void prochaineCouleur() {
        J.appel(this);

        switch(couleurCourante) {

        case ROUGE:
        	couleurCourante = Couleur.JAUNE;
            break;
        case JAUNE:
        	couleurCourante = Couleur.ROUGE;
            break;
        }
    }

	public int getLargeur() {
		J.appel(this);
		return largeur;
	}

	public void setLargeur(int largeur) {
		J.appel(this);
		this.largeur = largeur;

		initialiserGrille();
	}

	public int getHauteur() {
		J.appel(this);
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		J.appel(this);
		this.hauteur = hauteur;
		
		initialiserGrille();
	}

	public Couleur getCouleurCourante() {
		J.appel(this);
		return couleurCourante;
	}

	public void setCouleurCourante(Couleur couleurCourante) {
		J.appel(this);
		this.couleurCourante = couleurCourante;
	}

	public GrilleLectureSeule getGrille() {
		J.appel(this);
		return (GrilleLectureSeule) grille;
	}

	public void setGrille(Grille grille) {
		J.appel(this);
		this.grille = grille;
	}

	@Override
	public JetonLectureSeule getDernierJetonAjoute() {
		J.appel(this);

		return dernierJetonAjoute;
	}

	public boolean siPossibleJouerIci(int indiceColonne) {
		J.appel(this);

		return grille.siPossibleJouerIci(indiceColonne, hauteur);
	}
}
