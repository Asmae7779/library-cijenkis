package com.example.demo;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Tests JUnit 4 pour la classe Livre
 * 
 * Question 10: Si votre projet peut être utilisé avec différentes versions de JUnit, écrivez des tests 
 * pour vérifier la compatibilité avec JUnit 4 et JUnit 5.
 * 
 * Ce fichier démontre la compatibilité avec JUnit 4.
 */
public class LivreTestJUnit4 {

    private Livre livre;

    @Before
    public void setUp() {
        livre = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1943, "978-2070612758");
    }

    /**
     * Question 10: Test de compatibilité avec JUnit 4
     */
    @Test
    public void testCompatibiliteJUnit4() {
        // Arrange
        Livre livreJUnit4 = new Livre("JUnit 4 Test", "JUnit", 2014, "978-JUNIT4");

        // Act & Assert
        assertNotNull("L'instance devrait être créée avec JUnit 4", livreJUnit4);
        assertEquals("Le titre devrait être correct avec JUnit 4", "JUnit 4 Test", livreJUnit4.getTitre());
        assertEquals("L'auteur devrait être correct avec JUnit 4", "JUnit", livreJUnit4.getAuteur());
        assertEquals("L'année devrait être correcte avec JUnit 4", 2014, livreJUnit4.getAnneePublication());
        assertEquals("L'ISBN devrait être correct avec JUnit 4", "978-JUNIT4", livreJUnit4.getIsbn());
    }

    @Test
    public void testCreationInstanceJUnit4() {
        // Arrange & Act
        Livre nouveauLivre = new Livre("1984", "George Orwell", 1949, "978-0451524935");

        // Assert
        assertNotNull("L'instance ne devrait pas être null", nouveauLivre);
        assertEquals("Le titre devrait être '1984'", "1984", nouveauLivre.getTitre());
        assertEquals("L'auteur devrait être 'George Orwell'", "George Orwell", nouveauLivre.getAuteur());
        assertEquals("L'année devrait être 1949", 1949, nouveauLivre.getAnneePublication());
        assertEquals("L'ISBN devrait être '978-0451524935'", "978-0451524935", nouveauLivre.getIsbn());
    }

    @Test
    public void testValidationAnneeNegativeJUnit4() {
        // Act & Assert
        try {
            new Livre("Test", "Auteur", -100, "978-1234567890");
            fail("Une IllegalArgumentException devrait être levée pour une année négative");
        } catch (IllegalArgumentException e) {
            assertTrue("Le message d'erreur devrait mentionner 'négative'", 
                      e.getMessage().contains("négative"));
        }
    }

    @Test
    public void testEgaliteJUnit4() {
        // Arrange
        Livre livre1 = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1943, "978-2070612758");
        Livre livre2 = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1943, "978-2070612758");

        // Act & Assert
        assertEquals("Deux livres avec les mêmes attributs devraient être égaux", livre1, livre2);
        assertEquals("Deux livres égaux devraient avoir le même hashCode", livre1.hashCode(), livre2.hashCode());
    }
}

