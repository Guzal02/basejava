package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link homePage;

    private final List<Tenure> tenure; // время пребывания в должности!

    private final String description;

    public Organization(String name, String url, List<Tenure> tenure, String description) {
        this.tenure = tenure;
        this.homePage = new Link(name, url);
        this.description = description;
    }

    public Link getHomePage() {
        return homePage;
    }

    public List<Tenure> getTenure() {
        return tenure;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        return Objects.equals(description, that.description);

    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", description='" + description + '\'' +
                '}';
    }
}
