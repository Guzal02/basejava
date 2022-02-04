package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;

public class ArrayStorageTest extends AbstractStorageTest {
    ArrayStorage arrayStorage;

    public ArrayStorageTest() {
        super(new ArrayStorage());
    }

    @Before
    public void setUp() {
        setUpAbstractStorageTest();
        arrayStorage = (ArrayStorage) storage;
    }

    @Test
    public void getIndexOutOfRange() {
        Assert.assertEquals((Integer) (-1), arrayStorage.getSearchKey("uuid5"));
    }

    @Test
    public void retainedElement() {
        arrayStorage.retainedElement(new Resume(UUID_1), 0);
        Assert.assertEquals(3, arrayStorage.size());
    }

    @Test
    public void deletedElement() {
        arrayStorage.deletedElement(0);
        Assert.assertEquals((Integer) (-1), arrayStorage.getSearchKey("uuid1"));
    }
}