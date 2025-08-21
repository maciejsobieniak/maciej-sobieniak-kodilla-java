package com.kodilla.stream.world;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test suite for the World class.
 */
public class WorldTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests () {
        System.out.println("Start tests world module");
    }

    @BeforeEach
    public void before() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
        System.out.println("Test Case: begin");
    }


    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @Test
    @DisplayName("Test getPeopleQuantity method")
    // This test verifies that the getPeopleQuantity method correctly calculates the total population of all continents in the world.
    void testGetPeopleQuantity() {
        // Given
        World world = new World("Earth");
        Continent europe = new Continent("Europe");
        Continent asia = new Continent("Asia");
        Continent africa = new Continent("Africa");
        Continent northAmerica = new Continent("North America");
        Continent southAmerica = new Continent("South America");
        Continent australia = new Continent("Australia");
        Continent antarctica = new Continent("Antarctica");
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);
        world.addContinent(northAmerica);
        world.addContinent(southAmerica);
        world.addContinent(australia);
        world.addContinent(antarctica);
        europe.addCountry(new Country("Poland", new BigDecimal("30000000")));
        europe.addCountry(new Country("Germany", new BigDecimal("80000000")));
        asia.addCountry(new Country("China", new BigDecimal("1000000000")));
        asia.addCountry(new Country("India", new BigDecimal("1400000000")));
        africa.addCountry(new Country("Nigeria", new BigDecimal("210000000")));
        northAmerica.addCountry(new Country("USA", new BigDecimal("340000000")));
        northAmerica.addCountry(new Country("Canada", new BigDecimal("460000000")));
        southAmerica.addCountry(new Country("Brazil", new BigDecimal("230000000")));
        australia.addCountry(new Country("Australia", new BigDecimal("250000000")));
        antarctica.addCountry(new Country("Antarctica", new BigDecimal("0")));
        // When
        BigDecimal totalPopulation = world.getPeopleQuantity();
        // Then
        BigDecimal expectedPopulation = new BigDecimal("4000000000"); // 4 billion
        assertEquals(expectedPopulation, totalPopulation, "Total population should be 4 billion");
    }

    @Test
    @DisplayName("Test getPeopleQuantity with empty world")
    // This test verifies that the getPeopleQuantity method returns zero when there are no continents or countries in the world.
    // It ensures that the method handles an empty world correctly.
    void testGetPeopleQuantityWithEmptyWorld() {
        // Given
        World world = new World("Empty World");
        // When
        BigDecimal totalPopulation = world.getPeopleQuantity();
        // Then
        assertEquals(BigDecimal.ZERO, totalPopulation, "Total population of an empty world should be zero");
    }

    @Test
    @DisplayName("Test addContinent and getContinents methods")
    // This test verifies that the addContinent method correctly adds a continent to the world
    // and that the getContinents method returns the correct set of continents.
    void testAddContinentAndGetContinents() {
        // Given
        World world = new World("Earth");
        Continent europe = new Continent("Europe");
        // When
        world.addContinent(europe);
        // Then
        assertTrue(world.getContinentsName().contains("Europe"), "World should contain Europe continent");
        assertEquals(1, world.getContinents().size(), "World should have one continent");
    }

    @Test
    @DisplayName("Test removeContinent method")
    // This test verifies that the removeContinent method correctly removes a continent from the world.
    void testRemoveContinent() {
        // Given
        World world = new World("Earth");
        Continent europe = new Continent("Europe");
        world.addContinent(europe);
        // When
        boolean removed = world.removeContinent(europe);
        // Then
        assertTrue(removed, "Continent should be removed successfully");
        assertFalse(world.getContinentsName().contains("Europe"), "World should not contain Europe continent after removal");
        assertEquals(0, world.getContinents().size(), "World should have no continents after removal");
    }

    @Test
    @DisplayName("Test getContriesName method")
    // This test verifies that the getCountriesName method returns the correct set of country names from
    // all continents in the world.
    void testGetCountriesName() {
        // Given
        World world = new World("Earth");
        Continent europe = new Continent("Europe");
        Continent asia = new Continent("Asia");
        europe.addCountry(new Country("Poland", new BigDecimal("30000000")));
        europe.addCountry(new Country("Germany", new BigDecimal("80000000")));
        asia.addCountry(new Country("China", new BigDecimal("1000000000")));
        asia.addCountry(new Country("India", new BigDecimal("1400000000")));
        world.addContinent(europe);
        world.addContinent(asia);

        // Then
        assertTrue(world.getCountriesName().contains("Poland"), "Country names should contain Poland");
        assertTrue(europe.getCountriesName().contains("Germany"), "Country names should contain Germany");
        assertTrue(asia.getCountriesName().contains("China"), "Country names should contain China");
        assertTrue(asia.getCountriesName().contains("India"), "Country names should contain India");
        assertEquals(4, world.getCountriesName().size(), "There should be 4 unique country names");
    }
}
