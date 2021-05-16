package HWs.HW4;


import java.util.*;

public class HW_02_04 {
    static final int COUNTTV = 1_000;
    //static final int COUNTTV = 5;

    public static int random(int r){
        return (int)(Math.random() * r);
    }
    static TV[] tv = new TV[COUNTTV];
    //Создадим массив тв
        //System.out.println(tv[i].getTVProp() + "; " + tv[i]);



    public static void main(String[] args) {
        //TV[] tv = createRndArray(COUNTTV, false);
        LinkedList2<TV> l2l = task_4(tv);

        System.out.println("Здание №1:");
        StackClass <TV> stack = task_4_1_1(l2l, true);
        task_4_1_2(stack);
        task_4_1_3(stack);
        task_4_1_4(stack);

        System.out.println("\nЗдание №2:");
        QueueClass <TV> queue = task_4_2_1(l2l, true);
        task_4_2_2(queue);
        task_4_2_3(queue);
        task_4_2_4(queue);

        System.out.println("\nЗдание №3:");
        DequeClass <TV> dequeue = task_4_3_1(l2l);
        task_4_3_6(dequeue);
        task_4_3_7(dequeue);
        task_4_3_2(dequeue);    //Проход по дэку c хвоста
        DequeClass <TV> dequeue2 = task_4_3_1(l2l);
        task_4_3_3(dequeue2);   //Проход по дэку c начала
        task_4_3_4(dequeue, tv[random(COUNTTV)]);  //добавление в начало дэка
        task_4_3_4(dequeue, tv[random(COUNTTV)]);  //добавление в начало дэка
        task_4_3_5(dequeue, tv[random(COUNTTV)]);  //добавление в конец дэка
        task_4_3_3(dequeue);   //Проход по дэку c начала

        System.out.println("\nЗдание №4:");
        PriorityQueue<Integer> priorQueue = task_4_4_1();
        task_4_4_3(priorQueue);

        System.out.println("\nЗдание №5:");
        StackClass <TV> stack5 = task_4_1_1(l2l, false);
        task_4_5_1(stack5);
        QueueClass <TV> queue5 = task_4_2_1(l2l, false);
        task_4_5_2(queue5);
    }

    public static StackClass <TV> task_4_1_1(LinkedList2<TV> l2l, boolean showTime){
        int lenStack = 0;
        long timeStart = System.nanoTime();
        Iterator<TV> iterL2LTV = l2l.iterator();
        StackClass <TV> result = new StackClass<>();
        while (iterL2LTV.hasNext()){
            result.push(iterL2LTV.next());
            lenStack++;
        }
        long timeFinish = System.nanoTime() - timeStart;
        if (showTime)
            System.out.println("Время заполнения стека из двусвязанного списка, размером = " + lenStack + ", составляет: " + timeFinish + " нс");
        return result;
    }

    public static void task_4_1_2(StackClass <TV> stack){
        long timeStart = System.nanoTime();
        stack.pop();
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время удаления верхнего элемента из стека: " + timeFinish + " нс");
    }

    public static void task_4_1_3(StackClass <TV> stack){
        long timeStart = System.nanoTime();
        stack.peek();
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время получения верхнего элемента из стека: " + timeFinish + " нс");
    }

    public static void task_4_1_4(StackClass <TV> stack){
        int lenStack = 0;
        long timeStart = System.nanoTime();
        while (!stack.isEmpty()) {
            //System.out.println(stack.peek().getTVProp());
            stack.pop();
            lenStack++;
        }
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время прохождения по стеку, размером = " + lenStack + ", составляет: " + timeFinish + " нс");
    }

    public static QueueClass <TV> task_4_2_1(LinkedList2<TV> l2l, boolean showTime){
        int lenQueue = 0;
        long timeStart = System.nanoTime();
        Iterator<TV> iterL2LTV = l2l.iterator();
        QueueClass <TV> result = new QueueClass<>(COUNTTV);
        while (iterL2LTV.hasNext()){
            result.offer(iterL2LTV.next());
            lenQueue++;
        }
        long timeFinish = System.nanoTime() - timeStart;
        if (showTime){
            System.out.println("Время заполнения очереди из двусвязанного списка, размером = " + lenQueue + ", составляет: " + timeFinish + " нс");
            System.out.println("Размер очереди = " + result.getSize());
            if (result.isFull())
                System.out.println("Очередь полна");
            else
                System.out.println("В очереди есть место");
        }
        return result;
    }

    public static void task_4_2_2(QueueClass <TV> queue){
        long timeStart = System.nanoTime();
        queue.poll();
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время удаления из очереди: " + timeFinish + " нс");
    }

    public static void task_4_2_3(QueueClass <TV> queue){
        long timeStart = System.nanoTime();
        queue.peek();
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время получения элемента из очереди: " + timeFinish + " нс");
    }

    public static void task_4_2_4(QueueClass <TV> queue){
        int lenQueue = 0;
        long timeStart = System.nanoTime();
        while (!queue.isEmpty()) {
            //System.out.println(queue.peek().getTVProp());
            queue.poll();
            lenQueue++;
        }
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время прохождения по очереди, размером = " + lenQueue + ", составляет: " + timeFinish + " нс");
    }

    public static LinkedList2<TV> task_4(TV[] array){
        long timeStart = System.nanoTime();
        LinkedList2<TV> result = new LinkedList2<>();
        for (TV tv : array) {
            result.add(tv);
        }
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время создания двустороннего списка из массива: " + timeFinish + " нс");
        return result;
    }

    public static DequeClass <TV> task_4_3_1(LinkedList2<TV> l2l){
        System.out.println("Буду заполнять дэк из двусвязанного списка");
        int lenQueue = 0;
        long timeStart = System.nanoTime();
        Iterator<TV> iterL2LTV = l2l.iterator();
        DequeClass <TV> result = new DequeClass<>();
        while (iterL2LTV.hasNext()){
            result.pushBack(iterL2LTV.next());
            lenQueue++;
        }
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время заполнения дэка из двусвязанного списка, размером = " + lenQueue + ", составляет: " + timeFinish + " нс\n");
        return result;
    }

    public static void task_4_3_2(DequeClass <TV> queue) {
        System.out.println("Проход по дэку c хвоста");
        int lenQueue = 0;
        long timeStart = System.nanoTime();
        while (!queue.isEmpty()) {
            //System.out.println(queue.peekBack().getTVProp());
            queue.popBack();
            lenQueue++;
        }
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время прохождения по дэку c хвоста, размером = " + lenQueue + ", составляет: " + timeFinish + " нс\n");
    }

    public static void task_4_3_3(DequeClass <TV> queue){
        System.out.println("Проход по дэку c начала");
        int lenQueue = 0;
        long timeStart = System.nanoTime();
        while (!queue.isEmpty()) {
            //System.out.println(queue.peekFront().getTVProp());
            queue.popFront();
            lenQueue++;
        }
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время прохождения по дэку c начала, размером = " + lenQueue + ", составляет: " + timeFinish + " нс\n");
    }

    public static void task_4_3_4(DequeClass <TV> queue, TV tv){
        //System.out.println("Буду добавлять в начало дэка: " + tv.getTVProp());
        System.out.println("Буду добавлять в начало дэка");
        long timeStart = System.nanoTime();
        queue.pushFront(tv);
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время добавление в начало дэка: " + timeFinish + " нс\n");
    }

    public static void task_4_3_5(DequeClass <TV> queue, TV tv){
        //System.out.println("Буду добавлять в конец дэка: " + tv.getTVProp());
        System.out.println("Буду добавлять в конец дэка");
        long timeStart = System.nanoTime();
        queue.pushBack(tv);
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время добавление в конец дэка: " + timeFinish + " нс\n");
    }

    public static void task_4_3_6(DequeClass <TV> queue){
        System.out.println("Буду получать последний элемент дэка");
        long timeStart = System.nanoTime();
        queue.popFront();
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время получения последнего элемента дэка: " + timeFinish + " нс\n");
    }

    public static void task_4_3_7(DequeClass <TV> queue){
        System.out.println("Буду получать первый элемент дэка");
        long timeStart = System.nanoTime();
        queue.popBack();
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время получения первого элемента дэка: " + timeFinish + " нс\n");
    }

    public static PriorityQueue<Integer> task_4_4_1(){
        System.out.println("Буду создавать приоритетную очередь с помощью случайных чисел");
        long timeStart = System.nanoTime();
        PriorityQueue<Integer> result = new PriorityQueue<>();
        for (int i = 0; i < COUNTTV; i++) {
            result.add(random(COUNTTV));
        }
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время создания приоритетной очереди составляет: " + timeFinish + " нс\n");
        return result;
    }

    public static void task_4_4_3(PriorityQueue<Integer> priorityQueue){
        System.out.println("Буду проходить по приоритетной очереди");
        int len = 0;
        long timeStart = System.nanoTime();
        while (!priorityQueue.isEmpty()){
            priorityQueue.poll();
            len++;
        }
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время прохождения по приоритетной очереди, длиной = " + len + ", составляет: " + timeFinish + " нс\n");
    }

    public static void task_4_5_1(StackClass <TV> stack){
        System.out.println("Буду создавать LinkedList из своего стека");
        int len = 0;
        long timeStart = System.nanoTime();
        LinkedList <TV> ll2FromStack = new LinkedList<>();
        while (!stack.isEmpty()) {
            ll2FromStack.add(stack.pop());
            len++;
        }
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время создания LinkedList из своего стека, длиной = " + len + ", составляет: " + timeFinish + " нс\n");
    }

    public static void task_4_5_2(QueueClass <TV> queue){
        System.out.println("Буду создавать LinkedList из своей очереди");
        int len = 0;
        long timeStart = System.nanoTime();
        LinkedList <TV> ll2FromQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            ll2FromQueue.add(queue.poll());
            len++;
        }
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время создания LinkedList из своей очереди, длиной = " + len + ", составляет: " + timeFinish + " нс\n");
    }

}
