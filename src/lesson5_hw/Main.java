package lesson5_hw;

import java.util.Arrays;

public class Main {

    private static char[] charArr = new char[]{'A', 'B', 'C', 'D', 'E'};
    private static int[] intArr = new int[20];

    private static int val1 = 0;
    private static char c = charArr[val1];
    private static int bound = 100;


    public static void main(String[] args) {

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = (int) (Math.random() * bound);
        }

        //infiniteRec();

        long start = System.nanoTime();
        //simpleRec();
        System.out.println("time of simple recursion: " + (System.nanoTime() - start) + " ns");

        //go();

        start = System.nanoTime();
        //goToC();
        System.out.println("time of stack recursion: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        //circle();
        System.out.println("time of circle: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        //System.out.println(recBinaryFind(5, 0, intArr.length - 1, intArr));
        System.out.println("time of recBinaryFind: " + (System.nanoTime() - start) + " ns");

        System.out.println(Arrays.toString(intArr));

        start = System.nanoTime();
        System.out.println(Arrays.toString(sortMerge(intArr)));
        System.out.println("time of sortMerge: " + (System.nanoTime() - start) + " ns");

    }

    //Задание 5.1
    //Приведите пример использования рекурсии.

    // Путь из пункта А в пункт В и обратно. Путь пролегает через пункты С, D, E.
    // Схематично: А --> С --> D --> E --> В
    //             В --> E --> D --> C --> A

    //Задание 5.2
    // Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.

    public static int infiniteRec() {
        System.out.println("Пункт " + c);
        c = charArr[++val1];

        if (val1 == charArr.length - 1) {
            val1 = -1;
        }
        return infiniteRec();
    }

    public static int simpleRec() {
        System.out.println("Пункт " + c);
        c = charArr[++val1];
        if (val1 == charArr.length - 1) {
            System.out.println("Пункт " + c);
            return charArr.length;
        }
        return simpleRec();
    }

    //Задание 5.3
    //Приведите пример изображающий стек вызова.

    public static void go() {
        toA();
        toB();
        toC();
    }

    public static void toA() {
        System.out.println("Стартуем из пункта А");
    }

    public static void toB() {
        System.out.println("Дошли до пункта В");
    }

    public static void toC() {
        System.out.println("Дошли до пункта C");
    }

    //Приведите пример изображающий стек вызова с рекурсией.

    public static char goToC() {
        if (c == 'A') {
            toA();
            c = 'B';
        }
        if (c == 'B') {
            toB();
            c = 'C';
        }
        if (c == 'C') {
            toC();
            return c;
        }
        return goToC();
    }

    //Задание 5.4
    //Реализуйте простой алгоритм использующий цикл.

    public static void circle() {
        System.out.println("Начинаем путь");

        for (char c : charArr) {
            System.out.println("Пункт " + c);
        }

        System.out.println("Идем назад");

        for (int i = charArr.length-1; i >= 0; i--) {
            System.out.println("Пункт " + charArr[i]);
        }
    }

    //Реализуйте простой алгоритм использующий рекурсию.
    //См. simpleRec(), goToC().


    //Задание 5.5
    //Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1.

    public static int recBinaryFind(int searchKey, int low, int high, int[] arr){

        if(low > high){
            return arr.length;
        }
        int mid = (low + high) / 2;

        if (arr[mid] == searchKey){
            return mid;
        }else if (arr[mid] < searchKey){
            return recBinaryFind(searchKey, mid + 1, high, arr);
        }else {
            return recBinaryFind(searchKey, low, mid - 1, arr);
        }
    }

    //Задание 5.6
    //На основе массива из задания 2.1 реализуйте алгоритм сортировки слиянием.

    public static int[] sortMerge(int[] arr){
        int len = arr.length;

        if (len < 2){
            return arr;
        }

        int middle = len / 2;
        return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)), sortMerge(Arrays.copyOfRange(arr, middle, len)));
    }

    public static int[] merge(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length + arr2.length];
        int val1 = 0;
        int val2 = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] = arr1[val1] < arr2[val2] ? arr1[val1++] : arr2[val2++];
            if (val1 == arr1.length){
                System.arraycopy(arr2, val2, result, ++i, arr2.length - val2);
                break;
            }
            if (val2 == arr2.length){
                System.arraycopy(arr1, val1, result, ++i, arr1.length - val1);
                break;
            }
        }
        return result;
    }


}
