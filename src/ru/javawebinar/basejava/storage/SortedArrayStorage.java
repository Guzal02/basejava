package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void retainedElement(Resume resume, int index) {
        int indexInArray = Math.abs(index) - 1;
        System.arraycopy(storage, indexInArray, storage, indexInArray + 1, size - indexInArray);
        storage[indexInArray] = resume;
    }
}
