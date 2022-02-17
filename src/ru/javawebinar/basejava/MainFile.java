package ru.javawebinar.basejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class MainFile {
    public static void main(String[] args) throws Exception {

        String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File(".\\src\\ru\\javawebinar\\basejava");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

// Home work 08!
        File directory = new File("C:\\Users\\02guz\\Desktop\\java\\basejava\\basejava");
        showDirectoryStructure(directory);
    }

    private static void showDirectoryStructure(File file) {
        if (file.isDirectory()) {
            try {
                System.out.println(file.getCanonicalFile());
                File[] subdir = file.listFiles();

                for (int i = 0; i < Objects.requireNonNull(subdir).length; i++) {
                    System.out.println(subdir[i].getParent());
                    showDirectoryStructure(subdir[i]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(file.getName());
        }
    }
}

