package lesson_5;

import java.util.Arrays;
import java.util.Random;

public class Main {

    //пример правильной рекурсии с условием для выхода из нее
    public static int countdown(int n){
        System.out.println(n);
        if(n == 1){
            return n;
        }
        return countdown(n - 1);
    }

    // пример двоичного рекурсивного поиска
    public static int recBinaryFind(int searchKey, int low, int high, int[] arr){

        if(low > high){  // условие для выхода из рекурсии
            return arr.length;
        }
        int mid = (low + high) / 2;

        if (arr[mid] == searchKey){
            return mid;  // выводим индекс где находится искомое число
        }else if (arr[mid] < searchKey){
            return recBinaryFind(searchKey, mid + 1, high, arr);
        }else {
            return recBinaryFind(searchKey, low, mid - 1, arr);
        }
    }

    // пример сортировки слиянием
    public static int[] sortMerge(int[] arr){
        int len = arr.length;

        if (len < 2){  // если длина массива <= 1, те там нечего сортировать
            return arr;
        }

        int middle = len / 2;
        // разбиваем массив на два подмассива
        return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)), sortMerge(Arrays.copyOfRange(arr, middle, len)));
    }

    public static int[] merge(int[] a, int[] b){
        // сравниваем оба подмассива сортируя их
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;

        for (int i = 0; i < result.length; i++) {
            // если условие a[aIndex] < b[bIndex] true, то присваиваем левое значание, иначе - правое
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            // смотрим какой индекс первее достиг конца своего подмассива
            if (aIndex == a.length){
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length){
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //пример правильной рекурсии
        int n = 10;
        countdown(n);

        // пример рекурсивного поиска
        int[] arr;
        arr = new int[7];

        arr[0] = 5;
        arr[1] = 3;
        arr[2] = 4;
        arr[3] = 7;
        arr[4] = 9;
        arr[5] = 2;
        arr[6] = 1;

        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(recBinaryFind(4, 0, arr.length - 1, arr));

        // пример сортировки методом выбора
        int[] arr2;
        Random rand = new Random();
        arr2 = new int[10];

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = rand.nextInt(10);
        }

        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(sortMerge(arr2)));

    }

}
