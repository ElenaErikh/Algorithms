package lesson3_hw;

class Link<T>{

    private T link;
    private Link<T> next;

    public Link(T link) {
        this.link = link;
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public T getValue() {
        return link;
    }
}

class myLinkedList<T>{
    //      ОДНОСВЯЗНЫЙ СПИСОК

    private Link<T> first;

    public myLinkedList() {
        first = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insert(T link){
        Link<T> l = new Link<>(link);
        l.setNext(first);
        this.first = l;
    }

    public Link<T> delete(T link){
        Link<T> temp = first;
        first = first.getNext();
        return temp;
    }

    public void display(){
        Link<T> current = first;
        while (current != null){
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println("");
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


