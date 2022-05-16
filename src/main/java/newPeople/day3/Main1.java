package newPeople.day3;

import java.util.Arrays;

public class Main1 {

    public static void main(String[] args) {
        for(int i=0;i<1000;i++){

            int[] randomArr = getRandomArr(10, 20);
            insertSort(randomArr);
            printArr(randomArr);
            int fen = fen(randomArr, 10);
            System.out.println((i+1)+"次实验："+fen);
        }
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void printArr(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] arr){
        if(arr==null|| arr.length<2){
            return;
        }

        for(int end=1;end<arr.length;end++){
            for(int pre=end-1;pre>=0&&arr[pre]>arr[pre+1];pre--){
                swap(arr,pre,pre+1);
            }
        }
    }

    /**
     * 交换
     */
    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    /**
     * 二分法查找数据
     * @param arr
     * @param num
     * @return
     */
    public static int fen(int[] arr,int num){
        if(arr==null||arr.length==0){
            return -1;
        }
        int left=0,right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==num) {
                return mid;
            }else if(arr[mid]>num){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        return -1;
    }


    /**
     * 对数器
     */
    public static int[] getRandomArr(int maxLength,int maxValue){
        int len=(int)(Math.random()*maxLength);
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=(int)(Math.random()*maxValue);
        }

        return arr;
    }


    /**
     * 在一个有序数组查找>=num 的最左数
     */
    public static void f1(){}


    /**
     * 在一个有序数组中查找<=num 的最右数
     */
    public static void f2(){}

    /**
     * 查找数组里的局部最小（无序，相邻数组不相等）
     */
    public static void f3(){}

}
