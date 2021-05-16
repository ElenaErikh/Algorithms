package lesson_8.DoubleHash;

// Двойное хеширование

import java.util.Random;

class Item {
    private int data;

    public Item(int data) {
        this.data = data;
    }

    public int getKey() {
        return this.data;
    }
}

class HashTable {
    private Item[] hashArr;
    private int arrSize;
    private Item nonItem;

    public HashTable(int size) {
        this.arrSize = size;
        hashArr = new Item[arrSize];
        nonItem = new Item(-1);
    }

    public void display() {
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null) { // если в массиве есть значения
                System.out.println(hashArr[i].getKey()); // даннные, что хранятся в ячейке
            } else {
                System.out.println("***");
            }
        }
    }

    public int hashFunc(int key) {
        return key % arrSize;  // умножаем key на наш массив для того, чтобы не выходить за его границы
    }

    public int hashFuncDouble(int key) {
        return 5 - key % 5;  // можно брать любую константу, кот > 0. вернет остаток от деления на 5
    }

    public void insert(Item item) {
        int key = item.getKey(); // ключ по которому делаем хеширование
        int hashVal = hashFunc(key);  // содержит в себе хеш, он у нас содержит число в пределах размера массива,
        // т.е. так мы генерируем индекс массива для вставки туда элемента
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1) { // пока есть значения и мы не дошли до конца массива
            hashVal += stepSize; // перемещаемся не на след элемент, а с шагом
            hashVal %= arrSize; // возвращает перебор к началу таблицы
        }
        hashArr[hashVal] = item;
    }

    public Item delete(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null) { // пока не конец таблицы
            if (hashArr[hashVal].getKey() == key) {
                Item temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;  // т.е. на место элемента вставится число -1, так при распечатке массива мы поймем что элемент был удален
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item find(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                return hashArr[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        return null;
    }

    // Увеличение хеш-таблицы
    //метод ищет простое число, следующее за текущим
    private int getPrime(int min) { // min - то число, которое мы хотим увеличить
        for (int i = min + 1; true; i++) {
            if (isPrime(i)) {
                return i;
            }
        }  // как это подключить можно посмотреть в hw_of_someone
    }

    private boolean isPrime(int n) {
        for (int j = 2; (j * j <= n); j++) {
            if (n % j == 0) { // если есть остаток возвращаем false и в методе getPrime условие true меняется на false
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void hashFunc2(int k, int size) {
        System.out.println(k % size);
    }

    public static void main(String[] args) {
        Item aDataItem;
        int aKey;
        int size = 66;

        HashTable hTable = new HashTable(size);
        Random rand = new Random();

        for (int i = 0; i < 15; i++) {
            aKey = rand.nextInt(999);
            aDataItem = new Item(aKey);
            hTable.insert(aDataItem);
        }

        hTable.insert(new Item(999));
        hTable.insert(new Item(203));

        hTable.display();
        System.out.println("___________________________________");

        hashFunc2(999, 66); // то же самое, что hashFunc, это здесь просто для примера

        System.out.println("find 999:  " + hTable.find(999).getKey());

        hTable.delete(203);
    }
}
