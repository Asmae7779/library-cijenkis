package com.example.demo;

/**
 * Classe représentant un livre dans le système de gestion de bibliothèque.
 * Cette classe encapsule les informations d'un livre : titre, auteur, année de publication et ISBN.
 */
public class Livre {
    private String titre;
    private String auteur;
    private int anneePublication;
    private String isbn;

    /**
     * Constructeur par défaut
     */
    public Livre() {
    }

    /**
     * Constructeur avec paramètres
     * @param titre le titre du livre
     * @param auteur l'auteur du livre
     * @param anneePublication l'année de publication (doit être positive)
     * @param isbn l'ISBN du livre
     * @throws IllegalArgumentException si l'année de publication est négative
     */
    public Livre(String titre, String auteur, int anneePublication, String isbn) {
        if (anneePublication < 0) {
            throw new IllegalArgumentException("L'année de publication ne peut pas être négative");
        }
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.isbn = isbn;
    }

    // Getters
    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public String getIsbn() {
        return isbn;
    }

    // Setters
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setAnneePublication(int anneePublication) {
        if (anneePublication < 0) {
            throw new IllegalArgumentException("L'année de publication ne peut pas être négative");
        }
        this.anneePublication = anneePublication;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Vérifie l'égalité entre deux instances de Livre
     * Deux livres sont considérés égaux s'ils ont les mêmes attributs
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Livre livre = (Livre) obj;
        return anneePublication == livre.anneePublication &&
               (titre != null ? titre.equals(livre.titre) : livre.titre == null) &&
               (auteur != null ? auteur.equals(livre.auteur) : livre.auteur == null) &&
               (isbn != null ? isbn.equals(livre.isbn) : livre.isbn == null);
    }

    @Override
    public int hashCode() {
        int result = titre != null ? titre.hashCode() : 0;
        result = 31 * result + (auteur != null ? auteur.hashCode() : 0);
        result = 31 * result + anneePublication;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        return result;
    }

    /**
     * Détermine la catégorie d'âge du livre
     * Cette méthode sera partiellement couverte pour apparaître en jaune dans JaCoCo
     * @return la catégorie du livre (ANCIEN, MODERNE, RECENT, TRES_RECENT)
     */
    public String getCategorieAge() {
        if (anneePublication < 1900) {
            return "ANCIEN";
        } else if (anneePublication < 1950) {
            return "MODERNE";
        } else if (anneePublication < 2000) {
            return "RECENT";
        } else {
            return "TRES_RECENT";
        }
    }

    /**
     * Vérifie si le livre est disponible pour emprunt
     * Cette méthode a des branches non testées pour apparaître en jaune dans JaCoCo
     * @param nombreExemplaires le nombre d'exemplaires disponibles
     * @param nombreEmprunts le nombre d'exemplaires actuellement empruntés
     * @return true si le livre est disponible, false sinon
     */
    public boolean estDisponible(int nombreExemplaires, int nombreEmprunts) {
        if (nombreExemplaires <= 0) {
            return false;
        }
        if (nombreEmprunts < 0) {
            throw new IllegalArgumentException("Le nombre d'emprunts ne peut pas être négatif");
        }
        if (nombreEmprunts >= nombreExemplaires) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", anneePublication=" + anneePublication +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

