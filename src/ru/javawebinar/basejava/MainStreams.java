package ru.javawebinar.basejava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainStreams {
    public static void main(String[] args) {
        int[] values = new int[]{5, 1, 6, 7, 8, 0, 5, 6};
        System.out.println(minValue(values));
        List<Integer> num = Arrays.asList(1,2,8,9,5,10);
        System.out.println(oddOrEven(num));
    }
//////Java 8 Streams:
// реализовать метод через стрим int minValue(int[] values).
// Метод принимает массив цифр от 1 до 9, надо выбрать уникальные и вернуть минимально возможное число,
// составленное из этих уникальных цифр. Не использовать преобразование в строку и обратно.
// Например {1,2,3,3,2,3} вернет 123, а {9,8} вернет 89
    private static int minValue(int[] values) {
        return Arrays.stream(values).sorted()
                .distinct()
                .reduce(0, (a, b) -> 10 * a + b);
//               ------------- через строки!
//                .mapToObj(String::valueOf)
//                .collect(Collectors.joining());
//        return Integer.parseInt(collect);
    }


// реализовать метод List<Integer> oddOrEven(List<Integer> integers) если сумма всех чисел нечетная -
// удалить все нечетные, если четная - удалить все четные. Сложность алгоритма должна быть O(N).
// Optional - решение в один стрим.
    private static List<Integer> oddOrEven(List<Integer> integers) {
        return integers.stream()
                .filter(integers.stream().mapToInt(Integer::intValue)
                        .sum() % 2 != 0 ? n -> n % 2 == 0 : n -> n % 2 != 0)
                .collect(Collectors.toList());
    }
}
