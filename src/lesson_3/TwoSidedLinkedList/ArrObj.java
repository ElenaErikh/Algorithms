package lesson_3.TwoSidedLinkedList;

public class ArrObj {
    private int x;
    private int y;

    public ArrObj(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.println("X: " + this.x + "; Y: " + this.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
