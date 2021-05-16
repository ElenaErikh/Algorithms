package lesson4_hw;

import java.util.*;

public class Main {

    private static final int size = 10;
    private static final int bound = 100;

    public static void main(String[] args) {

        // Задание 4.1.

        System.out.println("----Stack----");
        Stack<MyClass> stack = new Stack();

        long start = System.nanoTime();
        stack.push(new MyClass(11, 'c'));
        stack.push(new MyClass(101, 'w'));
        stack.push(new MyClass(230, 'a'));
        stack.push(new MyClass(3, 'n'));
        System.out.println("time of adding elements: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        stack.peek().info();
        System.out.println("time of printing first element: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        while (!stack.empty()) {
            stack.pop().info();
        }
        System.out.println("time of printing & deleting elements: " + (System.nanoTime() - start) + " ns");


        // Задание 4.2.

        System.out.println("----Queue----");
        Queue<MyClass> queue = new LinkedList<>();

        start = System.nanoTime();
        queue.add(new MyClass(11, 'c'));
        queue.add(new MyClass(101, 'w'));
        queue.add(new MyClass(230, 'a'));
        queue.add(new MyClass(3, 'n'));
        System.out.println("time of adding elements: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        queue.peek().info();
        System.out.println("time of printing one element: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        queue.add(new MyClass(1000, 'D'));
        System.out.println("time of adding one element: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        queue.remove();
        System.out.println("time of removing one element: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        while (!queue.isEmpty()) {
            queue.poll().info();
        }
        System.out.println("time of printing & deleting elements: " + (System.nanoTime() - start) + " ns");

        // Задание 4.3.

        System.out.println("----Deque----");
        Deque<MyClass> deque = new ArrayDeque<>();

        start = System.nanoTime();
        deque.add(new MyClass(11, 'c'));
        deque.add(new MyClass(101, 'w'));
        deque.add(new MyClass(230, 'a'));
        deque.add(new MyClass(3, 'n'));
        System.out.println("time of adding elements: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        deque.addLast(new MyClass(123, 'E'));
        System.out.println("time of adding one element: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        deque.peekLast().info();
        System.out.println("time of printing one element: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        deque.pollFirst().info();
        System.out.println("time of deleting one element: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        while (deque.isEmpty()) {
            deque.poll().info();
        }
        System.out.println("time of printing & deleting elements: " + (System.nanoTime() - start) + " ns");

        // Задание 4.4.

        System.out.println("----PriorityQueue----");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Random rand = new Random();

        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            pq.add(rand.nextInt(bound));
        }
        System.out.println("time of adding elements: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        System.out.println(pq.peek());
        System.out.println("time of printing one element: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        pq.offer(54);
        System.out.println("time of offering one element: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        pq.remove();
        System.out.println("time of removing one element: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        System.out.println(pq.contains(25));
        System.out.println("time of finding one element: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
        System.out.println("time of printing & deleting elements: " + (System.nanoTime() - start) + " ns");

        // Задание 4.5.

        System.out.println("----StackList----");
        StackList sl = new StackList();

        start = System.nanoTime();
        sl.push(11, 'c');
        sl.push(101, 'w');
        sl.push(230, 'a');
        sl.push(3, 'n');
        System.out.println("time of adding elements: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        sl.display();
        System.out.println("time of printing one element: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        while (!sl.isEmpty()){
            System.out.println("Элемент " + sl.pop() + " удален из стека");
        }
        System.out.println("time of printing & deleting elements: " + (System.nanoTime() - start) + " ns");


        System.out.println("----LinkedQueue----");
        LinkedQueue q = new LinkedQueue();

        start = System.nanoTime();
        q.insert(11, 'c');
        q.insert(101, 'w');
        q.insert(230, 'a');
        q.insert(3, 'n');
        System.out.println("time of adding elements: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        q.display();
        System.out.println("time of printing one element: " + (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        while (!q.isEmpty()){
            System.out.println("Элемент " + q.delete() + " удален из стека");
        }
        System.out.println("time of printing & deleting elements: " + (System.nanoTime() - start) + " ns");

    }
}
