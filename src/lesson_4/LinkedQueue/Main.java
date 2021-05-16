package lesson_4.LinkedQueue;

// очередь на базе связанного списка  (односвязного списка)

class Link{
    // ЭТОТ КЛАСС ОПИСАНИЕ ДЛЯ ОДНОГО ЭЛЕМЕНТА КОЛЛЕКЦИИ

    public String name;
    public int age;

    public Link next;

    public Link(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("Name: " + this.name + ", age: " + this.age);}
}

class LinkedList<T>{
    //      ОДНОСВЯЗНЫЙ СПИСОК

    private Link first; // создаем начальный элемент. не может быть пустого списка, в нем всегда существует первый элемент.
    private Link last;

    public LinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;//проверяем пустой список или нет. если первый элемент пустой, значит весь список пуст.
    }

    public void insert(String name, int age){
        Link newLink = new Link(name, age);
        if (this.isEmpty()){
            first = newLink;
        } else {
            last.next = newLink;// добавляем элемент в конец списка
        }
        last = newLink; // говорим, что последний элемент это текущий добавленный
    }

    public String delete(){ // сначала надо проверить на isEmpty()
        Link temp = first;
        if (first.next == null){
            last = null;
        }
        first = first.next; // говорим, что наш элемент = следующему элементу. т.е. мы перестаем ссылаться на
        // текущий элемент и потом garbage collector его просто удалит
        return temp.name;
    }

    public void display(){
        Link current = first; // current = текущий индекс
        while (current != null){
            current.display();
            current = current.next;
        }
    }
}

class LinkedQueue{
    private LinkedList queue;

    public LinkedQueue() {
        queue = new LinkedList();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void insert(String name, int age){ // вставляет элемент в конец очереди
        queue.insert(name, age);
    }

    public String delete(){   // удаляет элемент из начала очереди
        return queue.delete();
    }

    public void display(){
        queue.display();
    }

}

public class Main {
    public static void main(String[] args) {
        LinkedQueue q = new LinkedQueue();
        q.insert("Artem", 30);
        q.insert("Viktor", 20);
        q.insert("Sergey", 10);
        q.display();

        while (!q.isEmpty()){
            System.out.println("Элемент " + q.delete() + " удален из стека");
        }


    }


}
