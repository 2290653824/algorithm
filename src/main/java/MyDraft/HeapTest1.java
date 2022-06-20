package MyDraft;

import java.util.Arrays;
import java.util.Random;

/**
 * 小根堆
 */
public class HeapTest1 {

    public static void main(String[] args) {
        HeapTest1 heapTest1 = new HeapTest1();
        int[] randomArr = heapTest1.getRandomArr(20, 20);
        System.out.println(Arrays.toString(randomArr));
        heapTest1.getHeap(randomArr);
        System.out.println(Arrays.toString(randomArr));
        heapTest1.heapSort(randomArr,randomArr.length);
        System.out.println(Arrays.toString(randomArr));



    }

    public void getHeap(int[] arr){
        int size=0;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
            size++;
        }


    }

    public  void heapSort(int[] arr,int size){
        while(size>0){
            swap(arr,0,--size);
            heapIfy(arr,0,size);
        }
    }

    public int[] getRandomArr(int length,int index){
        int len= (int)(Math.random()*length);
        int[] arr=new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*index);
        }
        return arr;
    }


    public void heapInsert(int[] arr,int index){
        while(arr[index]<arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }

    public void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public void heapIfy(int[] arr,int index,int size){
        int left=index*2+1;
        while(left<size){
            int min=left+1<size&&arr[left]>arr[left+1]?left+1:left;
            min=arr[min]<arr[index]?min:index;
            if(min==index){
                return;
            }

            swap(arr,index,min);
            index=min;
            left=index*2+1;
        }
    }


}
