package ru.javawebinar.basejava.model;

import java.util.List;

public class Qualifications extends AbstractResumePosition {

    private List<Languages> languages;
    private List<ProgrammingLanguages> programmingLanguages;
    private List<Technologies> technologies;
    private List<Tools> tools;
    private List<VersionControl> versionControls;
    private List<Database> databases;

    public Qualifications(List<Languages> languages,
                          List<ProgrammingLanguages> programmingLanguages, List<Technologies> technologies,
                          List<Tools> tools, List<VersionControl> versionControls, List<Database> databases) {
        super(SectionType.QUALIFICATIONS);
        this.languages = languages;
        this.programmingLanguages = programmingLanguages;
        this.technologies = technologies;
        this.tools = tools;
        this.versionControls = versionControls;
        this.databases = databases;
    }

    @Override
    public String toString() {
        return "Языки:" + "\n" + languages + "\n" +
                "\t" + "Языки программирования:" + "\n" + programmingLanguages + "\n" +
                "\t" + "Технологии:" + "\n" + technologies + "\n" +
                "\t" + "Инструменты:" + "\n" + tools + "\n" +
                "\t" + "Version control:" + "\n" + versionControls + "\n" +
                "\t" + "База данных:" + "\n" + databases + "\n";
    }
}