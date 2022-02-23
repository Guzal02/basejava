package ru.javawebinar.basejava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class MainFile {
    public static void main(String[] args) throws IOException {
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

//   Рекурсивный вывод каталогов и файлов без отступов -2 часть
//        printDirectoryDeeply(dir);

// Рекурсивный вывод каталогов и файлов с отступами -2 часть
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Incorrect directory name");
        }
        Deque<Element> stack = new ArrayDeque<>();
        stack.add(new Element("-", dir));
        while (!stack.isEmpty()) {
            Element element = stack.pollLast();
            System.out.println(element);
            if (element.file.isDirectory()) {
                File[] files = element.file.listFiles();
                for (int i = Objects.requireNonNull(files).length - 1; i >= 0; i--) {
                    stack.add(new Element(element.indent + "--", files[i]));
                }
            }
        }
    }

    //   Рекурсивный вывод каталогов и файлов без отступов -1ая часть
    public static void printDirectoryDeeply(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printDirectoryDeeply(file);
                }
            }
        }
    }

    // Рекурсивный вывод каталогов и файлов с отступами -1ая часть
    private record Element(String indent, File file) {

        public String toString() {
            return indent + file.getName();
        }
    }
}