package systemStudy.day05.快排;

import java.util.Arrays;

/**
 * 时间复杂度O(NlogN)
 *
 * 空间复杂度 最坏O(N)  最好O(logn)
 */
public class 随机快速排序 {

    public static void main(String[] args) {
//        testProtion();
//        randomQuickSortTest();
    }


    /**
     * 测试快速随机排序是否正确
     */
    public static void randomQuickSortTest(){
        int[] arr=new int[]{1,4,2,7,3,6,4,8,3};
        randomQuickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 测试partion数组是否正确
     */
    public static void testProtion(){
        int[] arr=new int[]{1,4,2,7,3,6,4,8,3};
//        System.out.println(Arrays.toString(arr));
        int[] partion = partion(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(partion));

    }




    public static void randomQuickSort(int[] arr){
        if(arr==null||arr.length<2) {
            return;
        }

        process(arr,0,arr.length-1);
    }

    public static void process(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
        int[] partion = partion(arr, l, r);
        process(arr,l,partion[0]-1);
        process(arr,partion[1]+1,r);
    }


    /**
     * 返回分组过后，中间数的左右边界
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static int[] partion(int[] arr,int l,int r){


        int less=l-1;
        int more=r;
        int index=l;
        int randomIndex=(int)(Math.random()*(r-l)+l);
//        System.out.println(arr[randomIndex]);
        swap(arr,r,randomIndex);

        while(index<more){
            if(arr[index]==arr[r]){
                index++;
            }else if(arr[index]<arr[r]){
                swap(arr,less+1,index);
                less++;
                index++;
            }else{
                swap(arr,index,more-1);
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
