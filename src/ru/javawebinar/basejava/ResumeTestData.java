package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;

public class ResumeTestData {
    public static Resume createResume(String uuid, String fullName) {
        return new Resume(uuid, fullName);
    }

}
