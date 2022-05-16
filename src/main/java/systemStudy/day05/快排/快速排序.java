package systemStudy.day05.快排;

import java.util.Arrays;

/**
 * 时间复杂度O(N^2)
 */
public class 快速排序 {
    public static void main(String[] args) {
        test1();
    }


    public static void test1(){
        int[] arr=new int[]{1,43,65,2,4,56,2,34,2,1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        process(arr,0,arr.length-1);
    }

    public static void process(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
//        process(arr,l,r);
        int[] res = deguoqizhi(arr, l, r);
        process(arr,l,res[0]-1);
        process(arr,res[1]+1,r);
    }

    public static int[] deguoqizhi(int[] arr, int l, int r){
        if(l>r){
            return new int[]{-1,-1};
        }
        if(l==r){
            return new int[]{l,l};
        }

        int less=l-1;
        int more=r;
        int index=l;
        while(index<more){
            if(arr[index]==arr[r]){
                index++;
            }else if(arr[index]<arr[r]){
                swap(arr,less+1,index);
                less++;
                index++;
            }else {
                swap(arr,more-1,index);
                more--;
            }

        }
        swap(arr,r,more);
        return new int[]{less+1,more};
    }

    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }



}
