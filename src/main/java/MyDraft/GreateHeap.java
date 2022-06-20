package MyDraft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class GreateHeap<T>
{

    public static void main(String[] args) {
        GreateHeap<Integer> greateHeap = new GreateHeap<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o1-(Integer) o2;
            }
        });

        greateHeap.push(1);
        greateHeap.push(7);
        greateHeap.push(7);
        greateHeap.push(6);

        greateHeap.push(3);
        greateHeap.push(4);
        System.out.println(greateHeap.heap);
        greateHeap.pop();
        System.out.println(greateHeap.heap);
        greateHeap.heapSort();
        System.out.println(greateHeap.heap);



    }

    List<T> heap=new ArrayList<>();
    HashMap<T,Integer> indexMap=new HashMap<>();
    int size;
    Comparator<T> comp;

    public GreateHeap(Comparator comp){
        this.comp=comp;
    }

    public void heapSort(){
        while(size>0){
            swap(0,--size);
            heapIfy(0);
        }
    }

    public void heapInsert(int index){
        while(index>=0&&comp.compare(heap.get(index),heap.get((index-1)/2))>0){
            swap(index,(index-1)/2);
            index=(index-1)/2;
        }

    }

    public void heapIfy(int index){
        int left=index*2+1;
        while(left<size){
            int max=left+1<size&&comp.compare(heap.get(left),heap.get(left+1))<0?left+1:left;
            max=comp.compare(heap.get(max),heap.get(index))<0?index:max;
            if(max==index){
                break;
            }
            swap(max,index);

            index=max;
            left=index*2+1;
        }
    }

    public void resign(int index){
        heapInsert(index);
        heapIfy(index);
    }

    public T pop(){
        T o=heap.get(0);
        swap(0,size-1);
        heap.remove(size-1);
        size--;
        heapIfy(0);
        return o;
    }

    public void push(T o){
        heap.add(o);
        size++;
        heapInsert(size-1);

    }



    public void swap(int a,int b){
        T o1=heap.get(a);
        T o2=heap.get(b);
        indexMap.put(o1,b);
        indexMap.put(o2,a);
        heap.set(a,o2);
        heap.set(b,o1);
    }



}
