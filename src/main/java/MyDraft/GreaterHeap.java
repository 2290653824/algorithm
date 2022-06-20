package MyDraft;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * 小根堆
 * @param <T>
 */
public class GreaterHeap<T> {


    public static void main(String[] args) {
        GreaterHeap<Integer> integerGreaterHeap = new GreaterHeap<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        integerGreaterHeap.push(1);
        integerGreaterHeap.push(2);
        integerGreaterHeap.push(3);
        integerGreaterHeap.push(4);
        integerGreaterHeap.push(2);
        integerGreaterHeap.push(6);
        integerGreaterHeap.push(2);
        integerGreaterHeap.push(76);

        System.out.println(integerGreaterHeap.list);

        for(int i=0;i<integerGreaterHeap.list.size();i++){
            integerGreaterHeap.swap(0,--integerGreaterHeap.heapSize);
            integerGreaterHeap.heapIfy(0,integerGreaterHeap.heapSize);
        }

        System.out.println(integerGreaterHeap.list);
    }

    ArrayList<T> list=new ArrayList<>();
    int heapSize;
    HashMap<T, Integer> indexMap=new HashMap<>();
    Comparator<T> comp;

    public void push(T t){
        if(t==null) return;
        list.add(t);
        indexMap.put(t,heapSize);
        heapSize++;
        heapInsert(heapSize-1);

    }

    public T pop(){
        if(heapSize==0) {
            throw new RuntimeException("堆已经空了");
        }
        T t=list.get(0);
        swap(0,heapSize-1);
        indexMap.remove(t);
        return t;
    }


    public void heapInsert(int index){
        while(comp.compare(list.get(index),list.get((index-1)/2))<0){
            swap(index,(index-1)/2);
            index=(index-1)/2;

        }
    }

    public void resign(int index){
        heapIfy(index,heapSize);
        heapInsert(index);
    }

    public void heapIfy(int index,int size){
        int left=index*2+1;
        while(left<size){
            int min=(left+1<size)&&(comp.compare(list.get(left),list.get(left+1))>0)?left+1:left;
            min=comp.compare(list.get(index),list.get(min))<0?index:min;
            if(index==min){
                break;
            }
            swap(index,min);
            index=min;
            left=index*2+1;
        }
    }

    public GreaterHeap(Comparator<T> comparator){
        this.comp=comparator;
    }

    public void swap(int a,int b){
        T o1=list.get(a);
        T o2=list.get(b);
        indexMap.put(o1,b);
        indexMap.put(o2,a);
        list.set(a,o2);
        list.set(b,o1);
    }






}
