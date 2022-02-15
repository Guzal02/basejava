package ru.javawebinar.basejava.model;

import java.time.LocalDate;

public class Education extends AbstractResumePosition {

    private String organization;
    private LocalDate startDate;
    private LocalDate endDate;
    private String position;

    public Education(String organization, LocalDate startDate, LocalDate endDate, String position) {
        super(SectionType.EDUCATION);
        this.organization = organization;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Организация: " + organization + "\n" +
                "\t" + "Период: " + startDate + " - "+ endDate + "\n" +
                "\t"+ "Позиция: " + position + "\n" + "\t";
    }
}
