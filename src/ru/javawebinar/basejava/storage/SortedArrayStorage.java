package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void retainedElement(Resume resume, int index) {
        int indexInArray = Math.abs(index) - 1;
        System.arraycopy(storage, indexInArray, storage, indexInArray + 1, size - indexInArray);
        storage[indexInArray] = resume;
    }

    @Override
    protected void deletedElement(int index) {
        int numMoved = size - 1 - index;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }
}
