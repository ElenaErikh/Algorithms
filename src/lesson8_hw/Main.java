package lesson8_hw;

import java.util.Random;

class Item{
    private int data;

    public Item(int data) {
        this.data = data;
    }

    public int getKey(){
        return this.data;
    }
}

class HashTable {
    private Item[] hashArr;
    private int arrSize;
    private Item nonItem;
    private int nonVal;
    private int positiveNum;

    public HashTable(int size) {
        this.arrSize = size;
        nonVal = -1;
        positiveNum = 38;
        hashArr = new Item[arrSize];
        nonItem = new Item(nonVal);
    }

    public void display() {
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null) {
                System.out.println(hashArr[i].getKey());
            } else {
                System.out.println("0");
            }
        }
    }

    public int hashFunc(int key) {
        return key % arrSize;
    }

    public int hashFuncDouble(int key){
        return positiveNum - key % positiveNum;
    }

    public void lineInsert(Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != nonVal) {
            ++hashVal;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = item;
    }

    public void doubleHashInsert(Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != nonVal) {
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = item;
    }

    public Item lineDelete(int key) {
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                Item temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item doubleHashDelete(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                Item temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item lineFind(int key) {
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                return hashArr[hashVal];
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item doubleHashFind(int key) {
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
}

public class Main {
    public static void main(String[] args) {

        Item myItem;
        int myKey;
        int size = 30;
        int bound = 5;

        // линейное пробирование
        HashTable lineHashTable = new HashTable(size);
        Random rand = new Random();

        for (int i = 0; i < bound; i++) {
            myKey = rand.nextInt(500);
            myItem = new Item(myKey);
            lineHashTable.lineInsert(myItem);
        }

        lineHashTable.lineInsert(new Item(456));
        lineHashTable.lineInsert(new Item(18));
        lineHashTable.lineInsert(new Item(102));
        lineHashTable.lineInsert(new Item(36));

        System.out.println("---линейное пробирование---");
        lineHashTable.display();


        // двойное хеширование
        HashTable doubleHashTable = new HashTable(size);

        for (int i = 0; i < bound; i++) {
            myKey = rand.nextInt(5000);
            myItem = new Item(myKey);
            doubleHashTable.doubleHashInsert(myItem);
        }

        doubleHashTable.doubleHashInsert(new Item(2211));
        doubleHashTable.doubleHashInsert(new Item(1800));
        doubleHashTable.doubleHashInsert(new Item(1024));
        doubleHashTable.doubleHashInsert(new Item(3006));

        doubleHashTable.doubleHashDelete(1024);

        System.out.println("---двойное хеширование---");
        doubleHashTable.display();

    }
}
