package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;

import static ru.javawebinar.basejava.TestData.*;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {
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
        Assert.assertEquals((Integer) 0, sortedArrayStorage.getSearchKey(UUID_1));
    }

    @Test
    public void retainedElement() {
        sortedArrayStorage.retainedElement(new Resume(UUID_4, "Name4"), -4);
        Assert.assertEquals(3, sortedArrayStorage.size());
    }

    @Test
    public void deletedElement() {
        sortedArrayStorage.deletedElement(1);
        List<Resume> expected = Arrays.asList(new Resume(UUID_1, "Name1"), new Resume(UUID_3, "Name3"), new Resume(UUID_3, "Name3"));
        Assert.assertEquals(expected, sortedArrayStorage.getAllSorted());
    }

}