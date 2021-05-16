package lesson_4.PriorityQueue_Deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Random;

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
        Deque<ArrayObj> quObj = new ArrayDeque<>();
        quObj.add(new ArrayObj(5, 1));
        quObj.add(new ArrayObj(1, 1));
        quObj.add(new ArrayObj(3, 2));

        quObj.addFirst(new ArrayObj(2, 1));
        quObj.addLast(new ArrayObj(2, 1));

        while (!quObj.isEmpty()) {
            quObj.poll().print();
        }

        quObj.add(new ArrayObj(60, 55));

        quObj.addFirst(new ArrayObj(77, 84));
        quObj.addLast(new ArrayObj(9, 8));

        System.out.println("Poll and peek");

        quObj.pollFirst().print();
        quObj.pollLast().print();
        quObj.peekFirst().print();
        quObj.peekLast().print();

        System.out.println("Prior");

        PriorityQueue<Integer> prior = new PriorityQueue<>();

        Random rand = new Random();

        prior.add(9);
        prior.add(3);
        prior.add(7);
        prior.offer(5);

        while (!prior.isEmpty()){
            System.out.println(prior.poll());
        }





    }
}
