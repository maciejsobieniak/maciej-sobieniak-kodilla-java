package com.kodilla.stream.world;

import com.kodilla.stream.forum.ForumUser;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Continent {

    private final String name;
    private final Set<Country> countries = new HashSet<>();

    public Continent(final String name) {
        this.name = name;
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public boolean removeCountry(Country country) {
        return countries.remove(country);
    }

    public String getName() {
        return name;
    }
    public Set<Country> getCountries() {
        return new HashSet<>(countries);
    }

    /**
     * Retrieves the set of countries in this continent.
     *
     * @return a set of country names
     */
    public Set<String> getCountriesName() {
        return countries.stream()
                .map(Country::getName)
                .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "Continent{" +
                "name='" + name + '\'' +
                ", countries=" + countries +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Continent continent)) return false;
        return name.equals(continent.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }



}
