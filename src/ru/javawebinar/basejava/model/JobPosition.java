package ru.javawebinar.basejava.model;

public class JobPosition extends AbstractResumePosition {

    private String itemDescription;

    public JobPosition(String itemDescription) {
        super(SectionType.POSITION);
        this.itemDescription = itemDescription;
    }

    public void setValue(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Override
    public String toString() {
        return  itemDescription;
    }
}
