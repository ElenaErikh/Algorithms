package lesson_4.StackList;

// Стек на базе связанного списка

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

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty(){
        return first == null;//проверяем пустой список или нет. если первый элемент пустой, значит весь список пуст.
    }

    public void insert(String name, int age){
        Link newLink = new Link(name, age);
        newLink.next = first; // ссылка на след элемент
        first = newLink; // говорим, что следующий теперь первый
    }

    public Link delete(){ // сначала надо проверить на isEmpty()
        Link temp = first;
        first = first.next; // говорим, что наш элемент = следующему элементу. т.е. мы перестаем ссылаться на
        // текущий элемент и потом garbage collector его просто удалит
        return temp;
    }

    public void display(){
        Link current = first; // current = текущий индекс
        while (current != null){
            current.display();
            current = current.next;
        }
    }
}

class StackList{
    private LinkedList list;

    public StackList() {
        list = new LinkedList();
    }

    public void push(String name, int age){
        list.insert(name, age);
    }

    public String pop(){
        return list.delete().name;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void display(){
        list.display();
    }

}

public class Main {
    public static void main(String[] args) {

        StackList sl = new StackList();

        sl.push("Artem", 30);
        sl.push("Viktor", 48);
        sl.push("Sergey", 10);

        sl.display();

        while (!sl.isEmpty()){
            System.out.println("Элемент " + sl.pop() + " удален из стека");
        }
    }

}
