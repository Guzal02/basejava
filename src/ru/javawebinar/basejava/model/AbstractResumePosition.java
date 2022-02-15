package ru.javawebinar.basejava.model;

public abstract class AbstractResumePosition {
    private SectionType sectionType;

    public AbstractResumePosition(SectionType sectionType) {
        this.sectionType = sectionType;
    }

    public SectionType getSectionType() {
        return sectionType;
    }
}
