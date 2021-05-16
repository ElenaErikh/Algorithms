package HWs;

import java.util.ArrayList;

public class LinkedList_loc<T> {
    private Link_loc<T> first;

    public LinkedList_loc(){
        first = null;
    }

    public boolean inEmpty(){
        return (first == null);
    }

    public void insert(T link){
        Link_loc<T> l = new Link_loc<>(link);
        l.setNext(first);
        this.first = l;
    }

    public Link_loc<T> delete(){
        Link_loc<T> temp = first;
        first = first.getNext();
        return temp;
    }

    public void display(){
        Link_loc<T> current = first;
        while (current != null){
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public ArrayList<T> linkToArr(){
        Link_loc<T> current = first;
        ArrayList<T> aL= new ArrayList<>();
        while (current != null){
            aL.add(current.getValue());
            current = current.getNext();
        }
        return aL;
    }

    public T find(T searchNode){
        Link_loc<T> findNode = new Link_loc<>(searchNode);
        Link_loc<T> current = first;
        while (current != null){
            if (current.getValue().equals(findNode.getValue())){
                return  findNode.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    public T get(int index){
        Link_loc<T> current = first;
        int lenList = 0;

        while (current != null){
            lenList++;
            current = current.getNext();
        }
        current = first;
        int searchInd = -1;
        while (current != null & lenList - searchInd != index ){
            searchInd++;
            if (lenList - searchInd - 1 == index){
                return  current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

}
