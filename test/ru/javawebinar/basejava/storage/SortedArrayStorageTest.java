package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;

public class SortedArrayStorageTest extends AbstractStorageTest {
    SortedArrayStorage sortedArrayStorage;

    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }

    @Before
    public void setUp() throws Exception {
        setUpAbstractStorageTest();
        sortedArrayStorage = (SortedArrayStorage) storage;
    }

    @Test
    public void getSearchKey() {
        Assert.assertEquals((Integer) 0, sortedArrayStorage.getSearchKey("uuid1"));
    }

    @Test
    public void retainedElement() {
        sortedArrayStorage.retainedElement(new Resume(UUID_4), -4);
        Assert.assertEquals(3, sortedArrayStorage.size());
    }

    @Test
    public void deletedElement() {
        sortedArrayStorage.deletedElement(1);
        List<Resume> expected = Arrays.asList(RESUME_1, RESUME_3, RESUME_3);
        Assert.assertEquals(expected, sortedArrayStorage.getAllSorted());
    }
}