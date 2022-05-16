package systemStudy.day05.快排;

import java.util.Arrays;

/**
 * 荷兰国旗问题
 * 1.给定一个数组，在给定一个数x,将小于等于x的数放左边，把大于x的数放在右边。要求时间复杂度为O(n),空间复杂度为O(1)
 *
 * 2.给定一个数组，在给定一个数x,将小于x的数放左边，等于x放中间，把大于x的数放在右边。要求时间复杂度为O(n),空间复杂度为O(1)
 *
 * 3.默认将最后一个数作为x，对0 - n-1 上的数进行放置，最后将n与大于范围上的第一个数交换，即可
 *
 */

public class 前置知识 {

    public static void main(String[] args) {
        test3();
    }

    public static void test3(){
        int[] arr=new int[]{1,2,3,3,8,2,4,7,234,234,1};
        int[] ints = problem3(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ints));


    }


    public static int[] problem3(int[] arr,int l,int r){
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
