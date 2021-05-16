package HWs.HW4;


public class DequeClass <T> {
    private DequeNode<T> back = new DequeNode<>();
    private DequeNode<T> front = new DequeNode<>();
    private boolean isEmpty = true;

    public void pushBack(T link) {
        if (back.next == null) {
            DequeNode<T> newElement = new DequeNode<>();
            newElement.value = link;
            back.next = newElement;
            front.prev = newElement;
            isEmpty = false;
            return;
        }

        DequeNode<T> newElement = new DequeNode<>();
        newElement.value = link;
        newElement.next = back.next;
        back.next = newElement;

        if (newElement.next != null){
            DequeNode<T> oldBackNext;
            oldBackNext = newElement.next;
            oldBackNext.prev = newElement;
        }
        isEmpty = false;
    }

    public void pushFront(T link) {
        if (front.prev == null) {
            DequeNode<T> newElement = new DequeNode<>();
            newElement.value = link;
            back.next = newElement;
            front.prev = newElement;
            isEmpty = false;
            return;
        }

        DequeNode<T> newElement = new DequeNode<>();
        newElement.value = link;
        newElement.prev = front.prev;
        front.prev = newElement;

        if (newElement.prev != null){
            DequeNode<T> oldFrontPrev;
            oldFrontPrev = newElement.prev;
            oldFrontPrev.next = newElement;
        }
        isEmpty = false;
    }

    public DequeNode<T> popBack() {
        DequeNode<T> result = back.next;
        if (back.next == null) {
            isEmpty = true;
        }
        else {
            if (back.next.next != null){
                back.next.next.prev = null;
                back.next = back.next.next;
            }
            else {
                back.next = null;
                front.prev = null;
                isEmpty = true;
            }
        }
        return result;
    }

    public DequeNode<T> popFront() {
        DequeNode<T> result = front.prev;
        if (front.prev == null) {
            isEmpty = true;
        }
        else {
            if (front.prev.prev != null) {
                front.prev.prev.next = null;
                front.prev = front.prev.prev;
            }
            else {
                front.prev = null;
                back.next = null;
                isEmpty = true;
            }
        }
        return result;
    }

    public T peekBack() {
        return back.next.value;
    }

    public T peekFront() {
        return front.prev.value;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
