import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume resume) {
        if (size >= storage.length) {
            System.out.println("Хранилище заполнено!");
            return;
        }
        if (resume != null) {
            storage[size] = resume;
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
                    if (size - 1 - i >= 0) System.arraycopy(storage, i + 1, storage, i, size - 1 - i);
                    storage[size - 1] = null;
                    size--;
                    System.out.println(uuid + " удален!");
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
        Resume[] resumes = new Resume[size];
        System.arraycopy(storage, 0, resumes, 0, size);
        return resumes;
    }

    int size() {
        return size;
    }
}
