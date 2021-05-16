package lesson_4.Stack;

import java.util.Random;
import java.util.Stack;

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
        Stack<ArrayObj> stObj = new Stack<>();

        stObj.push(new ArrayObj(4, 5));
        stObj.push(new ArrayObj(5, 5));
        stObj.push(new ArrayObj(1, 6));
        stObj.push(new ArrayObj(3, 1));

        stObj.peek().print();

        while (!stObj.empty()){
            stObj.pop().print();
        }

        System.out.println(stObj.empty());

        StackM stack = new StackM(5);

        Random rand = new Random();

        while (!stack.isFull()){
            stack.push(rand.nextInt(10));
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}


class StackM{
    private int maxSize;
    private int[] stack;  // стэк реализуется на базе массива
    private int top;

    public StackM(int size) {
        this.maxSize = size;
        this.stack = new int[this.maxSize];
        this.top = -1;  // по правилам он должен равняться именно -1, а не null
    }

    public void push(int i){ //добавляем элемент
        this.stack[++this.top] = i;
    }

    public int pop(){  // уменьшает top, а значит последующее добавление начнется на место удаленного элемента
        return this.stack[this.top--];
    }

    public int peek(){
        return this.stack[this.top];
    }

    public boolean isEmpty(){
        return (this.top == -1);
    }

    public boolean isFull(){
        return (this.top == this.maxSize-1);
    }


}

