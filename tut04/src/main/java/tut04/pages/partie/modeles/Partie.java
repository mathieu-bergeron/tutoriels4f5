// Copyright (C) (2020) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)
//
// This file is part of tutoriels4f5
//
// tutoriels4f5 is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// tutoriels4f5 is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
//
// You should have received a copy of the GNU Affero General Public License
// along with aquiletour.  If not, see <https://www.gnu.org/licenses/>


package tut04.pages.partie.modeles;


import ntro.debogage.J;
import ntro.mvc.modeles.Modele;
import tut04.Constantes;
import tut04.enumerations.Couleur;

public class      Partie<PLS extends PartieLectureSeule> 
       extends    Modele<PLS>
       implements PartieLectureSeule {

	protected transient int largeur;
	protected int hauteur;
	
	protected Couleur couleurCourante;

	protected Grille grille;
	
	@Override
	public void apresCreation() {
		J.appel(this);

		largeur = Constantes.TAILLE_GRILLE_PAR_DEFAUT.getLargeur();
		hauteur = Constantes.TAILLE_GRILLE_PAR_DEFAUT.getHauteur();
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

        grille.ajouterJeton(indiceColonne, couleurCourante);
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

	public boolean siPossibleJouerIci(int indiceColonne) {
		J.appel(this);

		return grille.siPossibleJouerIci(indiceColonne, hauteur);
	}
}
