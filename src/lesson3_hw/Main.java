package lesson3_hw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        final int size = 20;
        final int bound = 50;


        // Задание 3.1

        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * bound);
        }

        long start = System.nanoTime();
        ArrayList<Integer> listArr = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            listArr.add(arr[i]);
        }
        System.out.println("time of making arrayList: " + (System.nanoTime() - start) + " ns");



        //Задание 3.2

        System.out.println(listArr);

        start = System.nanoTime();
        listArr.add(2, 88);
        System.out.println("time of adding element: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        listArr.remove(1);
        System.out.println("time of removing element: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        listArr.set(4, 100);
        System.out.println("time of setting element: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        listArr.get(5);
        System.out.println("time of getting element: " + (System.nanoTime() - start) + " ns");
        System.out.println(listArr);


        //Задание 3.3


        myLinkedList<Integer> linArr = new myLinkedList<>();

        linArr.insert(21);
        linArr.insert(5);
        linArr.insert(104);
        linArr.insert(39);

        linArr.delete(4);
        System.out.println(linArr.find(53));
        linArr.display();

        //Задание 3.4

        LinkedList<Integer> linArrCopy = new LinkedList<>(listArr);

        System.out.println("first: "+linArrCopy.getFirst());
        System.out.println("last: "+linArrCopy.peekLast());
        int a = linArrCopy.pollLast();
        System.out.println(a);


        LinkedList<MyClass> mylinArr = new LinkedList<>();

        mylinArr.add(new MyClass(11, 'c'));
        mylinArr.add(new MyClass(101, 'w'));
        mylinArr.add(new MyClass(230, 'a'));
        mylinArr.add(new MyClass(3, 'n'));


        //Задание 3.5

        Iterator<Integer> intIter = linArrCopy.iterator();
        start = System.nanoTime();
        while (intIter.hasNext()){
            System.out.print(intIter.next() +" ");
        }
        System.out.println("");
        System.out.println("time of intIter: " + (System.nanoTime() - start) + " ns");


        ListIterator<MyClass> myIter = mylinArr.listIterator();
        MyClass mc;

        start = System.nanoTime();
        while (myIter.hasNext()){
            mc = myIter.next();
            mc.info();
        }
        System.out.println("time of myIter: " + (System.nanoTime() - start) + " ns");


    }


}

