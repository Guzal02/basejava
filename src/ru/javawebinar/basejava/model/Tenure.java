package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.Objects;

public class Tenure {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String title;

    public Tenure(LocalDate startDate, LocalDate endDate, String title) {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(title, "title must not be null");
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tenure tenure = (Tenure) o;

        if (!Objects.equals(startDate, tenure.startDate)) return false;
        if (!Objects.equals(endDate, tenure.endDate)) return false;
        return Objects.equals(title, tenure.title);
    }

    @Override
    public int hashCode() {
        int result = startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Tenure{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", title='" + title + '\'' +
                '}';
    }
}
