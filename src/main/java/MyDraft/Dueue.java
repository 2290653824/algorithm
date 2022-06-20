package MyDraft;

import java.util.Arrays;

public class Dueue {

    private int limit;
    private int size;
    private int pre;
    private int next;
    private int[] elem;

    public static void main(String[] args) {
        Dueue dueue = new Dueue(3);
        dueue.in(1);
        dueue.in(2);
        dueue.in(3);
        dueue.out();
//        dueue.in(1);
        dueue.in(10);
        System.out.println(Arrays.toString(dueue.getElem()));
    }

    public Dueue(int limit){
        this.limit=limit;
        this.elem=new int[limit];
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setSize(int size) {
        this.size = size;
    }

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

    public int[] getElem() {
        return elem;
    }

    public void setElem(int[] elem) {
        this.elem = elem;
    }

    public int getNext(int index){
//        if(size==limit){
//            throw new RuntimeException("队列满了");
//        }
        return index<limit-1?index+1:0;
    }

    public void in(int i){
        elem[next]=i;
        next=getNext(next);
        size++;
    }

    public int out(){
        if(size==0){
            throw new RuntimeException("队列空");
        }
        int x=elem[pre];
        pre=getNext(pre);
        size--;
        return x;
    }

    public int getSize(){
        return this.size;
    }
}
