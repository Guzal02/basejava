package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(ContactType.PHONE, "+79221311521"));
        contacts.add(new Contact(ContactType.EMAIL, "dddd@mail.com"));

        List<PersonalAchievement> personalAchievements = new ArrayList<>();
        personalAchievements.add(new PersonalAchievement("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"," +
                "Многомодульный maven. Многопоточность. XML (JAXB/StAX)" +
                " Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA) "));
        personalAchievements.add(new PersonalAchievement("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike." +
                " Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk"));

        List<Languages> languages = Arrays.asList(Languages.ENGLISH, Languages.RUSSIAN);
        List<ProgrammingLanguages> programmingLanguages = Arrays.asList(ProgrammingLanguages.JAVA, ProgrammingLanguages.PYTHON);
        List<Technologies> technologies = Arrays.asList(Technologies.JPA, Technologies.DOM, Technologies.AJAX);
        List<Tools> tools = Arrays.asList(Tools.MAVEN, Tools.GRADLE, Tools.NGNIX);
        List<VersionControl> versionControls = Arrays.asList(VersionControl.GIT, VersionControl.MERCURY, VersionControl.SUBVERSION);
        List<Database> databases = Arrays.asList(Database.SQL, Database.MS, Database.MYSQL);
        Qualifications qualifications = new Qualifications(languages, programmingLanguages, technologies, tools, versionControls, databases);

        List<Experience> experiences = Arrays.asList(new Experience("Java Online Projects", LocalDate.of(2013, 10, 10), LocalDate.now(),
                        "Автор проекта", "Создание, организация и проведение Java онлайн проектов и стажировок"),
                new Experience("Wrike", LocalDate.of(2014, 10, 1), LocalDate.of(2016, 1, 1), "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                        "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO"));

        List<Education> educations = Arrays.asList(new Education("Coursera", LocalDate.of(2013, 3, 5), LocalDate.of(2013, 5, 5),
                        "\"Functional Programming Principles in Scala\" by Martin Odersky"),
                new Education("Luxoft", LocalDate.of(2011, 3, 10), LocalDate.of(2011, 4, 10), "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\""));

        Resume resume = new Resume("Григорий Кислин", contacts, new JobPosition("Java Junior"), "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.",
                personalAchievements, qualifications, experiences, educations);
        System.out.println(resume);
    }
}
