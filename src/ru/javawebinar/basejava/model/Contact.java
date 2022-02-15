package ru.javawebinar.basejava.model;

public class Contact extends AbstractResumePosition {

    public Contact(ContactType contactType, String value) {
        super(SectionType.CONTACT);
        this.contactType = contactType;
        this.value = value;
    }

    private ContactType contactType;
    private String value;

    public ContactType getContactType() {
        return contactType;
    }

    public String getValue() {
        return value;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (contactType != contact.contactType) return false;
        return value.equals(contact.value);
    }

    @Override
    public int hashCode() {
        int result = contactType.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return contactType.getTitle() + ": " + value;
    }
}
