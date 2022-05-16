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
//        queue.in(3);
        queue.out();

        System.out.println(queue.getSize());
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



    public int getNextIndex(int i){
        return i<this.limit-1?i:0;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public boolean isFull(){
        return this.size==this.limit;
    }


    public int getSize(){
        return this.size;
    }

    //入队
    public void in(int o){
        if(!isFull()){
            elem[getNextIndex(this.next)]=o;
            size++;

        }else{
            throw new RuntimeException("队列已经满了");
        }
    }

    //出队
    public int out(){
        if(!isEmpty()){
            size--;
            int ele=elem[this.pre];
            this.pre=getNextIndex(this.pre);
            return ele;
        }else{
            throw new RuntimeException("队列已经空了");
        }
    }
}
