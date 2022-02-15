package ru.javawebinar.basejava.model;

public enum ContactType {
    PHONE("мобильный телефон"),
    EMAIL("электронная почта"),
    SKYPE("Skype"),
    LINKED_IN("LinkedIn"),
    STACKOVERFLOW("StackOverFlow"),
    GITHUB("GitHub");

    private String title;

    ContactType(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

}
