package systemStudy.day03;




public class Stack {



    public static void main(String[] args) throws Exception {
        Stack stack = new Stack(5);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(90);
    }

    Object[] elem;
    int top;
    int maxElem;


    public Stack(int maxElem){
        this.maxElem=maxElem;
        this.elem=new Object[maxElem];
        this.top=0;

    }


    //置空
    public void clear(){
        this.top=0;
    }
    //判满
    public boolean isFull(){
        if(this.top==maxElem){
            return true;
        }
        return false;
    }

    //判空
    public boolean isEmpty(){
        if(this.top==0){
            return true;
        }
        return false;
    }
    //返回栈中元素个数
    public int length(){
        return this.top;
    }
    //读取栈顶元素
    public Object peek(){
        if(!isEmpty()){
            return elem[this.top-1];
        }
        throw new RuntimeException("无法入栈");
    }
    //入栈
    public void push(Object o) throws Exception{
        if(!isFull()){
            elem[this.top++]=o;
        }else{

            throw new RuntimeException("栈已经满了，无法压栈");
        }

    }

    //返回栈顶元素 出栈
    public Object pop(){
        if(!isEmpty()){
            return elem[--this.top];
        }else{

            throw new RuntimeException("栈已经空了，无法出栈");
        }
    }



}
