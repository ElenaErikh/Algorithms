package lesson4_hw;

class LinkedQueueList<T> {

    private MyClass first;
    private MyClass last;

    public LinkedQueueList() {
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insert(int number, char c){
        MyClass newLink = new MyClass(number, c);
        if (this.isEmpty()){
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public int delete(){
        MyClass temp = first;
        if (first.next == null){
            last = null;
        }
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

class LinkedQueue{
    private LinkedQueueList queue;

    public LinkedQueue() {
        queue = new LinkedQueueList();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void insert(int number, char c){
        queue.insert(number, c);
    }

    public int delete(){
        return queue.delete();
    }

    public void display(){
        queue.display();
    }

}
