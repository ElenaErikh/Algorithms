package lesson_3.TwoSidedLinkedList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> mArray = new LinkedList<>();

        ArrayList<String> mArrayCopy = new ArrayList<>(mArray);

//        mArrayCopy.addAll(0, mArray);
//        Collections.copy(mArrayCopy, mArray);

        mArray.add("One");
        mArray.add("Two");
        mArray.add("Three");
        mArrayCopy.addAll(mArray);

        System.out.println(mArray.equals(mArrayCopy));
        System.out.println(mArray.hashCode());

        System.out.println(mArray);

        mArray.add(1, "Four");
        System.out.println(mArray);
        mArray.set(2, "Set");
        System.out.println(mArray);
        System.out.println("Elem 2: " + mArray.get(2));

        mArray.remove(1);
        System.out.println(mArray);
        mArray.remove("Set");
        System.out.println(mArray);

        mArray.addFirst("first");
        mArray.addLast("last");

        System.out.println(mArray.peekFirst());
        System.out.println(mArray.peekLast() + "\n");

        System.out.println(mArray.pollFirst());
        System.out.println(mArray.pollLast() + "\n");

        System.out.println(mArray + "\n");
        if (mArray.contains("One")) {
            System.out.println("Contains One");
        }

        LinkedList<ArrObj> mArrayObj = new LinkedList<>();

        mArrayObj.add(new ArrObj(1, 2));
        mArrayObj.add(new ArrObj(3, 2));
        mArrayObj.add(new ArrObj(5, 8));

        //mArrayObj.set(2, new ArrObj(1, 2));

        System.out.println(mArrayObj.get(1));
        System.out.println(mArrayObj);
        mArrayObj.get(0);

        for (ArrObj number : mArrayObj) {
            number.print();
            System.out.println(number.getX() + " " + number.getY());
        }


        // Итераторы
        System.out.println("Итераторы--------------------------------------------------------------");
        Iterator<String> iter = mArray.iterator(); // стандартный итератор
        while (iter.hasNext()){
            System.out.println(iter.next()+"\n");
            iter.remove();
        }

        ListIterator<ArrObj> iter1 = mArrayObj.listIterator(); // расширенный итератор
        while (iter1.hasNext()){
            iter1.next();
        }

        Random rand = new Random();

        ArrObj m;

        while (iter1.hasPrevious()){
            m = iter1.previous();
            m.print();
            iter1.set(new ArrObj(rand.nextInt(10), rand.nextInt(10)));
        }

        System.out.println("");

        for (ArrObj number : mArrayObj) {
            number.print();
            //System.out.println(number.getX() + " " + number.getY());
        }



    }
}
