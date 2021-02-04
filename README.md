# Fichiers adaptés pour meld

1. L'outil [meld](https://meldmerge.org/) fait des diff graphique et récursif:

        $ meld tut02 tut03

    * NOTE: 
        * version [MacOS](https://github.com/yousseb/meld/releases/) de meld
        * il y sûrement d'autres outils pour Mac qui font pareil (?)

## De `tut01` à `tut02`

Pas de changements

## De `tut02` à `tut03`

Ajout des modèles:

* paquet `enumerations`
* pour la page paramètre:
    * `Parametres.java`
    * `ParametresLectureSeule.java`
* pour la page partie:
    * paquet `pages.partie.modeles`, p.ex.
        * `Jeton.java`
        * `JetonLectureSeule.java`

Note:

* chaque modèle a une version `LectureSeule` qui
  permet seulement les accesseurs (*getters*)
* la méthodologie force les étudiants à utiliser 
  la version `LectureSeule` pour l'affichage
    * pour clarifier que lors de l'affichage, ce
    n'est pas le temps de modifier le modèle
  








