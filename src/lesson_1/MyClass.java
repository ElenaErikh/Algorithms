package lesson_1;

public class MyClass {

    static String s = "Hello";

    private char c;
    private int number;
    private int[] data;

    public MyClass(int number, char c) {
        this.number = number;
        this.c = c;
        data = new int[] {10, 3, 6, 8, 1, 9, 2};
    }

    public void info() {
        System.out.printf("Class info: %s, %d, %c\n", s, number, c);
    }

    public void findElement(int num){
        for (int i = 0; i < data.length; i++) {
            if (data[i] == num){
                System.out.println("The number " + num + " is found!");
                return;
            }
        }
        System.out.println("The number " + num + " is not there.....");
    }
}
