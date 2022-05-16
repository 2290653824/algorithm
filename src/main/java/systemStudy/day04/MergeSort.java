package systemStudy.day04;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        test1();
    }


    public static void test1(){
        int times=1000000;
        for(int i=0;i<times;i++){
            int[] arr = getRandomArr(10, 20);
            System.out.println(Arrays.toString(arr));
            mergeSort2(arr);
            System.out.println(Arrays.toString(arr));
            System.out.println();
        }
    }

    //获得一个随机的数组
    public static int[] getRandomArr(int maxLength,int maxValue){
        int len=(int)(Math.random()*maxLength+2);
        int[] arr=new int[len];

        for(int i=0;i<arr.length;i++){
            int value=(int)(Math.random()*maxValue);
            arr[i]=value;
        }

        return arr;
    }


    /**
     * 使用递归进行归并排序
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process(arr, 0, arr.length - 1);


    }


    /**
     * 归并排序的核心代码
     * @param arr
     * @param L
     * @param R
     */
    public static void process(int[] arr, int L ,int R) {
        if (L == R) {
            return;
        }

        int mid = L + ( (R-L) >>1);
        process(arr, L, mid);
        process(arr, mid+1, R);
        merge(arr,L,mid,R);

    }

    //将两个已经有序的数组进行融合（当然可以是数组中的部分数组）
    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = M + 1;
        int i = 0;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        //假如左边已经没有了
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        while (p1 <= M) {
            help[i++] = arr[p1++];
        }

        for (i = 0; i < help.length; i++) {
            arr[i + L] = help[i];
        }

    }

    /**
     * 使用迭代的方法替代递归
     * @param arr
     */
    public static void mergeSort2(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }

        int N=arr.length;
        int mergeSize=1;
        while(mergeSize<N){
            int L=0;
            while(L<N){
                if(mergeSize>=N-L) break;

                int M=L+mergeSize-1;
                int R=M+Math.min(mergeSize,N-M-1);
                merge(arr,L,M,R);

                L=R+1;
        }

            if(mergeSize>N/2){
                break;
            }

            mergeSize<<=1;


    }
    }
}
