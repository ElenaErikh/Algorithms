package lesson_3.ArrayList;

import java.util.ArrayList;

class ArrayObj {
    private int x;
    private int y;

    public ArrayObj(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.println("X: " + this.x + "; Y: " + this.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {

    public static void main(String[] args) {
        ArrayList<String> mArray = new ArrayList<>();

        ArrayList<String> mArrayCopy = new ArrayList<>(mArray);
//        mArrayCopy.addAll(0, mArray);
//        Collections.copy(mArrayCopy, mArray);

        mArray.add("One");
        mArray.add("Two");
        mArray.add("Three");

        System.out.println(mArray);

        mArray.add(1, "Four");
        System.out.println(mArray);
        mArray.set(2, "Set");
        System.out.println(mArray);
        System.out.println("Elem 2: "+mArray.get(2));

        mArray.remove(1);
        System.out.println(mArray);
        mArray.remove("Set");
        System.out.println(mArray);


        ArrayList<ArrayObj> mArrayObj = new ArrayList<>();

        mArrayObj.add(new ArrayObj(1, 2));
        mArrayObj.add(new ArrayObj(3, 6));
        mArrayObj.add(new ArrayObj(5, 8));
        System.out.println(mArrayObj);

        mArrayObj.set(2, new ArrayObj(1, 2));
        System.out.println(mArrayObj);

        System.out.println(mArrayObj.get(1));

        for (ArrayObj number : mArrayObj) {
            number.print();
            //System.out.println(number.getX() + " " + number.getY());
        }

    }



}
