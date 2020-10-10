# DM Final à rendre pour le 18 décembre 2020 au plus tard
L'objectif de ce projet est de faire un petit jeu d'aventure à la "Zelda". Plus exactement, 
vous allez faire un donjon dans lequel vous dirigerez un personnage qui devra arriver à la fin du dit donjon après avoir atteint certains objectifs.

## Concernant le comportement global du jeu:

<p>
Vous ne pourrez voir que la salle courante, et changerez de salle lorsque le héro passera par une porte ou une zone de changement de salle.
Une salle pourra être composée de 14*9 tiles par exemple.
</p>
<p>
Un ensemble de sprites, de tiles, de sons et de musiques vous est mis à disposition juste en dessous de cet énoncé sur la page principale du cours. Vous pouvez les redimensionner à votre guise (par exemple batch sous irfanview) ou simplement les charger en pleine résolution et changer l'affichage du jeu.
Vous pouvez en utiliser d'autres à votre convenance tant qu'ils sont "libres de droits".
</p>
<p>
Le jeu est solo, donc vous n'avez pas de connexion à un serveur à gérer.
</p>
<p>
Il y aura un écran d'accueil, une phase de jeu en donjon, un écran de distribution de points pour le joueur, un écran de mort et un écran de victoire.
</p>
<p>
Il y aura 4 niveaux de difficulté avec des statistiques et ia différentes en conséquence pour les monstres.
</p>
<p>
A chaque mort du héro, il pourra choisir de continuer ou non. Pour débloquer le mode de difficulté supérieur, il devra avoir réussi à finir le donjon sans utiliser de "Continue".
</p>
<p>
A chaque coup porté, les points de dégâts doivent apparaître pendant quelques instants puis disparaître.
</p>
<p>
Tous les monstres et le joueur devront avoir des animations lors de leurs déplacements.
</p>
<p>
Le niveau de difficulté ainsi que les statistiques actuels doivent être sauvegardés dans un fichier texte en clair.
</p>


## L'écran de victoire:

<p>
Lorsque le joueur a tué le boss final, un écran de fin apparaît avec des remerciements pour avoir joué au jeu, et votre nom/prénom/mail/année de formation à l'upf.
</p>
<p>
Si la victoire a été atteinte sans utiliser de "Continue", un message apparaît indiquant qu'un niveau de difficulté supérieur a été débloqué (3 au total=> 0 1 2 et 3) et un bouton vous ramène à l'écran d'accueil avec le choix de difficulté fixé à celle qui vient de se débloquer. S'il s'agissait du niveau max de votre jeu, proposez au joueur de vous écrire pour vous faire part de ses impressions.
</p>

## L'écran de mort:

<p>
Si le joueur est mort, 2 options s'offrent à lui : recommencer la partie à zéro au niveau de difficulté actuel ou reprendre là où il est mort mais sachant que la victoire finale ne le fera pas accéder au niveau de difficulté suivant.
</p>

## L'écran d'accueil:

- doit accueillir le joueur 
- doit permettre au joueur de lancer une partie
- doit permettre au joueur de choisir entre l'archer et l'épéiste qui auront des statistiques différentes (par exemple l'épéiste pourrait avoir plus d'ATK, de DEF et d'HP que l'archer mais ne tapera qu'au corps à corps tandis que l'archer pourra toucher un ennemi depuis l'autre bout de la salle, le perso à la hache encore plus d'ATK et moins de HP... à vous de choisir)
- doit permettre au joueur de choisir le niveau de difficulté qu'il souhaite pour sa partie si des niveaux sont débloqués, puis démarrer le jeu. 
- Une parti lancée fait commencer le joueur dans la première salle qui doit être vide (pas de monstres).  

## Le personnage du joueur ainsi que tous les monstres:

devront avoir 3 statistiques : HP ATK DEF
- HP correspond aux points de vie 
- ATK correspond à l'attaque flat
- DEF correspond à la défense
- une attaque baisse les HP de la cible du nombre de points d'ATK de l'assaillant moins la DEF de la cible si l'attaque touche

A vous de déterminer un bon ratio pour ces 3 valeurs pour les 4 modes de difficulté


## Le personnage devra:

- avoir ses HP représentés par exemple par des cœurs ou une barre en haut à gauche de l'écran de jeu et/ou au-dessus d'eux.
- pouvoir se déplacer dans les 4 directions cardinales en utilisant a z e s comme sur tous les jeux classiques.
- pouvoir utiliser son arme avec espace (arc épée ou bâton de sort par exemple).
- pouvoir recommencer la partie là où il en était ou au début et tout recommencer à zéro au choix du joueur.
- avoir une animation à sa mort.

A chaque accès à un niveau de difficulté supérieur, le joueur devra avoir des points à répartir dans ses 3 statistiques.

## L'écran de distribution de points pour le joueur:

- devra permettre au joueur de distribuer des points dans ses statistiques.
- sera accessible à chaque nouvel accès à un nouveau niveau de difficulté.

## Les monstres devront:

- avoir leurs HP représentés par exemple avec une barre au dessus d'eux.
- avoir leur propre ia pour attaquer le joueur. 2 monstres d'un même type dans 2 salles différentes auront forcément la même ia.
- exploser rapidement puis disparaître à leur mort.

## Le donjon en lui-même:

Vous pouvez vous inspirer de donjons de jeux comme les Zelda 5 exemples ci-dessous). L'idée principale est d'avoir plusieurs salles avant d'accéder au boss. <br />
La première salle est forcément vide.<br />
Le minimum demandé est de faire 5 salles différentes.<br />
Vous pouvez ajouter des mécaniques comme des chemins alternatifs permettant de looter des clés en tuant soit un monstre particulier soit tous les monstres d'une salle particulière, cette clé permettant d'accéder à une autre salle. Vous pouvez aussi faire des mini labyrinthes ou encore des chemins à suivre entourés de lave ou d'eau mortels, ou des objets indestructibles mobiles avec pattern prédéfini qui font perdre des HP.<br />
Voici 2 exemples de donjons de Zelda:

[Cartes - Solution de The Legend of Zelda (Quêtes annexes) - Puissance-Zelda](https://www.puissance-zelda.com/1-The_Legend_of_Zelda/solution/359-Cartes)


Modifié le: jeudi 8 octobre 2020, 11:39