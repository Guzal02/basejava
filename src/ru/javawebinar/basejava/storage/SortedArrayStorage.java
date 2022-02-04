package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {
    /*
        private static class ResumeComparator implements Comparator<Resume> {
            @Override
            public int compare(Resume o1, Resume o2) {
                return o1.getUuid().compareTo(o2.getUuid());
            }
        }
    */
    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid); // Lambda - java 8

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
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
