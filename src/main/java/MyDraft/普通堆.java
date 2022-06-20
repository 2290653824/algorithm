package MyDraft;

import java.util.Arrays;

public class 普通堆 {

    public static void main(String[] args) {
        普通堆 t = new 普通堆();
        int[] arr=new int[]{3,6,2,9,1,3,4};
        for (int i = 0; i < arr.length; i++) {
            t.heapInsert(arr,i);
        }
        t.heapSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));


    }

    public void heapSort(int[] heap,int heapSize){
        while(heapSize>0){
            swap(heap,--heapSize,0);
            heapIfy(heap,0,heapSize);
        }
    }


    public void heapInsert(int[] heap,int index){

        while(index>=0&&heap[index]>heap[(index-1)/2]){
            swap(heap,index,(index-1)/2);
            index=(index-1)/2;

        }
    }

    public void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public void heapIfy(int[] heap,int index,int heapSize){
        int left=index*2+1;
        while(left<heapSize){
            int max=left+1<heapSize&&heap[left]<heap[left+1]?left+1:left;
            max=heap[index]>heap[max]?index:max;
            if(max==index){
                break;
            }
            swap(heap,max,index);
            index=max;
            left=index*2+1;
        }

    }


}


