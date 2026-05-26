# NavigationDrawerDemo – LAB 10

Application Android démontrant l’utilisation d’un **Navigation Drawer** avec plusieurs **Fragments** affichés dynamiquement dans une seule activité principale.

L’application propose une interface personnalisée avec des couleurs dégradées, des cartes arrondies, des icônes vectorielles, une barre supérieure stylisée et une liste interactive.

## Objectif:

Le but de ce laboratoire est de :

- Comprendre le fonctionnement du modèle **Navigation Drawer Activity**
- Manipuler un menu latéral avec `DrawerLayout` et `NavigationView`
- Afficher plusieurs fragments dans une seule activité
- Utiliser `FragmentManager` pour remplacer dynamiquement le contenu affiché
- Créer un `ListFragment` avec un `ArrayAdapter`
- Personnaliser l’interface avec XML, drawables et icônes vectorielles
- Structurer une application Android de manière modulaire

## Description de l’application:

L’application contient une seule activité principale :

- `MainActivity.java`

Cette activité contient :

- Une `Toolbar` personnalisée
- Un bouton menu permettant d’ouvrir le Navigation Drawer
- Un menu latéral contenant trois choix
- Un conteneur central `FrameLayout`
- Plusieurs fragments affichés dynamiquement selon le choix de l’utilisateur

Les trois écrans principaux sont :

### Accueil Aurora

- Premier fragment affiché automatiquement au lancement
- Fond en dégradé violet/rose
- Carte centrale semi-transparente
- Texte descriptif centré

### Espace Océan

- Deuxième fragment de l’application
- Fond en dégradé bleu/cyan
- Carte centrale personnalisée
- Changement dynamique depuis le menu latéral

### Palette List

- Fragment de type `ListFragment`
- Liste des notions importantes du laboratoire
- Items stylisés sous forme de cartes
- Affichage d’un `Toast` lorsqu’un élément est sélectionné

## Fonctionnalités:

- Navigation via un menu latéral
- Affichage automatique du premier fragment au démarrage
- Changement dynamique de fragment au clic sur un élément du Drawer
- Fermeture automatique du Drawer après sélection
- Gestion du bouton retour
- Liste interactive avec `ArrayAdapter`
- Affichage d’un message `Toast` lors du clic sur un élément de la liste
- Interface moderne avec :
  - Dégradés de fond
  - Cartes arrondies
  - Toolbar personnalisée
  - Icônes vectorielles
  - Items de liste stylisés

## Technologies utilisées:

- Android Studio
- Java
- XML
- AndroidX
- AppCompat
- Material Components
- API minimum : 24 (Android 7.0)

## Aperçu de l’application:

▶️ Une démonstration vidéo complète est disponible dans le dossier **Demo** du repository.

⚠️ En cas de problème de lecture :

👉 [▶️ Voir la démo sur Google Drive](https://drive.google.com/file/d/1CDmyhi3fO6_5H064nVt387h7bfXMUylJ/view?usp=sharing)

## Structure du projet:

### Layouts `res/layout`:

#### `activity_main.xml`

Layout principal de l’application.

Il contient :

- `DrawerLayout`
- `Toolbar` personnalisée
- `NavigationView`
- Inclusion du fichier `content_main.xml`

Ce fichier organise la structure générale de l’application avec le menu latéral et la zone d’affichage des fragments.

#### `content_main.xml`

Contient le conteneur principal :

```xml
<FrameLayout
    android:id="@+id/fragment_stage"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```

Ce `FrameLayout` permet d’afficher dynamiquement les fragments sélectionnés depuis le menu latéral.

#### `fragment_aurora.xml`

Layout du premier fragment.

Il contient :

- Un fond en dégradé violet/rose
- Une carte centrale arrondie
- Un titre
- Une courte description

Ce fragment représente l’écran d’accueil de l’application.

#### `fragment_ocean.xml`

Layout du deuxième fragment.

Il contient :

- Un fond en dégradé bleu/cyan
- Une carte centrale arrondie
- Un titre
- Une description

Ce fragment permet de montrer le remplacement dynamique d’un fragment par un autre.

#### `fragment_palette_list.xml`

Layout du fragment contenant la liste.

Il contient :

- Un titre centré
- Une description
- Une `ListView`

Cette liste affiche plusieurs notions importantes liées au laboratoire.

#### `row_palette_item.xml`

Layout personnalisé pour chaque élément de la liste.

Il contient :

- Un `TextView`
- Une carte arrondie
- Un texte centré
- Un style propre pour les items

## Menu de navigation:

### `res/menu/activity_main_drawer.xml`

Ce fichier définit les éléments affichés dans le Navigation Drawer.

Le menu contient trois entrées :

- Accueil Aurora
- Espace Océan
- Palette List

Chaque élément possède :

- Un identifiant
- Une icône vectorielle
- Un titre affiché dans le Drawer

## Classes Java:

### `MainActivity.java`

Classe principale de l’application.

Elle gère :

- L’initialisation de la `Toolbar`
- L’ouverture du Navigation Drawer
- La fermeture du Navigation Drawer
- Les clics sur les éléments du menu
- Les transactions de fragments
- Le changement du titre dans la barre supérieure
- Le comportement du bouton retour

Lorsqu’un élément du Drawer est sélectionné, `MainActivity` remplace le fragment actuellement affiché par le fragment correspondant.

### `AuroraFragment.java`

Fragment affiché automatiquement au lancement de l’application.

Il charge le layout :

```java
return inflater.inflate(R.layout.fragment_aurora, container, false);
```

Ce fragment représente l’écran d’accueil avec une interface colorée et personnalisée.

### `OceanFragment.java`

Deuxième fragment de l’application.

Il charge le layout :

```java
return inflater.inflate(R.layout.fragment_ocean, container, false);
```

Il montre que l’application peut changer d’écran sans lancer une nouvelle activité.

### `PaletteListFragment.java`

Fragment basé sur `ListFragment`.

Il contient :

- Un tableau de chaînes de caractères
- Un `ArrayAdapter`
- Une liste interactive
- Un `Toast` affiché lorsqu’un élément est sélectionné

Ce fragment permet de présenter une liste simple tout en gardant une structure modulaire.

## Design `res/drawable`:

### Backgrounds:

#### `bg_aurora.xml`

Dégradé violet/rose utilisé pour le fragment Aurora.

#### `bg_ocean.xml`

Dégradé bleu/cyan utilisé pour le fragment Océan.

#### `bg_glass_card.xml`

Carte semi-transparente avec coins arrondis utilisée dans les fragments.

#### `bg_list_item.xml`

Style personnalisé des éléments de la liste.

### Icônes vectorielles:

#### `ic_glow_home.xml`

Icône utilisée pour l’entrée **Accueil Aurora**.

#### `ic_ocean_wave.xml`

Icône utilisée pour l’entrée **Espace Océan**.

#### `ic_palette_list.xml`

Icône utilisée pour l’entrée **Palette List**.

## Principe de fonctionnement:

L’application repose sur une seule activité principale.

Le contenu affiché au centre de l’écran est remplacé dynamiquement selon l’élément choisi dans le menu latéral.

Le fonctionnement général est le suivant :

1. L’utilisateur ouvre le Navigation Drawer
2. Il sélectionne un élément du menu
3. `MainActivity` détecte l’élément sélectionné
4. Une transaction de fragment est lancée
5. Le fragment choisi remplace le fragment actuel dans le `FrameLayout`
6. Le Drawer se ferme automatiquement

Exemple de transaction utilisée :

```java
getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.fragment_stage, fragment)
        .commit();
```

## Résultat attendu:

Au lancement de l’application :

- Le fragment **Accueil Aurora** est affiché automatiquement

Lorsque l’utilisateur ouvre le Drawer :

- Il peut choisir entre les trois écrans disponibles

Lorsqu’il clique sur :

- **Accueil Aurora**  
  → le fragment Aurora est affiché

- **Espace Océan**  
  → le fragment Océan est affiché

- **Palette List**  
  → le fragment contenant la liste est affiché

Lorsqu’il clique sur un élément de la liste :

- Un `Toast` confirme l’élément sélectionné

## Démonstration:

Pendant la démonstration, les étapes suivantes sont montrées :

1. Lancement de l’application
2. Affichage automatique du fragment **Accueil Aurora**
3. Ouverture du Navigation Drawer
4. Navigation vers le fragment **Espace Océan**
5. Navigation vers le fragment **Palette List**
6. Clic sur un élément de la liste
7. Affichage d’un `Toast`
8. Retour au menu latéral

## Conclusion:

Ce laboratoire permet de comprendre les bases de la navigation modulaire sous Android.

Il montre comment utiliser :

- Une seule activité principale
- Un Navigation Drawer
- Plusieurs fragments indépendants
- Un `FragmentManager`
- Un `FrameLayout` comme conteneur dynamique
- Un `ListFragment` avec un adapter

Cette architecture est importante pour créer des applications Android plus propres, organisées et faciles à maintenir.

Grâce à la personnalisation de l’interface, l’application ne se limite pas à une démonstration fonctionnelle. Elle propose aussi un rendu moderne, coloré et agréable visuellement.
