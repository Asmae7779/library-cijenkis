package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests JUnit pour la classe Livre
 * 
 * Question 1: Écrivez un test pour vérifier que la création d'une instance de la classe `Livre` 
 * avec des valeurs spécifiques pour le titre, l'auteur, l'année de publication et l'ISBN fonctionne correctement.
 * 
 * Question 2: Écrivez des tests pour vérifier que les méthodes getters et setters de la classe `Livre` 
 * fonctionnent comme prévu. Assurez-vous de tester chaque propriété individuellement.
 * 
 * Question 3: Écrivez un test pour vérifier que deux instances de la classe `Livre` avec les mêmes 
 * attributs sont considérées comme égales.
 * 
 * Question 4: Écrivez des tests pour vérifier que la classe `Livre` effectue une validation appropriée 
 * des données lors de la création d'une instance. Par exemple, assurez-vous qu'une année de publication 
 * négative est rejetée.
 * 
 * Question 5: Écrivez des tests pour des cas limites, par exemple, lorsque le titre ou l'auteur est 
 * une chaîne vide, ou lorsque l'année de publication est très ancienne ou très récente.
 * 
 * Question 6: Écrivez un test pour évaluer la performance de la création d'un grand nombre d'instances 
 * de la classe `Livre`. Assurez-vous que cela se fait dans un délai raisonnable.
 * 
 * Question 7: Si votre système de gestion de bibliothèque interagit avec la classe `Livre`, écrivez 
 * des tests pour vérifier que cette interaction fonctionne correctement.
 * 
 * Question 8: Écrivez un test pour vérifier que les propriétés de la classe `Livre` sont correctement 
 * encapsulées et ne peuvent pas être modifiées directement depuis l'extérieur.
 * 
 * Question 9: Écrivez un test pour vérifier qu'il n'y a pas de fuite de mémoire lors de la création 
 * et de la destruction d'instances de la classe `Livre`.
 * 
 * Question 10: Si votre projet peut être utilisé avec différentes versions de JUnit, écrivez des tests 
 * pour vérifier la compatibilité avec JUnit 4 et JUnit 5.
 */
@DisplayName("Tests pour la classe Livre")
class LivreTest {

    private Livre livre;

    @BeforeEach
    void setUp() {
        livre = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1943, "978-2070612758");
    }

    // ============================================
    // Question 1: Test de création d'instance
    // ============================================
    
    /**
     * Question 1: Écrivez un test pour vérifier que la création d'une instance de la classe `Livre` 
     * avec des valeurs spécifiques pour le titre, l'auteur, l'année de publication et l'ISBN fonctionne correctement.
     */
    @Test
    @DisplayName("Question 1: Test de création d'instance avec valeurs spécifiques")
    void testCreationInstanceAvecValeursSpecifiques() {
        // Arrange & Act
        Livre nouveauLivre = new Livre("1984", "George Orwell", 1949, "978-0451524935");

        // Assert
        assertNotNull(nouveauLivre, "L'instance ne devrait pas être null");
        assertEquals("1984", nouveauLivre.getTitre(), "Le titre devrait être '1984'");
        assertEquals("George Orwell", nouveauLivre.getAuteur(), "L'auteur devrait être 'George Orwell'");
        assertEquals(1949, nouveauLivre.getAnneePublication(), "L'année devrait être 1949");
        assertEquals("978-0451524935", nouveauLivre.getIsbn(), "L'ISBN devrait être '978-0451524935'");
    }

    // ============================================
    // Question 2: Tests des getters et setters
    // ============================================
    
    /**
     * Question 2: Écrivez des tests pour vérifier que les méthodes getters et setters de la classe `Livre` 
     * fonctionnent comme prévu. Assurez-vous de tester chaque propriété individuellement.
     */
    @Test
    @DisplayName("Question 2: Test du getter et setter pour le titre")
    void testGetterSetterTitre() {
        // Arrange
        String nouveauTitre = "L'Étranger";

        // Act
        livre.setTitre(nouveauTitre);

        // Assert
        assertEquals(nouveauTitre, livre.getTitre(), "Le titre devrait être modifié");
    }

    @Test
    @DisplayName("Question 2: Test du getter et setter pour l'auteur")
    void testGetterSetterAuteur() {
        // Arrange
        String nouvelAuteur = "Albert Camus";

        // Act
        livre.setAuteur(nouvelAuteur);

        // Assert
        assertEquals(nouvelAuteur, livre.getAuteur(), "L'auteur devrait être modifié");
    }

    @Test
    @DisplayName("Question 2: Test du getter et setter pour l'année de publication")
    void testGetterSetterAnneePublication() {
        // Arrange
        int nouvelleAnnee = 1942;

        // Act
        livre.setAnneePublication(nouvelleAnnee);

        // Assert
        assertEquals(nouvelleAnnee, livre.getAnneePublication(), "L'année de publication devrait être modifiée");
    }

    @Test
    @DisplayName("Question 2: Test du getter et setter pour l'ISBN")
    void testGetterSetterIsbn() {
        // Arrange
        String nouvelIsbn = "978-2070360028";

        // Act
        livre.setIsbn(nouvelIsbn);

        // Assert
        assertEquals(nouvelIsbn, livre.getIsbn(), "L'ISBN devrait être modifié");
    }

    // ============================================
    // Question 3: Test d'égalité
    // ============================================
    
    /**
     * Question 3: Écrivez un test pour vérifier que deux instances de la classe `Livre` avec les mêmes 
     * attributs sont considérées comme égales.
     */
    @Test
    @DisplayName("Question 3: Test d'égalité entre deux instances avec mêmes attributs")
    void testEgaliteDeuxInstancesMemeAttributs() {
        // Arrange
        Livre livre1 = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1943, "978-2070612758");
        Livre livre2 = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1943, "978-2070612758");

        // Act & Assert
        assertEquals(livre1, livre2, "Deux livres avec les mêmes attributs devraient être égaux");
        assertEquals(livre1.hashCode(), livre2.hashCode(), "Deux livres égaux devraient avoir le même hashCode");
    }

    @Test
    @DisplayName("Question 3: Test d'inégalité entre deux instances avec attributs différents")
    void testInegaliteDeuxInstancesAttributsDifferents() {
        // Arrange
        Livre livre1 = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1943, "978-2070612758");
        Livre livre2 = new Livre("1984", "George Orwell", 1949, "978-0451524935");

        // Act & Assert
        assertNotEquals(livre1, livre2, "Deux livres avec des attributs différents ne devraient pas être égaux");
    }

    // ============================================
    // Question 4: Tests de validation
    // ============================================
    
    /**
     * Question 4: Écrivez des tests pour vérifier que la classe `Livre` effectue une validation appropriée 
     * des données lors de la création d'une instance. Par exemple, assurez-vous qu'une année de publication 
     * négative est rejetée.
     */
    @Test
    @DisplayName("Question 4: Test rejet année de publication négative dans constructeur")
    void testRejetAnneePublicationNegativeConstructeur() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> new Livre("Test", "Auteur", -100, "978-1234567890"),
            "Une IllegalArgumentException devrait être levée pour une année négative"
        );
        
        assertTrue(exception.getMessage().contains("négative"), 
                   "Le message d'erreur devrait mentionner 'négative'");
    }

    @Test
    @DisplayName("Question 4: Test rejet année de publication négative dans setter")
    void testRejetAnneePublicationNegativeSetter() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> livre.setAnneePublication(-50),
            "Une IllegalArgumentException devrait être levée pour une année négative dans le setter"
        );
        
        assertTrue(exception.getMessage().contains("négative"), 
                   "Le message d'erreur devrait mentionner 'négative'");
    }

    @Test
    @DisplayName("Question 4: Test acceptation année de publication zéro")
    void testAcceptationAnneeZero() {
        // Act & Assert
        assertDoesNotThrow(() -> {
            Livre livreZero = new Livre("Test", "Auteur", 0, "978-1234567890");
            assertEquals(0, livreZero.getAnneePublication());
        }, "L'année zéro devrait être acceptée");
    }

    // ============================================
    // Question 5: Tests de cas limites
    // ============================================
    
    /**
     * Question 5: Écrivez des tests pour des cas limites, par exemple, lorsque le titre ou l'auteur est 
     * une chaîne vide, ou lorsque l'année de publication est très ancienne ou très récente.
     */
    @Test
    @DisplayName("Question 5: Test avec titre chaîne vide")
    void testTitreChaineVide() {
        // Act
        livre.setTitre("");

        // Assert
        assertEquals("", livre.getTitre(), "Un titre vide devrait être accepté");
    }

    @Test
    @DisplayName("Question 5: Test avec auteur chaîne vide")
    void testAuteurChaineVide() {
        // Act
        livre.setAuteur("");

        // Assert
        assertEquals("", livre.getAuteur(), "Un auteur vide devrait être accepté");
    }

    @Test
    @DisplayName("Question 5: Test avec année très ancienne")
    void testAnneeTresAncienne() {
        // Act
        livre.setAnneePublication(1);

        // Assert
        assertEquals(1, livre.getAnneePublication(), "Une année très ancienne devrait être acceptée");
    }

    @Test
    @DisplayName("Question 5: Test avec année très récente")
    void testAnneeTresRecente() {
        // Arrange
        int anneeFuture = 2100;

        // Act
        livre.setAnneePublication(anneeFuture);

        // Assert
        assertEquals(anneeFuture, livre.getAnneePublication(), "Une année très récente devrait être acceptée");
    }

    @Test
    @DisplayName("Question 5: Test avec titre null")
    void testTitreNull() {
        // Act
        livre.setTitre(null);

        // Assert
        assertNull(livre.getTitre(), "Un titre null devrait être accepté");
    }

    @Test
    @DisplayName("Question 5: Test avec auteur null")
    void testAuteurNull() {
        // Act
        livre.setAuteur(null);

        // Assert
        assertNull(livre.getAuteur(), "Un auteur null devrait être accepté");
    }

    // ============================================
    // Question 6: Test de performance
    // ============================================
    
    /**
     * Question 6: Écrivez un test pour évaluer la performance de la création d'un grand nombre d'instances 
     * de la classe `Livre`. Assurez-vous que cela se fait dans un délai raisonnable.
     */
    @Test
    @DisplayName("Question 6: Test de performance création grand nombre d'instances")
    @Timeout(5) // 5 secondes maximum
    void testPerformanceCreationGrandNombreInstances() {
        // Arrange
        int nombreInstances = 100000;
        long debut = System.currentTimeMillis();

        // Act
        for (int i = 0; i < nombreInstances; i++) {
            new Livre("Titre " + i, "Auteur " + i, 1900 + (i % 100), "978-" + i);
        }

        // Assert
        long fin = System.currentTimeMillis();
        long duree = fin - debut;
        
        assertTrue(duree < 5000, 
                   "La création de " + nombreInstances + " instances devrait prendre moins de 5 secondes. Durée: " + duree + "ms");
    }

    // ============================================
    // Question 7: Tests d'interaction avec système
    // ============================================
    
    /**
     * Question 7: Si votre système de gestion de bibliothèque interagit avec la classe `Livre`, 
     * écrivez des tests pour vérifier que cette interaction fonctionne correctement.
     */
    @Test
    @DisplayName("Question 7: Test interaction avec collection de livres")
    void testInteractionAvecCollectionLivres() {
        // Arrange
        List<Livre> bibliotheque = new ArrayList<>();
        Livre livre1 = new Livre("Livre 1", "Auteur 1", 2000, "978-1111111111");
        Livre livre2 = new Livre("Livre 2", "Auteur 2", 2001, "978-2222222222");
        Livre livre3 = new Livre("Livre 3", "Auteur 3", 2002, "978-3333333333");

        // Act
        bibliotheque.add(livre1);
        bibliotheque.add(livre2);
        bibliotheque.add(livre3);

        // Assert
        assertEquals(3, bibliotheque.size(), "La bibliothèque devrait contenir 3 livres");
        assertTrue(bibliotheque.contains(livre1), "La bibliothèque devrait contenir livre1");
        assertTrue(bibliotheque.contains(livre2), "La bibliothèque devrait contenir livre2");
        assertTrue(bibliotheque.contains(livre3), "La bibliothèque devrait contenir livre3");
    }

    @Test
    @DisplayName("Question 7: Test recherche livre dans collection")
    void testRechercheLivreDansCollection() {
        // Arrange
        List<Livre> bibliotheque = new ArrayList<>();
        Livre livreRecherche = new Livre("Livre Recherché", "Auteur Recherché", 2020, "978-9999999999");
        bibliotheque.add(new Livre("Livre 1", "Auteur 1", 2000, "978-1111111111"));
        bibliotheque.add(livreRecherche);
        bibliotheque.add(new Livre("Livre 3", "Auteur 3", 2002, "978-3333333333"));

        // Act
        Livre livreTrouve = bibliotheque.stream()
            .filter(l -> l.getTitre().equals("Livre Recherché"))
            .findFirst()
            .orElse(null);

        // Assert
        assertNotNull(livreTrouve, "Le livre recherché devrait être trouvé");
        assertEquals(livreRecherche, livreTrouve, "Le livre trouvé devrait être égal au livre recherché");
    }

    // ============================================
    // Question 8: Test d'encapsulation
    // ============================================
    
    /**
     * Question 8: Écrivez un test pour vérifier que les propriétés de la classe `Livre` sont correctement 
     * encapsulées et ne peuvent pas être modifiées directement depuis l'extérieur.
     */
    @Test
    @DisplayName("Question 8: Test encapsulation - accès direct aux champs privés via réflexion")
    void testEncapsulationAccesDirectChampsPrives() {
        try {
            // Tentative d'accès direct au champ titre via réflexion
            Field champTitre = Livre.class.getDeclaredField("titre");
            champTitre.setAccessible(true);
            String ancienTitre = livre.getTitre();
            champTitre.set(livre, "Titre Modifié Directement");

            // Vérifier que la modification directe fonctionne (car la réflexion permet de contourner l'encapsulation)
            // Mais cela démontre que l'encapsulation est en place (champs privés)
            String titreModifie = (String) champTitre.get(livre);
            
            // Le fait que nous devions utiliser la réflexion prouve l'encapsulation
            assertNotNull(champTitre, "Le champ titre devrait exister");
            assertTrue(java.lang.reflect.Modifier.isPrivate(champTitre.getModifiers()), 
                      "Le champ titre devrait être privé");
            
            // Restaurer l'état original
            champTitre.set(livre, ancienTitre);
            
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Erreur lors du test d'encapsulation: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Question 8: Test encapsulation - vérification que les champs sont privés")
    void testEncapsulationChampsPrives() {
        // Vérifier que tous les champs sont privés
        Field[] champs = Livre.class.getDeclaredFields();
        
        for (Field champ : champs) {
            assertTrue(java.lang.reflect.Modifier.isPrivate(champ.getModifiers()),
                      "Le champ " + champ.getName() + " devrait être privé");
        }
    }

    // ============================================
    // Question 9: Test de fuite mémoire
    // ============================================
    
    /**
     * Question 9: Écrivez un test pour vérifier qu'il n'y a pas de fuite de mémoire lors de la création 
     * et de la destruction d'instances de la classe `Livre`.
     */
    @Test
    @DisplayName("Question 9: Test absence de fuite mémoire")
    void testAbsenceFuiteMemoire() {
        // Arrange
        int nombreIterations = 10000;
        Runtime runtime = Runtime.getRuntime();
        
        // Forcer un garbage collection avant le test
        System.gc();
        try {
            Thread.sleep(100); // Attendre un peu pour le GC
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        long memoireAvant = runtime.totalMemory() - runtime.freeMemory();

        // Act - Créer et détruire des instances
        for (int i = 0; i < nombreIterations; i++) {
            Livre livreTemp = new Livre("Titre " + i, "Auteur " + i, 2000 + (i % 20), "978-" + i);
            // Laisser l'objet être éligible pour le GC
            livreTemp = null;
        }

        // Forcer un garbage collection après la création
        System.gc();
        try {
            Thread.sleep(100); // Attendre un peu pour le GC
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        long memoireApres = runtime.totalMemory() - runtime.freeMemory();
        long differenceMemoire = memoireApres - memoireAvant;

        // Assert - La différence de mémoire ne devrait pas être excessive
        // Note: Ce test est approximatif car le GC n'est pas garanti
        assertTrue(Math.abs(differenceMemoire) < 50 * 1024 * 1024, // Moins de 50 MB
                  "La différence de mémoire devrait être raisonnable. Différence: " + 
                  (differenceMemoire / 1024 / 1024) + " MB");
    }

    // ============================================
    // Question 10: Tests de compatibilité JUnit
    // ============================================
    
    /**
     * Question 10: Si votre projet peut être utilisé avec différentes versions de JUnit, écrivez des tests 
     * pour vérifier la compatibilité avec JUnit 4 et JUnit 5.
     */
    @Test
    @DisplayName("Question 10: Test compatibilité JUnit 5 (Jupiter)")
    void testCompatibiliteJUnit5() {
        // Ce test utilise JUnit 5 (Jupiter) - annotations @Test, @BeforeEach, etc.
        // Arrange
        Livre livreJUnit5 = new Livre("JUnit 5 Test", "Jupiter", 2017, "978-JUNIT5");

        // Act & Assert
        assertNotNull(livreJUnit5, "L'instance devrait être créée avec JUnit 5");
        assertEquals("JUnit 5 Test", livreJUnit5.getTitre(), "Le titre devrait être correct avec JUnit 5");
    }

    // ============================================
    // Tests partiels pour méthodes en jaune dans JaCoCo
    // ============================================
    
    /**
     * Test partiel de getCategorieAge() - seulement certains cas testés
     * Les autres cas ne seront pas testés pour que la méthode apparaisse en jaune dans JaCoCo
     */
    @Test
    @DisplayName("Test partiel getCategorieAge - seulement MODERNE et RECENT testés")
    void testGetCategorieAgePartiel() {
        // Test seulement MODERNE (1943)
        Livre livreModerne = new Livre("Test", "Auteur", 1943, "978-123");
        assertEquals("MODERNE", livreModerne.getCategorieAge(), "Un livre de 1943 devrait être MODERNE");
        
        // Test seulement RECENT (1980)
        Livre livreRecent = new Livre("Test", "Auteur", 1980, "978-123");
        assertEquals("RECENT", livreRecent.getCategorieAge(), "Un livre de 1980 devrait être RECENT");
        
        // Note: Les cas ANCIEN (< 1900) et TRES_RECENT (>= 2000) ne sont PAS testés
        // pour que la méthode apparaisse en jaune dans JaCoCo
    }

    /**
     * Test partiel de estDisponible() - seulement certains cas testés
     * Les autres cas ne seront pas testés pour que la méthode apparaisse en jaune dans JaCoCo
     */
    @Test
    @DisplayName("Test partiel estDisponible - seulement cas disponibles testés")
    void testEstDisponiblePartiel() {
        // Test cas disponible
        assertTrue(livre.estDisponible(5, 2), "Le livre devrait être disponible");
        assertTrue(livre.estDisponible(10, 0), "Le livre devrait être disponible");
        
        // Note: Les cas suivants ne sont PAS testés pour que la méthode apparaisse en jaune:
        // - nombreExemplaires <= 0
        // - nombreEmprunts < 0 (exception)
        // - nombreEmprunts >= nombreExemplaires
    }
}

