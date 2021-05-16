package lesson_3.LinkedList;

class Link<T>{
    // ЭТОТ КЛАСС ОПИСАНИЕ ДЛЯ ОДНОГО ЭЛЕМЕНТА КОЛЛЕКЦИИ

    private T link;  // сам элемент
    private Link<T> next; // ссылка на след элемент

    public Link(T link) {
        this.link = link;
    }

    public Link<T> getNext() {
        return next; // возвращает следующий индекс
    }

    public void setNext(Link<T> next) {
        this.next = next; // переводит с текущего индекса на следующий
    }

    public T getValue() {
        return link; // получение элемента из объекта
    }
}

class LinkedList<T>{
    //      ОДНОСВЯЗНЫЙ СПИСОК

    private Link<T> first; // создаем начальный элемент. не может быть пустого списка, в нем всегда существует первый элемент.

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty(){
        return first == null;//проверяем пустой список или нет. если первый элемент пустой, значит весь список пуст.
    }

    public void insert(T link){
        Link<T> l = new Link<>(link); // создаем элемент, которому присваиваем значение link
        l.setNext(first); // ссылка на след элемент
        this.first = l; // говорим нашему элементу, что у него появилась новая ссылка
    }

    public Link<T> delete(){ // сначала надо проверить на isEmpty()
        Link<T> temp = first;
        first = first.getNext(); // говорим, что наш элемент = следующему элементу. т.е. мы перестаем ссылаться на
        // текущий элемент и потом garbage collector его просто удалит
        return temp;
    }

    public void display(){
        Link<T> current = first; // current = текущий индекс
        while (current != null){
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public T find(T searchNode){
        Link<T> findNode = new Link<>(searchNode);
        Link<T> current = first;
        while (current != null){
            if (current.getValue().equals(findNode.getValue())){
                return findNode.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

}

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.insert("Artem");
        list.insert("Roman");

        list.display();

        System.out.println("\n" + list.find("Artem"));
    }

}
