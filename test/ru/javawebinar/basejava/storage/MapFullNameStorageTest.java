package ru.javawebinar.basejava.storage;

import static org.junit.Assert.*;

public class MapFullNameStorageTest extends AbstractStorageTest {

    public MapFullNameStorageTest() {
        super(new ListStorage());
    }

    @Override
    public void storageOverflow() {
    }
}