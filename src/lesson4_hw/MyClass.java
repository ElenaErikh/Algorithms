package lesson4_hw;

class MyClass {

    private static String s = "Hello";
    public MyClass next;

    private char c;
    private int number;
    private int[] data;

    public MyClass(int number, char c) {
        this.number = number;
        this.c = c;
        data = new int[] {10, 3, 6, 8, 1, 9, 2};
    }

    public static String getS() {
        return s;
    }

    public char getC() {
        return c;
    }

    public int getNumber() {
        return number;
    }

    public void info() {
        System.out.printf("%s, %d, %c\n", s, number, c);
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
