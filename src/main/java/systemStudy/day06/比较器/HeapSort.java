package systemStudy.day06.比较器;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        test();
    }



    public static void test(){
        for(int i=0;i<1000;i++){
            int[] randomArr = HeapTest.getRandomArr(20, 20);
            System.out.println(Arrays.toString(randomArr));
            heapSort(randomArr);
            System.out.println(Arrays.toString(randomArr));
            System.out.println();

        }
    }


    public static void heapSort(int[] arr){
        HeapTest.getBigHeap(arr);
        int heapSize=arr.length;
        while(heapSize>0){
            swap(arr,0,--heapSize);
            HeapTest.heapIfy(arr,0,heapSize);
        }
    }

    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
