package ru.javawebinar.basejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainStreams {
    public static void main(String[] args) {
//        int[] values = new int[]{5, 1, 6, 7, 8, 0, 5, 6};
//        System.out.println(minValue(values));
        List<Integer> num = Arrays.asList(1, 2, 8, 9, 5, 10);
        System.out.println(oddOrEvenStream(num));
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
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();

        int odd = 0;
        for (int item : integers) {
            if (item % 2 == 0) {
                evenList.add(item);

            } else {
                oddList.add(item);
                odd += item;
            }
        }
        return odd % 2 == 0 ? evenList : oddList;
    }

    private static List<Integer> oddOrEvenStream(List<Integer> integers) {

        Map<Boolean, List<Integer>> collect = integers.stream()
                .collect(Collectors.groupingBy(x -> x % 2 == 0));

        return collect.get(false).size() % 2 == 0 ? collect.get(true) : collect.get(false);
    }

}
