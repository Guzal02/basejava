package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getSearchKey(String uuid);

    protected abstract void doUpdate(Resume r, Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doSave(Resume r, Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void doDelete(Object searchKey);

    public void update(Resume resume) {
        Object searchKey = getExistedSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    public void save(Resume resume) {
        Object searchKey = getNotExistedSearchKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        return doGet(searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    private Object getExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}