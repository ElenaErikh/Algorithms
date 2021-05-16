package lesson_6.BinaryHeap;

import java.util.Arrays;
import java.util.Random;

class HeapSort{  // класс сортировки массива с помощью кучи
    private static int heapSize;

    public static void sort(int[] a){
        buildHeap(a);
        while (heapSize > 1){
            swap(a, 0, heapSize - 1);
            heapSize--;
            heapify(a, 0);
        }
    }

    private static void buildHeap(int[] a){  // строим кучу из массива
        heapSize = a.length;
        for (int i = a.length / 2; i >= 0 ; i--) {
            heapify(a, i);
        }
    }

    private static void heapify(int[] a, int i){
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heapSize && a[i] < a[l]){  // если левый элемент меньше размера массива, и a[i] меньше левого элемента
            largest = l;   // то левый самый большой
        }
        if (r < heapSize && a[largest] < a[r]){
            largest = r;
        }
        if (i != largest){
            swap(a, i, largest);
            heapify(a, largest);
        }
    }

    private static int right(int i){
        return 2 * i + 2;
    }

    private static int left(int i){
        return 2 * i + 1;
    }

    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr;
        Random rand = new Random();
        arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10);
        }
        System.out.println(Arrays.toString(arr));
        HeapSort arrSort = new HeapSort();

        arrSort.sort(arr);

        System.out.println(Arrays.toString(arr));
















    }

}
