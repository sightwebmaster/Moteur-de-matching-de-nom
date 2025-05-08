# 🔍 Outil CLI de Recherche, Déduplication et Comparaison de Noms

## 👤 Auteur
**Mohamed Ramzi Haddad**  
Classe : 1AINFO  
École : École Nationale d'Ingénieurs de Tunis  
Module : Mini Projet de Programmation Orientée Objets  
Date : 09/04/2025  

---

## 🎯 Objectif

Ce projet consiste à développer une **application en ligne de commande (CLI)** capable de traiter des fichiers CSV contenant des noms complets. L'outil offre trois fonctionnalités principales :

1. 🔎 Recherche d’un nom dans une liste
2. 🆚 Comparaison de deux listes pour identifier les correspondances
3. ♻️ Déduplication d’une liste

Chaque fonctionnalité repose sur une **configuration modulaire** combinant :

- Un prétraitement
- Une structure d’indexation
- Une mesure de comparaison
- Un seuil ou un nombre de résultats à retourner

---

## ⚙ Fonctionnement Général

1. L'utilisateur choisit l'opération à effectuer via un **menu interactif**.
2. Il fournit les chemins des fichiers CSV nécessaires.
3. Le système applique la configuration actuelle (modifiable ou par défaut).

---

## 🔧 Configuration

La configuration peut être personnalisée via le menu et comprend :

- **Prétraitement** : minuscule, suppression des accents, encodage phonétique (Soundex, Metaphone…)
- **Indexation** : dictionnaire, trie, arbre...
- **Mesure de comparaison** : distance de Levenshtein, Jaro-Winkler, égalité exacte...
- **Résultat** : seuil de similarité ou nombre maximal de résultats

**Note :**
- Une valeur est acceptée si elle est ≥ seuil (pour similarité) ou ≤ seuil (pour distance).
- Chaque paramètre doit proposer 2 à 3 variantes, via **polymorphisme**.
- Des **valeurs par défaut** sont toujours disponibles.

---

## 📋 Fonctionnalités

### 1. Recherche d’un nom
- L’utilisateur saisit un nom complet et un fichier CSV.
- L’outil affiche les correspondances selon la configuration.

### 2. Comparaison de deux listes
- L’utilisateur fournit deux fichiers CSV.
- L’outil affiche les paires de noms jugées similaires.

### 3. Déduplication
- L’utilisateur fournit un fichier CSV.
- L’outil détecte les doublons internes à la liste.

### 4. Configuration
- Choisir un prétraitement
- Sélectionner une structure d’index
- Définir une mesure de comparaison
- Ajuster seuil ou nombre de résultats

---

## 🧭 Exemple de Menu

1. Effectuer une recherche
 Saisir le nom à rechercher
 Fournir le fichier CSV
2. Comparer deux listes
 Fournir le premier fichier
 Fournir le second fichier
3. Dédupliquer une liste
 Fournir le fichier à traiter
4. Configurer les paramètres
 1 Choisir les prétraitements
 2 Choisir une structure d'index
 3 Choisir une mesure de comparaison
 4 Définir le seuil ou nombre de résultats
5. Quitter


---

## 🧪 Exigences Techniques

- Interface CLI simple et claire
- Architecture orientée objet (encapsulation, héritage, polymorphisme)
- Code modulaire, extensible et bien commenté
- Bonnes performances sur fichiers de taille moyenne à grande
- Utilisation de **GitHub** durant tout le développement (avec l'email ENIT)
- Gestion automatique des valeurs par défaut
- (Bonus) Tests unitaires pour valider les fonctionnalités

---

## 🏅 Critères d’Évaluation

1. **Modélisation** : Structuration correcte des classes et relations
2. **Extensibilité** : Facilité à ajouter de nouvelles fonctionnalités
3. **Polymorphisme** :
   - Structures de données
   - Encodeurs (bonus)
   - Mesures de similarité
4. **Bonne pratique POO** : interfaces, classes abstraites, code propre
5. **Analyse des résultats** : performance, qualité de détection, complexité
6. **Développement** : gestion GitHub, suivi, tests

---


