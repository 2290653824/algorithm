package systemStudy.day07.加强堆;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * 加强堆。增加了反向索引表
 *
 * 小根堆
 */
public class HeapGreater<T> {

    //存放堆的数组
    private ArrayList<T> heap;

    //反向索引表
    private HashMap<T,Integer> indexMap;

    //堆大小
    private int heapSize;

    //比较器
    private Comparator<? super T> comp;


    //初始化这个加强堆
    public HeapGreater(Comparator<T> c){
        this.comp=c;
        indexMap=new HashMap<>();
        heapSize=0;
        heap=new ArrayList<>();
    }

    public boolean isEmpty(){
        return this.heapSize==0;
    }

    public int size(){
        return this.heapSize;
    }

    public boolean contains(T obj){
        return indexMap.containsKey(obj);
    }

    public T peek(){
        return heap.get(0);
    }

    public void push(T obj){
        heap.add(obj);
        indexMap.put(obj,heapSize);
        heapInsert(heapSize++);
    }

    public T pop(){
        T ans=heap.get(0);
        swap(0,heapSize-1);  //将头移动到尾部
        indexMap.remove(ans);
        heap.remove(--heapSize);
        heapify(0);    //从头开始重新调整堆的位置
        return ans;
    }

    //移除堆上的任意一个节点
    public void remove(T obj){
        T replace=heap.get(heapSize-1);
        int index=indexMap.get(obj);
        indexMap.remove(obj);
        heap.remove(--heapSize);
        if(obj!=replace){
            heap.set(index,replace);
            indexMap.put(replace,index);
            resign(replace);
        }

    }

    /**
     * 对指定的堆节点进行堆调整
     * @param obj
     */
    public void resign(T obj){
        heapInsert(indexMap.get(obj));
        heapify(indexMap.get(obj));
    }

    /**
     * 返回所有元素
     * @return
     */
    public List<T> returnAllElements(){
        ArrayList<T> ts = new ArrayList<>();
        for(T t: heap){
            ts.add(t);
        }
        return ts;
    }

    /**
     * 堆中最后一个元素加入到堆中
     * @param index
     */
    public void heapInsert(int index){
        while(comp.compare(heap.get(index),heap.get((index-1)/2))<0){
            swap(index,(index-1)/2);
            index=(index-1)/2;

        }
    }

    /**
     * 调整指定位置的元素，使之堆化
     * @param index
     */
    public void heapify(int index){
        int left=index*2+1;
        while(left<heapSize){
            int best=left+1<heapSize&&comp.compare(heap.get(left+1),heap.get(left))<0?(left+1):left;
            best=comp.compare(heap.get(best),heap.get(index))<0?best:index;
            if(best==index){
                break;
            }
            swap(best,index);
            index=best;
            left=index*2+1;
        }
    }

    /**
     * 交换
     * @param i
     * @param j
     */
    public void swap(int i,int j){
        T o1=heap.get(i);
        T o2=heap.get(j);
        heap.set(i,o2);
        heap.set(j,o1);
        indexMap.put(o2,i);
        indexMap.put(o1,j);

    }












}
