package ru.javawebinar.basejava.model;

public class PersonalAchievement extends AbstractResumePosition {

    private String description;

    public PersonalAchievement(String description) {
        super(SectionType.ACHIEVEMENT);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  description + "\n";
    }
}
