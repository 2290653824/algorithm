package systemStudy.day06.比较器;

import java.util.Arrays;

public class HeapTest {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        for(int i=0;i<1000;i++){
            int[] randomArr = getRandomArr(20, 20);
            System.out.println(Arrays.toString(randomArr));
            getBigHeap(randomArr);
            System.out.println(Arrays.toString(randomArr));
            System.out.println();
        }
    }


    /**
     * 传入一个数组，将其边成大根堆
     * @param arr
     */
    public static void getBigHeap(int[] arr){
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
    }

    /**
     * 获取一个随机数组
     * @param maxLength
     * @param maxValue
     * @return
     */
    public static int[] getRandomArr(int maxLength,int maxValue){
        int len=(int)(Math.random()*maxLength)+2;
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=(int)(Math.random()*maxValue);
        }
        return arr;
    }

    /**
     * 传入一个大根堆数组，其中最后一个index是未进入大根堆的
     * 我们目标就是将 新增的数据放在数组最后一个，然后逐渐与自己的父节点进行比较
     * 到最后满足大根堆
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr ,int index){
        while(arr[(index-1)/2]<arr[index]){
            swap(arr,(index-1)/2,index);
            index=(index-1)/2;
        }

    }

    /**
     * 检查某一个节点的后续节点是否符合大根堆,不符合则进行调整
     * @param arr
     * @param heapSize
     */
    public static void heapIfy(int[] arr,int index,int heapSize){
        int left= index*2+1;
        while(left<heapSize){
            int largest=left+1<heapSize&&arr[left+1]>arr[left]?left+1:left;
            largest=arr[largest]>arr[index]?largest:index;

            if(index==largest){
                break;
            }
            swap(arr,largest,index);
            index=largest;
            left=index*2+1;
        }
    }


    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }


}
