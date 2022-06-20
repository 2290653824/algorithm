package systemStudy.day03;

public class Queue {

    public static void main(String[] args) {
        test();


    }


    public static  void test(){
        Queue queue = new Queue(5);
        queue.in(3);
        queue.in(3);
        queue.in(3);
        queue.in(3);
        queue.in(3);

        queue.out();
        queue.in(3);
        System.out.println(queue.pre);
        System.out.println(queue.next);


//        System.out.println(queue.getSize());
    }

    int next;
    int pre;
    int limit;
    int[] elem;
    int size;

    public Queue(int limit){
        int size=0;
        this.next=0;
        this.pre=0;
        this.limit=limit;
        this.elem=new int[this.limit];
    }

    public Integer out(){
        int x=elem[pre];
        size--;
        pre=getNextIndex(pre);
        return x;
    }

    public int getSize(){
        return size;
    }




    public void in(int x){
        if(isFull()){
            throw new RuntimeException("队列已经满了");
        }

        elem[next]=x;
        next=getNextIndex(next);
        size++;
    }

    public boolean isFull(){
        return size==limit;
    }

    public boolean isEmpty(){
        return size==0;
    }


    public int getNextIndex(int index){
        return index<limit-1?index+1:0;
    }


}
