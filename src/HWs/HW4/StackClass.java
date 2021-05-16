package HWs.HW4;

public class StackClass<T> {
    private StackNode <T> top = null;
    private boolean isEmpty = true;

    public boolean isEmpty() {
        return isEmpty;
    }

    //Добавить
    public void push(T node) {
        StackNode<T> newNode = new StackNode<>();
        newNode.value = node;
        newNode.next = top;
        top = newNode;
        isEmpty = false;
    }

    //Удалить
    public T pop(){
        if (top != null) {
            StackNode <T> itemNode = top;
            top = top.next;
            if (top == null)
                isEmpty = true;
            return itemNode.value;
        }
        else {
            isEmpty = true;
            return null;
        }
    }

    public T peek(){
        return top.value;
    }
}
