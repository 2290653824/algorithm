package systemStudy.day03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Leetcode {

    //实现一个特殊的栈，实现基本功能的基础上，返回栈种最小元素O(1)
    public static void main(String[] args) {
        test();
    }

    //通过排序取得最小值，与栈种得到的最小值进行比较
    public static void test(){
        int times=10000;
        for(int i=0;i<times;i++){
            int[] arr = getRandomArr(10, 100);
            if(arr==null||arr.length==0){
                continue;
            }
            MyStack myStack = new MyStack();
            for(int j=0;j<arr.length;j++){
                myStack.push(arr[j]);
            }
            int stackMin=myStack.getMin();
            insertSelection(arr);

            int min=arr[0];

            if(min==stackMin){
                System.out.println("成功");
            }else{
                System.out.println("失败");
            }



        }

    }

    //插入排序
    public static void insertSelection(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }

        for(int end=1;end<arr.length;end++){
            for(int pre=end-1;pre>=0&&arr[pre]>arr[pre+1];pre--){
                swap(arr,pre,pre+1);
            }
        }

    }

    //交换两个数据
    public static void swap(int[] arr,int a,int b){
        arr[a]=arr[a]^arr[b];
        arr[b]=arr[a]^arr[b];
        arr[a]=arr[a]^arr[b];

    }

    public static int[] getRandomArr(int maxLength,int maxValue){
        int length=(int)(Math.random()*maxLength);
        int[] arr=new int[length];
        for(int i=0;i<length;i++){
            int value = (int) (Math.random() * maxValue);
            arr[i]=value;
        }

        return arr;
    }

}

/**
 * //实现一个特殊的栈，实现基本功能的基础上，返回栈种最小元素O(1)
 */
class MyStack{

    Stack normalStack;
    Stack minStack;

    public MyStack(){
        normalStack=new Stack<Integer>();
        minStack=new Stack<Integer>();
    }

    public int getMin(){
        return (Integer) minStack.peek();
    }

   public void push(Integer o){
        normalStack.push(o);
        if(minStack.isEmpty()){
            minStack.push(o);
            return;
        }
       int top=(Integer)minStack.peek();
       if(top>o){
           minStack.push(o);
       }else{
           minStack.push(top);
       }
   }

    public int pool(int o){
        if(!normalStack.isEmpty()){
            minStack.pop();
            return (Integer) normalStack.pop();
        }else{
            throw new RuntimeException("poo方法出错了");
        }

    }

    public boolean isEmpty(){
        return normalStack.isEmpty();
    }

    public int getSize(){
        return normalStack.size();
    }

}

//使用两个栈转向队列
class StackToQueue{

    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    public StackToQueue(){

    }

}
