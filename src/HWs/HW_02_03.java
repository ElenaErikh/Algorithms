package HWs;


import java.util.*;

public class HW_02_03 {

    static final int COUNTTV = 10000000;
    static final int MAXCHANNEL = 500;
    static final int MAXWEIHT = 10000000;
    static final int MAXVOLUME = 100;
    static final int MAXSTATEPOWER = 2;

    public static int random(int r){
        return (int)(Math.random() * r);
    }

    public static void main(String[] args) {

        TV[] tv = new TV[COUNTTV];
        //Создадим массив тв
        for (int i = 0; i < tv.length; i++) {
            tv[i] = new TV(random(MAXCHANNEL) + 1, random(MAXVOLUME) + 1, random(MAXSTATEPOWER) == 1, random(MAXWEIHT) + 1);
            //System.out.println(tv[i].getTVProp() + "; " + tv[i]);
        }

        System.out.println("Здание №1:");
        List<TV> tvList = task_1_1(tv);
        LinkedList<TV> tvLinkedList = task_1_2(tv);


        System.out.println("Здание №2:");
        int numTV = random(COUNTTV);
        int numAddTV = random(COUNTTV);
        TV rndTV = tvLinkedList.get(numTV);
        task_2(tvLinkedList, rndTV, numAddTV);

        System.out.println("Здание №3:");
        LinkedList_loc<TV> lll = task_3(tv);
        int rndTVNum = random(COUNTTV);
        System.out.println("Хочу найти TV с номером " + rndTVNum + ": " + tv[rndTVNum].getTVProp());
        TV findTV = task_3_1(lll, tv[rndTVNum]);
        System.out.println("Нашёл TV: " + findTV.getTVProp());
        rndTVNum = random(COUNTTV);
        System.out.println("Хочу получить TV с номером " + rndTVNum + ": " + tv[rndTVNum].getTVProp());
        findTV = task_3_2(lll, rndTVNum);
        System.out.println("Получил TV: " + findTV.getTVProp() + "\n");

        System.out.println("Здание №4:");
        LinkedList2<TV> l2l = task_4(tv);
        rndTVNum = random(COUNTTV);
        System.out.println("Хочу получить TV с номером " + rndTVNum + ": " + tv[rndTVNum].getTVProp());
        findTV = task_4_1(l2l, rndTVNum);
        System.out.println("Получил TV: " + findTV.getTVProp() + "\n");

        System.out.println("Здание №5:");
        task_5(l2l);

    }

    public static ArrayList<TV> task_1_1(TV[] tv){
        ArrayList<TV> tvArrayList;
        long timeStart = System.nanoTime();
        tvArrayList = new ArrayList<>(Arrays.asList(tv));
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время преобразования массива в коллекцию: " + timeFinish + " нс");
        return tvArrayList;
    }

    public static LinkedList<TV> task_1_2(TV[] tv){
        LinkedList<TV> tvLinkedList;
        long timeStart = System.nanoTime();
        tvLinkedList = new LinkedList<>(Arrays.asList(tv));
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время преобразования массива в список: " + timeFinish + " нс\n");
        return tvLinkedList;
    }

    public static void task_2(LinkedList<TV> tvLinkedList, TV tv, int index){
        addToLinkedList(tvLinkedList, tv);
        addToLinkedListIndex(tvLinkedList, tv, index);
        deleteFromLinkedList(tvLinkedList);
        deleteFromLinkedListIndex(tvLinkedList, index);
        getLinkedListIndex(tvLinkedList, index);
        getLinkedListFirst(tvLinkedList);
        getLinkedListLast(tvLinkedList);
    }

    public static void addToLinkedList(LinkedList<TV> tvLinkedList, TV tv){
        long timeStart = System.nanoTime();
        tvLinkedList.add(tv);
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время добавления в конец списка: " + timeFinish + " нс");
    }

    public static void addToLinkedListIndex(LinkedList<TV> tvLinkedList, TV tv, int index){
        long timeStart = System.nanoTime();
        tvLinkedList.add(index, tv);
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время добавления в указанную позицию списка: " + timeFinish + " нс");
    }

    public static void deleteFromLinkedList(LinkedList<TV> tvLinkedList){
        long timeStart = System.nanoTime();
        tvLinkedList.remove();
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время удаления первого элемента списка: " + timeFinish + " нс");
    }

    public static void deleteFromLinkedListIndex(LinkedList<TV> tvLinkedList, int index){
        long timeStart = System.nanoTime();
        tvLinkedList.remove(index);
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время удаления элемента заданного элемента: " + timeFinish + " нс");
    }

    public static void getLinkedListIndex(LinkedList<TV> tvLinkedList, int index){
        long timeStart = System.nanoTime();
        tvLinkedList.get(index);
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время получения заданного элемента: " + timeFinish + " нс");
    }

    public static void getLinkedListFirst(LinkedList<TV> tvLinkedList){
        long timeStart = System.nanoTime();
        tvLinkedList.getFirst();
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время получения первого элемента: " + timeFinish + " нс");
    }

    public static void getLinkedListLast(LinkedList<TV> tvLinkedList){
        long timeStart = System.nanoTime();
        tvLinkedList.getLast();
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время получения последнего элемента: " + timeFinish + " нс\n");
    }

    public static LinkedList_loc<TV> task_3(TV[] array){
        long timeStart = System.nanoTime();
        LinkedList_loc<TV> result = new LinkedList_loc<>();
        for (TV tv : array) {
            result.insert(tv);
        }
        System.out.println("----------my ----- "+result.get(2));
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время создания одностороннего списка из массива: " + timeFinish + " нс");
        return result;
    }

    public static TV task_3_1(LinkedList_loc<TV> lll, TV searchTV){
        long timeStart = System.nanoTime();
        TV findTV = lll.find(searchTV);
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время поиска: " + timeFinish + " нс");
        return searchTV;
    }

    public static TV task_3_2(LinkedList_loc<TV> lll, int numTV){
        long timeStart = System.nanoTime();
        TV findTV = lll.get(numTV);
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время получения: " + timeFinish + " нс");
        return findTV;
    }

    public static LinkedList2<TV> task_4(TV[] array){
        long timeStart = System.nanoTime();
        LinkedList2<TV> result = new LinkedList2<>();
        for (TV tv : array) {
            result.add(tv);
        }
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время создания двустороннего списка из массива: " + timeFinish + " нс");
        return result;
    }

    public static TV task_4_1(LinkedList2<TV> l2l, int numTV){
        long timeStart = System.nanoTime();
        TV findTV = l2l.getT(numTV);
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время получения: " + timeFinish + " нс");
        return findTV;
    }

    public static void task_5(LinkedList2<TV> l2l){
        int lenList = 0;
        System.out.println("Подсчитаю кол-во элементов через итератор:");
        long timeStart = System.nanoTime();
        Iterator<TV> iterL2LTV = l2l.iterator();
        while (iterL2LTV.hasNext()){
            iterL2LTV.next();
            lenList++;
        }
        System.out.println("Кол-во элементов в списке: " + lenList);
        long timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время работы итератора: " + timeFinish + " нс");

        System.out.println("Пробую удалить через итератор последний элемент");
        timeStart = System.nanoTime();
        iterL2LTV.remove();
        timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время удаления: " + timeFinish + " нс");

        System.out.println("Подсчитаю кол-во элементов после удаления последнего элемента");
        timeStart = System.nanoTime();
        lenList = 0;
        while (iterL2LTV.hasNext()){
            iterL2LTV.next();
            lenList++;
        }
        System.out.println("Кол-во элементов в списке: " + lenList);
        timeFinish = System.nanoTime() - timeStart;
        System.out.println("Время работы итератора: " + timeFinish + " нс");
    }



}
