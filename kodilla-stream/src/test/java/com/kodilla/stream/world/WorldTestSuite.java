package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class WorldTestSuite {

    private World prepareWorld() {
        Continent europe = new Continent();
        Country russia = new Country(new BigDecimal("142470272"));
        Country turkey = new Country(new BigDecimal("81619392"));
        Country germany = new Country(new BigDecimal("80996685"));
        europe.addCountry(russia);
        europe.addCountry(turkey);
        europe.addCountry(germany);

        Continent asia = new Continent();
        Country china = new Country(new BigDecimal("1330044605"));
        Country india = new Country(new BigDecimal("1147996000"));
        Country indonesia = new Country(new BigDecimal("237512000"));
        asia.addCountry(china);
        asia.addCountry(india);
        asia.addCountry(indonesia);

        Continent africa = new Continent();
        Country nigeria = new Country(new BigDecimal("146255312"));
        Country egypt = new Country(new BigDecimal("81714000"));
        Country ethiopia = new Country(new BigDecimal("78254000"));
        africa.addCountry(nigeria);
        africa.addCountry(egypt);
        africa.addCountry(ethiopia);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);

        return world;
    }

    @Test
    public void testContinentsQuantity() {
        // Given
        World world = prepareWorld();

        // When
        int continentsQuantity = world.getContinents().size();

        // Then
        Assert.assertEquals(3, continentsQuantity);
    }

    @Test
    public void testCountriesQuantity() {
        // Given
        World world = prepareWorld();

        // When
        long countriesQuantity = world.getContinents().stream()
                .mapToInt(continent -> continent.getCountries().size())
                .sum();

        // Then
        Assert.assertEquals(9, countriesQuantity);
    }

    @Test
    public void testGetPeopleQuantity() {
        // Given
        World world = prepareWorld();

        // When
        BigDecimal peopleQuantity = world.getPeopleQuantity();

        // Then
        BigDecimal peopleExpected = new BigDecimal("3326862266");
        Assert.assertEquals(peopleExpected, peopleQuantity);
    }
}
