package HWs.HW4;

public class QueueClass<T> {
    QueueNode <T> first;
    QueueNode <T> last;
    private boolean isEmpty = true;
    private boolean isFull = false;
    private long size = 0;
    public long maxSize = 0;

    public QueueClass(long maxSize) {
        this.maxSize = maxSize;
    }

    public long getSize() {
        return size;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean isFull() {
        return isFull;
    }

    //Добавить в конец
    public void offer(T node) {
        if (!isFull) {
            QueueNode<T> newNode = new QueueNode<>();
            if (first == null) {
                last = newNode;
                newNode.value = node;
                first = last;
            } else {
                last.next = newNode;
                newNode.value = node;
                last = last.next;
            }
            size++;
            if (size == maxSize)
                isFull = true;
            isEmpty = false;
        }
    }

    //Удалить вначале
    public T poll() {
        T buf = first.value;
        if (first == last) {
            first = null;
            last = null;
            isEmpty = true;
        }
        else {
            first = first.next;
            size--;
            if (first == null)
                isEmpty = true;
        }
        if (isFull)
            isFull = false;
        return buf;
    }

    public T peek(){
        return first.value;
    }
}
