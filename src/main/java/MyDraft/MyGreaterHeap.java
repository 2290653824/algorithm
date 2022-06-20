package MyDraft;

import org.omg.CORBA.INTERNAL;

import java.util.*;

public class MyGreaterHeap {

    public static void main(String[] args) {
        MyGreaterHeap myGreaterHeap = new MyGreaterHeap();
        myGreaterHeap.array.add(1);
        myGreaterHeap.array.add(2);
        myGreaterHeap.array.add(3);
        myGreaterHeap.array.add(4);
        myGreaterHeap.array.add(5);
        for(int i = 0; i <5;i++){
            myGreaterHeap.heapInsert(i);
            myGreaterHeap.size++;
        }
        System.out.println(myGreaterHeap.array);
        myGreaterHeap.array.set(1,-2);
        myGreaterHeap.resign(1);
        System.out.println(myGreaterHeap.array);
    }

    int size;
    Map<Integer,Integer> indexMap;
    List<Integer> array;

    public MyGreaterHeap(){
        indexMap=new HashMap<>();
        array=new ArrayList<>();
    }

    public void swap(int a,int b){
        Integer o1=array.get(a);
        Integer o2=array.get(b);
        indexMap.put(o1,b);
        indexMap.put(o2,a);
        array.set(a,o2);
        array.set(b,o1);
    }

    public void resign(int index){
        heapInsert(index);
        heapIfy(index);
    }
    public void heapInsert(int index){
        while(array.get(index)>array.get((index-1)/2)){
            swap(index,(index-1)/2);
            index=(index-1)/2;
        }
    }

    public void heapIfy(int index){
        int left=index*2+1;
        while(left<size){
            int max=left+1<size&&array.get(left+1)> array.get(left)?
                    left+1:left;
            max=max>index?max:index;
            if(max==index) break;
            swap(max,index);
            index=max;
            left=index*2+1;

        }
    }
}
