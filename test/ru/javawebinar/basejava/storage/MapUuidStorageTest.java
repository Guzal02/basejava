package ru.javawebinar.basejava.storage;

public class MapUuidStorageTest extends AbstractStorageTest{

    public MapUuidStorageTest() {
        super(new MapUuidStorage());
    }

    @Override
    public void storageOverflow() {

    }
}