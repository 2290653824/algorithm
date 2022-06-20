package MyDraft;

import com.sun.org.apache.xerces.internal.impl.dv.xs.IntegerDV;

import java.util.Arrays;

public class Dueue1 {

    public static void main(String[] args) {
        Dueue1 dueue1 = new Dueue1(4);
        dueue1.in(1);
        dueue1.in(2);
        dueue1.in(3);
        dueue1.in(4);
//        dueue1.in(2);
        dueue1.out();
        dueue1.in(4);
        System.out.println(Arrays.toString(dueue1.getArr()));
    }

    private int pre;
    private int next;
    private int[] arr;
    private int size;
    private int limit;

    public int getPre() {
        return pre;
    }

    public void setPre(int pre) {
        this.pre = pre;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Dueue1(int limit){
        this.limit=limit;
        arr=new int[limit];
    }
    public int getNext(int index){
        return index<limit-1?index+1:0;

    }

    public boolean isFull(){
        return size==limit;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void in(int x){
        if(isFull()){
            throw new RuntimeException("队列已经满了");
        }
        arr[next]=x;
        next=getNext(next);
        size++;
    }

    public int out(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int x=arr[pre];
        pre=getNext(pre);
        size--;
        return x;

    }

}
