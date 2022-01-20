package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorageTest {
    protected final Storage storage;

    protected static final int STORAGE_LIMIT = 10000;


    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    protected static final String UUID_4 = "uuid4";


    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUpAbstractArrayStorageTest() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() { // можно название написать через when_then - например - whenStorageClearThenStorageSizeEmpty!
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void get() {
        Resume actual = storage.get(UUID_1);
        Resume expected = new Resume(UUID_1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void update() {
        storage.update(new Resume(UUID_2));
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void whenUpdateThenException() {
        Assert.assertThrows(NotExistStorageException.class, () -> storage.update(new Resume()));
    }

    @Test
    public void save() {
        Resume expected = new Resume(UUID_4);
        storage.save(expected);
        Assert.assertEquals(expected, storage.get(UUID_4));
    }

    @Test
    public void whenSaveAlreadyExistingUuidThenException() {
        Assert.assertThrows(ExistStorageException.class, () -> storage.save(new Resume(UUID_1)));
    }

    @Test
    public void StorageOverflow() {
        storage.clear();
        try {
            for (int i = 0; i < STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail("Overflow happened ahead of time!");
        }
        Assert.assertThrows(StorageException.class, () -> storage.save(new Resume()));
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void whenDeleteNonExistingUuidThenException() {
        Assert.assertThrows(NotExistStorageException.class, () -> storage.delete("uuid8"));
    }

    @Test
    public void getAll() {
        Resume[] actual = storage.getAll();
        String[] expected = {"uuid1", "uuid2", "uuid3"};
        Assert.assertEquals(
                Arrays.toString(expected),
                Arrays.toString(actual));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }
}