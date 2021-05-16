package lesson_8;

public class Main {

    public static void hash(char x){
        System.out.println((x >> 15) ^ x);  // функция взята базово из инета
    }

    public static void hashFunc(char key, int f){
        System.out.println(key % f);
    }

    public static void main(String[] args) {
        String hashstr = "Test";
        char hashchar = 't';
        System.out.println(hashstr.hashCode());
        hash(hashchar);
        hashFunc(hashchar, 10);  // означает, что все значения ключа будут в диапазоне до 10
    }
}
