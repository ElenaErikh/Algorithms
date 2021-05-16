package HWs;

public class Link_loc<T> {
    private T link;
    private Link_loc<T> next;

    public Link_loc(T link) {
        this.link = link;
    }

    public Link_loc<T> getNext() {
        return next;
    }

    public void setNext(Link_loc<T> next) {
        this.next = next;
    }

    public T getValue() {
        return link;
    }
}
