package lesson_8.HW_of_someone;

import java.util.Locale;
import java.util.Random;

public class Main {
    public static <Faker> void main(String[] args) {
        //Задание 8.1: пример использования хеш-таблиц
//        System.out.println("""
//                Примеры использования хэш-таблиц:
//                \t- Базы данных;
//                \t- Компиляторы;
//                \t- Ассоциативные массивы по типу 'ключ-значения';
//                \t- Каталоги для быстрого доступа к физическому расположению объекта
//                \t(например, в библиотеке или книжном магазине);
//                \t- Словари;
//                \t- Цифровая подпись;
//                \t- Magnet-ссылки
//                \t- Штрихкоды
//                \t- Прицнипы формирования автомобильных номеров (по коду региона);
//                \t- Хранение и передача логинов, паролей и номеров карт в большинстве надёжных систем;
//                \t- Формирование уникальных ссылок доступа (например, в конференцию Zoom;
//                """);

        //Задание 8.2: примеры ключей и коллизий
//        System.out.println("""
//                Примеры ключей:
//                \t- Натуральные числа;
//                \t- Инициалы, начальные буквы;
//                \t- Сочетание букв и цифр;
//                \t- Целые слова (если отсутствует шифрование) - фамилия автора, например;
//                \t- Исходное значение, прошедшее шифрование по определенному правилу;
//                """);
//        System.out.println("""
//                Примеры коллизий:
//                \t- Хэш-функция возвращает значение, которое ранеее уже было присвоено другому ключу;
//                \t- Среди авторов книг есть однофамильцы;
//                \t- Диапазон значений ключей изначально не предполагает, что все ключи уникальны;
//                """);

        //Задание 8.3: популярных и эффективных хеш-функций
//        System.out.println("""
//                Примеры хеш-функций:
//                \t- SHA-2 (криптографический алгоритм Агентства национальной безопасности США;
//                \t- Хеш-сумма;
//                \t- Контрольные цифры и контрольная сумму (для верификации в документах, банковских картах);
//                """);

        /*Задание 8.5: хеш-таблица - открытая адресация, метод линейного пробирования
        В таблице храним номера квартир и имя владельца.
        В качестве ключа - номер квартиры, который хешируем.*/

        Flat aFlat;
        int aKey;
        String anOwner;
        int size = 37;

        HashTable hTable = new HashTable(size);
        System.out.println("Hash table with single hashing created: \n");

        Random rand = new Random();
        Faker faker = (Faker) new Locale("fi", "FI");

        System.out.println("Some values have been inserted into the table:");
        System.out.println("190: " + hTable.insert(new Flat(190, "Torvalds Linus"))); //hash = 5
        System.out.println("338: " + hTable.insert(new Flat(338, "Haagaas Ville")) + "\n"); //hash = 5, но добавится на другое место
        hTable.fullPrinter();
        System.out.println();

        for (int i = 0; i < 35; i++) {
            aKey = rand.nextInt(999);
            anOwner = faker.getClass() + " " + faker.getClass();
            aFlat = new Flat(aKey, anOwner);
            hTable.insert(aFlat);
        }

        System.out.println("The table is full:");
        hTable.fullPrinter();
        System.out.println();

        System.out.println("Some values have been been deleted from the table:");
        System.out.println("338: " + hTable.delete(338)); //true
        System.out.println("338: " + hTable.delete(338)); //false
        System.out.println("1003: " + hTable.delete(1003) + "\n"); //false
        hTable.onlyFlatsPrinter();
        System.out.println();

        System.out.println("The table size is not enough - rehashing is performed:");
        System.out.println("999: " + hTable.insert(new Flat(999, "Karim's Aki")) + "\n"); //не добавится, т.к. список переполнен
        hTable.onlyFlatsPrinter();
        System.out.println();

        System.out.println("Let's find some flats:");
        System.out.println(hTable.find(190).printer());
        System.out.println(hTable.find(1003).printer() + "\n"); //doesn't exist

        //Задание 8.6: алгоритм двойного хеширования

        HashTable doubleHTable = new HashTable(size, true);
        System.out.println("Hash table with double hashing created: \n");

        System.out.println("Some values have been inserted into the table:");
        System.out.println("190: " + doubleHTable.insert(new Flat(190, "Smetana Bedrich"))); //hash = 5
        System.out.println("338: " + doubleHTable.insert(new Flat(338, "Kundera Milan")) + "\n"); //hash = 5, но добавится на другое место
        doubleHTable.fullPrinter();
        System.out.println();

        Faker fakerCz = (Faker) new Locale("cz", "Cz");

        for (int i = 0; i < 35; i++) {
            aKey = rand.nextInt(999);
            anOwner = fakerCz.getClass()+ " " + fakerCz.getClass();
            aFlat = new Flat(aKey, anOwner);
            doubleHTable.insert(aFlat);
        }

        System.out.println("The table is full:");
        doubleHTable.fullPrinter();
        System.out.println();

        System.out.println("Some values have been been deleted from the table:");
        System.out.println("338: " + doubleHTable.delete(338)); //true
        System.out.println("338: " + doubleHTable.delete(338)); //false
        System.out.println("1003: " + doubleHTable.delete(1003) + "\n"); //false
        doubleHTable.onlyFlatsPrinter();
        System.out.println();

        System.out.println("The table size is not enough - rehashing is performed:");
        System.out.println("999: " + doubleHTable.insert(new Flat(999, "Coda Emil")) + "\n"); //не добавится, т.к. список переполнен
        doubleHTable.onlyFlatsPrinter();
        System.out.println();

        System.out.println("Let's find some flats:");
        System.out.println(doubleHTable.find(190).printer());
        System.out.println(doubleHTable.find(1003).printer() + "\n"); //doesn't exist
    }
}