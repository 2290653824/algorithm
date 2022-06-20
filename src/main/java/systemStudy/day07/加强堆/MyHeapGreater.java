package systemStudy.day07.加强堆;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MyHeapGreater<T> {

    private ArrayList<T> heap;
    private HashMap<T,Integer> hashMap;
    private int heapSize;
    private Comparator<T> comp;


    public MyHeapGreater(Comparator comp){
        this.comp=comp;
        heap=new ArrayList<T>();
        hashMap=new HashMap<T,Integer>();
        heapSize=0;
    }

    public void resign(T obj){
        heapInsert(hashMap.get(obj));
        heapIfy(hashMap.get(obj));
    }


    public void heapIfy(int index){
        int left=index*2+1;
        while(left<heapSize){
            int min=left+1<heapSize&&comp.compare(heap.get(left),heap.get(left+1))>0?left+1:left;
            min=comp.compare(heap.get(min),heap.get(index))<0?min:index;
            if(min==index){
                break;
            }

            swap(min,index);
            index=min;
            left=index*2+1;
        }
    }

    public void heapInsert(int index){
        while(comp.compare(heap.get(index),heap.get((index-1)/2))<0){
                  swap(index,(index-1)/2);
                  index=(index-1)/2;
        }


    }

    public void swap(int a,int b){
        T o1=heap.get(a);
        T o2=heap.get(b);
        heap.set(a,o2);
        heap.set(b,o1);
        hashMap.put(o1,b);
        hashMap.put(o1,a);

    }

}
