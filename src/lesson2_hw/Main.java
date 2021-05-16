package lesson2_hw;

import java.util.Arrays;

public class Main {

    static int[] arr = new int[20];

    public static void main(String[] args) {

//    Задание 2.1
//    На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных
//    или ссылочных типов данных. Выполните обращение к массиву и базовые операции класса Arrays.
//    Оценить выполненные методы с помощью базового класса System.nanoTime().

        int[] arrSecond;
        int[] arrThird;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
        }

        System.out.println("Созданный массив arr: " + Arrays.toString(arr));

        long start = System.nanoTime();
        arrSecond = Arrays.copyOfRange(arr, 0, arr.length / 2);
        System.out.println("time of copying: " + (System.nanoTime() - start) + " ns");

        System.out.println("Скопированный массив arrSecond: " + Arrays.toString(arrSecond));

        start = System.nanoTime();
        Arrays.sort(arr);
        System.out.println("time of sorting arr: " + (System.nanoTime() - start) + " ns");

        System.out.println("Отсортированный массив: " + Arrays.toString(arr));

        start = System.nanoTime();
        Arrays.sort(arrSecond);
        System.out.println("time of sorting arrSecond: " + (System.nanoTime() - start) + " ns");

        System.out.println("Отсортированный массив arrSecond: " + Arrays.toString(arrSecond));

        start = System.nanoTime();
        arrThird = Arrays.copyOf(arr, arr.length);
        System.out.println("time of copying arrThird: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        System.out.println("Сравниваем массивы arr и arrThird: " + Arrays.equals(arr, arrThird));
        System.out.println("time of comparing arrays: " + (System.nanoTime() - start) + " ns");

//  Задание 2.2
//  На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск. Оценить алгоритмы линейного и
//  двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте уже существующий массив данных.

        start = System.nanoTime();
        System.out.println("----Линейный поиск----");
        System.out.println("Искомый элемент найден: " + findElement(5));
        System.out.println("time of searching: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        System.out.println("----Двоичный поиск----");
        System.out.println("Искомый элемент найден: " + binarySearch(21));
        System.out.println("time of searching: " + (System.nanoTime() - start) + " ns");

//  Задание 2.3
//  Создайте массив размером 400 элементов. Выполните сортировку с помощью метода sort().
//  Оцените сортировку с помощью базового класса System.nanoTime().

        int[] bigArray = new int[400];
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = (int) (Math.random() * 1000);
        }

        int[] bigArray2 = Arrays.copyOf(bigArray, bigArray.length);
        int[] bigArray3 = Arrays.copyOf(bigArray, bigArray.length);
        int[] bigArray4 = Arrays.copyOf(bigArray, bigArray.length);

        start = System.nanoTime();
        Arrays.sort(bigArray);
        System.out.println("time of sorting bigArray: " + (System.nanoTime() - start) + " ns");


//    Задание 2.4
//    На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
//    Оцените сортировку с помощью базового класса System.nanoTime().
//    Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.

        int buff;
        boolean sorted = false;

        start = System.nanoTime();
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < bigArray2.length - 1; i++) {
                if (bigArray2[i] > bigArray2[i + 1]) {
                    sorted = false;
                    buff = bigArray2[i];
                    bigArray2[i] = bigArray2[i + 1];
                    bigArray2[i + 1] = buff;
                }
            }
        }
        System.out.println("time of bubbleSort: " + (System.nanoTime() - start) + " ns");
        System.out.println("Sorted bigArray2: " + Arrays.toString(bigArray2));


//    Задание 2.5
//    На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
//    Оцените сортировку с помощью базового класса System.nanoTime().
//    Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.

        start = System.nanoTime();
        for (int i = 0; i < bigArray3.length - 1; i++) {
            int minValue = i;
            for (int j = i + i; j < bigArray3.length; j++) {
                if (bigArray3[j] < bigArray3[minValue]) {
                    minValue = j;
                }
            }
            changeValue(bigArray3, i, minValue);
        }
        System.out.println("time of sortSelect: " + (System.nanoTime() - start) + " ns");
        System.out.println("Sorted bigArray3: " + Arrays.toString(bigArray3));


//    Задание 2.6
//    На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
//    Оцените сортировку с помощью базового класса System.nanoTime().
//    Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.

        start = System.nanoTime();

        int value;
        for (int i = 1; i < bigArray4.length; i++) {
            buff = bigArray4[i];
            value = i;
            while (value > 0 && bigArray4[value - 1] >= buff) {
                bigArray4[value] = bigArray4[value - 1];
                --value;
            }
            bigArray4[value] = buff;
        }
        System.out.println("time of sortInsert: " + (System.nanoTime() - start) + " ns");
        System.out.println("Sorted bigArray4: " + Arrays.toString(bigArray4));
    }

    public static boolean findElement(int elem) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int elem) {
        int first = 0;
        int last = arr.length - 1;
        int mid;
        while (first <= last) {
            mid = (first + last) / 2;
            if (elem == arr[mid]) {
                return true;
            } else {
                if (elem < arr[mid]) {
                    last = mid - 1;
                } else {
                    first = mid + 1;
                }
            }
        }
        return false;
    }

    public static void changeValue(int[] arr, int first, int last) {
        int val = arr[first];
        arr[first] = arr[last];
        arr[last] = val;
    }


}

