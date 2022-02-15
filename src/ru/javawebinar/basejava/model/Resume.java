package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * ru.javawebinar.basejava.model.Resume class
 */

public class Resume implements Comparable<Resume> {
    // Unique identifier
    private final String uuid;
    private final String fullName;

    private List<Contact> contacts;
    private JobPosition jobPosition;
    private String personalQualities;
    private List<PersonalAchievement> personalAchievements;
    private  Qualifications qualifications;
    private List<Experience> experiences;
    private List<Education> educations;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String fullName, List<Contact> contacts,
                  JobPosition jobPosition, String personalQualities,
                  List<PersonalAchievement> personalAchievements, Qualifications qualifications,
                  List<Experience> experiences, List<Education> educations) {
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = UUID.randomUUID().toString();
        this.fullName = fullName;
        this.contacts = contacts;
        this.jobPosition = jobPosition;
        this.personalQualities = personalQualities;
        this.personalAchievements = personalAchievements;
        this.qualifications = qualifications;
        this.experiences = experiences;
        this.educations = educations;
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Резюме: " + uuid + "\n" + fullName + "\n" +
                SectionType.CONTACT.getTitle() + ":" + "\n" + "\t" + contacts + "\n" +
                SectionType.POSITION.getTitle() + ":" + "\n" + "\t" + jobPosition + "\n" +
                SectionType.PERSONAL.getTitle() + ":" + "\n" + "\t" + personalQualities + "\n" +
                SectionType.QUALIFICATIONS .getTitle() + ":" + "\n" + "\t" + qualifications + "\n" +
                SectionType.ACHIEVEMENT.getTitle()  + ":" + "\n" + "\t" + personalAchievements + "\n" +
                SectionType.EXPERIENCE.getTitle() + ":" + "\n" + "\t" + experiences + "\n" +
                SectionType.EDUCATION.getTitle() + ":" + "\n" + "\t" + educations;
    }

    @Override
    public int compareTo(Resume o) {
        int cmp = fullName.compareTo(o.fullName);
        return cmp != 0 ? cmp : uuid.compareTo(o.uuid);
    }
}

