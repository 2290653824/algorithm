package systemStudy.day08.前缀树.计数排序;

import java.util.Arrays;

public class 普通堆优化 {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        int[] arr = new int[]{4,3,6,2,7,1,6,2,7,10};
        heap.arr=arr;
        for(int i = 0; i < arr.length; i++){
            heap.heapInsert(i);
            heap.size++;
        }
        heap.heapSort();
        System.out.println(Arrays.toString(arr));

    }

}

class Heap{

    int limit;
    int size;
    int[] arr;

    public Heap(int limit){
        this.limit = limit;
        arr = new int[limit];
    }

    public void heapSort(){
        while (size>0){
            swap(0,--size);
            heapIfy(0);
        }
    }

    public void heapInsert(int index){
        while(arr[index]>arr[(index-1)/2]){
            swap(index,(index-1)/2);
            index=(index-1)/2;
        }
    }

    public void heapIfy(int index){
        int left=index*2+1;
        while(left<size){
            int max=left+1<size&&arr[left+1]>arr[left]?
                    left+1:left;

            max=arr[max]<arr[index]?index:max;
            if(max==index){
                break;
            }
            swap(max,index);
            index=max;
            left=index*2+1;
        }
    }

    public void swap(int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }


}
