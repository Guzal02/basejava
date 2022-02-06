package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public class MapFullNameStorage extends MapUuidStorage {
    @Override
    protected String getSearchKey(String uuid) {
        return new Resume(uuid).getFullName();
    }
}
