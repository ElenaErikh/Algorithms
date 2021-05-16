package lesson_4.Queue;

import java.util.LinkedList;
import java.util.Queue;

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
        Queue<ArrayObj> quObj = new LinkedList<>();

        quObj.add(new ArrayObj(5, 1));
        quObj.add(new ArrayObj(1, 1));
        quObj.add(new ArrayObj(3, 2));

        while (!quObj.isEmpty()){
            quObj.poll().print();
        }

        QueueM q = new QueueM(5);

        q.insert(10);
        q.insert(20);
        q.insert(30);
        q.insert(40);
        q.insert(50);
        q.remove();
        q.remove();

//        System.out.println(" size-------"+ q.size());
//        System.out.println(" current-------"+ q.peek());

        q.insert(60);
        q.insert(70);
        q.insert(80);
        while (!q.isEmpty()){
            System.out.println(q.remove());
        }
    }

}

class QueueM{
   private int maxSize;
   private int[] queue;
   private int front; // первый элемент
   private int rear; // маркер конца очереди
   private int items;  // количество элементов в очереди

    public QueueM(int a) {
        maxSize = a;
        queue = new int[maxSize]; // создаем очередь
        front = 0; // начальное количество элементов
        rear = -1;
        items = 0; // количество элементов на данный момент
    }

    public void insert(int i){
        if (rear == maxSize - 1){
            rear = -1; // если маркер достиг конца очереди, то переводим его в начальную позицию
        }
        queue[++rear] = i; // увелич маркер на 1 вставляем на эту позицию элемент
        items++;           // кол-во элементов в очереди увеличилось на 1
    }

    public int remove(){ // по умолч удаляет самый первый добавленный элемент
        int temp = queue[front++]; // вернет второй элемент
        if (front == maxSize){  // в массив добавляли, добавляли и если первый элемент достиг конца массива
            front = 0;         // первый элемент = 0. т.о. мы никогда не превысим размер массива
        }
        items--;
        return temp;  // здесь всё просто работа с ссылками, какую ссылку присваиваем, то и будет, сказали, что
        // предпоследний элемент теперь последний и всё.
    }

    public int peek(){   // возврат текущего элемента
        return queue[front];
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull(){
        return (items == maxSize);
    }

    public int size(){
        return items;
    }







}