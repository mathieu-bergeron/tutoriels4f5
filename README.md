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

## De `tut03` à `tut04`

Ajout de l'affichage, p.ex. pour les paramètres:

* `ControleurParametres.java`
    * ne fait rien pour l'instant
* `AfficheurParametres.java`
    * rafraîchit l'affichage à partir d'un modèle lecture seule
* `VueParametres.java`
    * Le contrôleur FXML pour la vue `resources/parametres/structure.xml`
    * Les contrôles FXML sont stoqués dans des attributs (par JavaFX)
    * Pour l'instant on affiche seulement

## De `tut04` à `tut05`

Ajout des commandes, p.ex. `commandes/choisir_qui_commence`

* `ChoisirQuiCommence.java`: la commande comme telle
* `ChoisirQuiCommencePourEnvoi.java`
* `ChoisirQuiCommenceRecue.java`

Les versions `PourEnvoi` et `Recue` force les étudiants à modifié la commande au moment de l'envoi et retirer les données au moment de la réception.

Pour envoyer une commande, p.ex.:

* `VueParemetres.java` ligne 113
    * il faut obtenir la commande via le `FabriqueDeCommandes`

Pour recevoir une commande, p.ex.:

* `ControleurParametres` ligne 44


NOTE:

* En utilisant `RecepteurCommandeMVC`, l'afficheur est appelé automatiquement après la réception de la commande (pour ainsi rafraîchir l'affichage)


## De `tut05` à `tut06`

Ajout de la page `Acceuil` avec le menu

NOTE:

* `ControleurAccueil` est un `ControleurVue`: il n'y a pas de modèle

## De `tut06` à `tut07`

Ajout du serveur:

* Le serveur ne fait que retransmettre les messages aux clients connectés

Ajout des messages, p.ex. `messages/transmettre_coup`

* Comme pour les commandes on a trois fichiers:
    * `MsgTransmettreCoup.java`
    * `MsgTransmettreCoupPourEnvoi.java`
    * `MsgTransmettreCoupRecu.java`

* Comme pour les commandes, on obtien un message via la `FabriqueMessage`
    * p.ex. `ControleurParametres.java` ligne 64


    

        
  








