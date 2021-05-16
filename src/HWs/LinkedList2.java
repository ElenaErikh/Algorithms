package HWs;

import java.util.Iterator;

public class LinkedList2<T>  implements Iterable<T>{
    private Link2<T> first = new Link2<>();
    private Link2<T> last = new Link2<>();



    public void add(T link) {

        if (first.next == null) {
            Link2<T> node = new Link2<>();
            node.value = link;
            first.next = node;
        }
        if (last.prev == null) {
            last.prev = first.next;
            return;
        }

        Link2<T> node = new Link2<>();
        node.value = link;

        Link2<T> lastNode = last.prev;
        lastNode.next = node;

        node.prev = lastNode;
        last.prev = node;
    }

    public T getT(int index) {
        Link2<T> itemNode = first.next;
        int i = -1;
        while (itemNode != null && index > i){
            i++;
            if (i == index)
                return itemNode.value;
            itemNode = itemNode.next;
        }
        return null;
    }

    public Link2<T> get(int index) {
        Link2<T> itemNode = first.next;
        int i = -1;
        while (itemNode != null && index > i){
            i++;
            if (i == index) {
                return itemNode;
            }
            itemNode = itemNode.next;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private Link2<T> current = first;

            @Override
            public boolean hasNext() {
                if (current.next == null){
                    Link2<T> oldCurrent = current;
                    current = first;
                    return oldCurrent.next != null;
                }
                else
                    return current.next != null;
            }

            @Override
            public T next() {
                current = current.next;
                return current.value;
            }

            @Override
            public void remove() {
                if (first.next == null & last.next == null)
                    throw new UnsupportedOperationException();

                Link2<T> prevLast = last.prev;
                Link2<T> prev2Last = prevLast.prev;
                last.prev = prev2Last;
                prev2Last.next = null;
                prevLast.next = null;
                prevLast.prev = null;
            }
        };
        return it;
    }
}
