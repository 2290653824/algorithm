package newPeople.day2;

import java.util.Arrays;

/**
 * 根据该天所学，这里我使用构造器与复习昨天的三大排序来进行测试
 */

public class Main2 {

    public static void main(String[] args) {
        int n=100000;
        boolean flag=false;
        for(int i=0;i<n;i++){
            int[] arr=getRandomArr(12,20);
            int[] arr1=arrCopy(arr);
            int[] arr2=arrCopy(arr);


//            selectSort(arr);
//            flag=isSorted(arr);


//            bubbleSort(arr1);
//            flag=isSorted(arr1);

            insertSort(arr2);
            flag=isSorted(arr2);

            if(!flag){
                System.out.println("出错了");
                break;
            }
        }


    }

    /**
     * 判断是否排序
     * @param arr
     * @return
     */
    public static boolean isSorted(int arr[]){
        if(arr==null|| arr.length<2){
            return true;
        }

        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void printArr(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     * @param arr
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
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        if(arr==null|| arr.length<2){
            return;
        }

        for(int end=arr.length-1;end>=0;end--){
            for(int second=1;second<=end;second++){
                if(arr[second-1]>arr[second]){
                    swap(arr,second-1,second);
                }
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr){

        if(arr==null|| arr.length<2){
            return;
        }

        for(int i=0;i<arr.length;i++){
            int minValueIndex=i;
            for(int j=i+1;j<arr.length;j++){
                minValueIndex=arr[minValueIndex]>arr[j]?j:minValueIndex;
            }
            swap(arr,minValueIndex,i);
        }
    }

    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    /**
     * 深拷贝数组
     * @param arr
     * @return
     */
    public static int[] arrCopy(int[] arr){
        int[] newArr=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            newArr[i]=arr[i];
        }
        return newArr;
    }

    /**
     * 对数器构造随机函数
     * @param maxLength
     * @param maxValue
     * @return
     */
    public static int[] getRandomArr(int maxLength,int maxValue){
        int length=(int)(Math.random()*maxLength);

        int[] randomArr=new int[length];
        for(int i=0;i<length;i++){
            randomArr[i]=(int)(Math.random()*maxValue);
        }

        return randomArr;
    }
}
