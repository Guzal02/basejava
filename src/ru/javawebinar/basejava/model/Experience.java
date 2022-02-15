package ru.javawebinar.basejava.model;

import java.time.LocalDate;

public class Experience extends Education {

    private String jobDescription;

    public Experience(String organization, LocalDate startDate, LocalDate endDate, String position, String jobDescription) {
        super(organization, startDate, endDate, position);
        this.jobDescription = jobDescription;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    @Override
    public String toString() {

        return super.toString() + "Описание должности: " + jobDescription;
    }
}
