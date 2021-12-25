import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume resume) {
        if (size >= 10000) {
            System.out.println("Хранилище заполнено!");
            return;
        }
        if (resume != null) {
            if (size == 0) {
                storage[0] = resume;
            } else {
                storage[size] = resume;
            }
            size++;
            System.out.println(resume + " - сохранен!");
        } else {
            System.out.println("Введите resume!");
        }
    }

    Resume get(String uuid) {
        if (uuid != null) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].getUuid())) {
                    return storage[i];
                }
            }
        } else {
            System.out.println("Введите uuid!");
        }
        System.out.println("Данный: " + uuid + " - не существует!");
        return null;
    }

    void delete(String uuid) {
        if (uuid != null) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    Resume[] newStorage = new Resume[storage.length];
                    System.arraycopy(storage, 0, newStorage, 0, i);
                    size--;
                    if (storage.length - 1 - i >= 0)
                        System.arraycopy(storage, i + 1, newStorage, i, storage.length - 1 - i);
                    System.out.println(uuid + " - удален!");
                    storage = newStorage;
                    return;
                } else {
                    System.out.println("Данный " + uuid + " не существует!");
                }
            }
        } else {
            System.out.println("Введите uuid!");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] filledStorage = new Resume[size];
        System.arraycopy(storage, 0, filledStorage, 0, size);
        return filledStorage;
    }

    int size() {
        return size;
    }
}
