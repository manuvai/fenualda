# DM Final � rendre pour le 18 d�cembre 2020 au plus tard
L'objectif de ce projet est de faire un petit jeu d'aventure � la "Zelda". Plus exactement, 
vous allez faire un donjon dans lequel vous dirigerez un personnage qui devra arriver � la fin du dit donjon apr�s avoir atteint certains objectifs.

## Concernant le comportement global du jeu:

<p>
Vous ne pourrez voir que la salle courante, et changerez de salle lorsque le h�ro passera par une porte ou une zone de changement de salle.
Une salle pourra �tre compos�e de 14*9 tiles par exemple.
</p>
<p>
Un ensemble de sprites, de tiles, de sons et de musiques vous est mis � disposition juste en dessous de cet �nonc� sur la page principale du cours. Vous pouvez les redimensionner � votre guise (par exemple batch sous irfanview) ou simplement les charger en pleine r�solution et changer l'affichage du jeu.
Vous pouvez en utiliser d'autres � votre convenance tant qu'ils sont "libres de droits".
</p>
<p>
Le jeu est solo, donc vous n'avez pas de connexion � un serveur � g�rer.
</p>
<p>
Il y aura un �cran d'accueil, une phase de jeu en donjon, un �cran de distribution de points pour le joueur, un �cran de mort et un �cran de victoire.
</p>
<p>
Il y aura 4 niveaux de difficult� avec des statistiques et ia diff�rentes en cons�quence pour les monstres.
</p>
<p>
A chaque mort du h�ro, il pourra choisir de continuer ou non. Pour d�bloquer le mode de difficult� sup�rieur, il devra avoir r�ussi � finir le donjon sans utiliser de "Continue".
</p>
<p>
A chaque coup port�, les points de d�g�ts doivent appara�tre pendant quelques instants puis dispara�tre.
</p>
<p>
Tous les monstres et le joueur devront avoir des animations lors de leurs d�placements.
</p>
<p>
Le niveau de difficult� ainsi que les statistiques actuels doivent �tre sauvegard�s dans un fichier texte en clair.
</p>


## L'�cran de victoire:

<p>
Lorsque le joueur a tu� le boss final, un �cran de fin appara�t avec des remerciements pour avoir jou� au jeu, et votre nom/pr�nom/mail/ann�e de formation � l'upf.
</p>
<p>
Si la victoire a �t� atteinte sans utiliser de "Continue", un message appara�t indiquant qu'un niveau de difficult� sup�rieur a �t� d�bloqu� (3 au total=> 0 1 2 et 3) et un bouton vous ram�ne � l'�cran d'accueil avec le choix de difficult� fix� � celle qui vient de se d�bloquer. S'il s'agissait du niveau max de votre jeu, proposez au joueur de vous �crire pour vous faire part de ses impressions.
</p>

## L'�cran de mort:

<p>
Si le joueur est mort, 2 options s'offrent � lui : recommencer la partie � z�ro au niveau de difficult� actuel ou reprendre l� o� il est mort mais sachant que la victoire finale ne le fera pas acc�der au niveau de difficult� suivant.
</p>

## L'�cran d'accueil:

- doit accueillir le joueur 
- doit permettre au joueur de lancer une partie
- doit permettre au joueur de choisir entre l'archer et l'�p�iste qui auront des statistiques diff�rentes (par exemple l'�p�iste pourrait avoir plus d'ATK, de DEF et d'HP que l'archer mais ne tapera qu'au corps � corps tandis que l'archer pourra toucher un ennemi depuis l'autre bout de la salle, le perso � la hache encore plus d'ATK et moins de HP... � vous de choisir)
- doit permettre au joueur de choisir le niveau de difficult� qu'il souhaite pour sa partie si des niveaux sont d�bloqu�s, puis d�marrer le jeu. 
- Une parti lanc�e fait commencer le joueur dans la premi�re salle qui doit �tre vide (pas de monstres).  

## Le personnage du joueur ainsi que tous les monstres:

devront avoir 3 statistiques : HP ATK DEF
- HP correspond aux points de vie 
- ATK correspond � l'attaque flat
- DEF correspond � la d�fense
- une attaque baisse les HP de la cible du nombre de points d'ATK de l'assaillant moins la DEF de la cible si l'attaque touche

A vous de d�terminer un bon ratio pour ces 3 valeurs pour les 4 modes de difficult�


## Le personnage devra:

- avoir ses HP repr�sent�s par exemple par des c�urs ou une barre en haut � gauche de l'�cran de jeu et/ou au-dessus d'eux.
- pouvoir se d�placer dans les 4 directions cardinales en utilisant a z e s comme sur tous les jeux classiques.
- pouvoir utiliser son arme avec espace (arc �p�e ou b�ton de sort par exemple).
- pouvoir recommencer la partie l� o� il en �tait ou au d�but et tout recommencer � z�ro au choix du joueur.
- avoir une animation � sa mort.

A chaque acc�s � un niveau de difficult� sup�rieur, le joueur devra avoir des points � r�partir dans ses 3 statistiques.

## L'�cran de distribution de points pour le joueur:

- devra permettre au joueur de distribuer des points dans ses statistiques.
- sera accessible � chaque nouvel acc�s � un nouveau niveau de difficult�.

## Les monstres devront:

- avoir leurs HP repr�sent�s par exemple avec une barre au dessus d'eux.
- avoir leur propre ia pour attaquer le joueur. 2 monstres d'un m�me type dans 2 salles diff�rentes auront forc�ment la m�me ia.
- exploser rapidement puis dispara�tre � leur mort.

## Le donjon en lui-m�me:

Vous pouvez vous inspirer de donjons de jeux comme les Zelda 5 exemples ci-dessous). L'id�e principale est d'avoir plusieurs salles avant d'acc�der au boss. <br />
La premi�re salle est forc�ment vide.<br />
Le minimum demand� est de faire 5 salles diff�rentes.<br />
Vous pouvez ajouter des m�caniques comme des chemins alternatifs permettant de looter des cl�s en tuant soit un monstre particulier soit tous les monstres d'une salle particuli�re, cette cl� permettant d'acc�der � une autre salle. Vous pouvez aussi faire des mini labyrinthes ou encore des chemins � suivre entour�s de lave ou d'eau mortels, ou des objets indestructibles mobiles avec pattern pr�d�fini qui font perdre des HP.<br />
Voici 2 exemples de donjons de Zelda:

[Cartes - Solution de The Legend of Zelda (Qu�tes annexes) - Puissance-Zelda](https://www.puissance-zelda.com/1-The_Legend_of_Zelda/solution/359-Cartes)


Modifi� le: jeudi 8 octobre 2020, 11:39