package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;

public class ArrayStorageTest extends AbstractArrayStorageTest {
    ArrayStorage arrayStorage;

    public ArrayStorageTest() {
        super(new ArrayStorage());
    }

    @Before
    public void setUp() throws Exception {
        setUpAbstractArrayStorageTest();
        arrayStorage = (ArrayStorage) storage;
    }

    @Test
    public void getIndexOutOfRange() {
        Assert.assertEquals(-1, arrayStorage.getIndex("uuid5"));
    }

    @Test
    public void retainedElement() {
        arrayStorage.retainedElement(new Resume(UUID_1), 0);
        Assert.assertEquals(3, arrayStorage.size());
    }

    @Test
    public void deletedElement() {
        arrayStorage.deletedElement(0);
        Assert.assertEquals(-1, arrayStorage.getIndex("uuid1"));
    }
}