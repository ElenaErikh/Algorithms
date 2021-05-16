package lesson4_hw;

class MyLinkedList<T>{

    private MyClass first;

    public MyLinkedList() {
        first = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insert(int number, char c){
        MyClass newLink = new MyClass(number, c);
        newLink.next = first;
        first = newLink;
    }

    public int delete(){
        MyClass temp = first;
        first = first.next;
        return temp.getNumber();
    }

    public void display(){
        MyClass current = first;
        while (current != null){
            current.info();
            current = current.next;
        }
    }
}

class StackList{
    private MyLinkedList list;

    public StackList() {
        list = new MyLinkedList();
    }

    public void push(int number, char c){
        list.insert(number, c);
    }

    public int pop(){
        return list.delete();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void display(){
        list.display();
    }

}
