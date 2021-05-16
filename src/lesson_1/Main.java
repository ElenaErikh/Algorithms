package lesson_1;

public class Main {
    public static void main(String[] args) {

        MyClass mc = new MyClass(55, 'R');
        mc.info();


        long start = System.nanoTime();

        mc.findElement(5);

        System.out.println("time: " + (System.nanoTime() - start) + " ns");

    }

}
