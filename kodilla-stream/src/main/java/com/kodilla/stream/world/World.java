package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class World {
    private final String name;
    private final Set<Continent> continents = new HashSet<>();

    public World(final String name) {
        this.name = name;
    }

    public void addContinent(Continent continent) {
        continents.add(continent);
    }
    public boolean removeContinent(Continent continent) {
        return continents.remove(continent);
    }

    public String getName() {
        return name;
    }

    public Set<Continent> getContinents() {
        return new HashSet<>(continents);
    }

    /**
     * Calculates the total population of all countries in all continents.
     *
     * @return the total population as a BigDecimal
     */

    public BigDecimal getPeopleQuantity() {
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    /**
     * Retrieves the names of all continents in the world.
     *
     * @return a set of continent names
     */
    public Set<String> getContinentsName() {
        return continents.stream()
                .map(Continent::getName)
                .collect(Collectors.toSet());
    }

    /**
     * Retrieves the names of all countries in the world.
     *
     * @return a set of country names
     */
    public Set<String> getCountriesName() {
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getName)
                .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "World{" +
                "name='" + name + '\'' +
                ", continents=" + continents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof World world)) return false;
        return name.equals(world.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
