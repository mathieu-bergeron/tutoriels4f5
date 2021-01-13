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


package demo.pages.partie.modeles;

import java.util.Random;

import ntro.debogage.J;

public class      PartieLocale 
       extends    Partie<PartieLocaleLectureSeule> 
       implements PartieLocaleLectureSeule { 
	
	public PartieLocale() {
		super();
		J.appel(this);
		
		 largeur =  3 + (new Random().nextInt(5));
		 hauteur = 4 + (new Random().nextInt(8));
	}
	
	public boolean siInitialisee() {
		J.appel(this);

		return largeur > 0 && 
			   hauteur > 0 && 
			   couleurCourante != null &&
			   grille != null;
	}
	
}
