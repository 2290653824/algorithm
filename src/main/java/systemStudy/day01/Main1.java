package systemStudy.day01;

import java.util.Arrays;

public class Main1 {

//    public static void main(String[] args) {
//        int[] arr=new int[]{2, 3, 5, 9, 10, 11, 13, 15, 19};
//        int i = BinaryEarch(arr, 10);
//
//    }
    public static void main(String[] args) {
//        f3();/
        int[] arr=new int[]{10,6,16,0,6,17};
        System.out.println(getRangeMin(arr));

    }

    /**
     * 测试局部最小
     */
    public static void f3(){
        int N=100000;
        int maxLength=10;
        int maxValue=20;
        for(int i=0;i<N;i++){
            int[] arr=getRandomArrNotEqual(maxLength,maxValue);
            int[] newarr=arrCopy(arr);

//            insertSort(arr);

            int p = getRangeMin(arr);
            System.out.println("=============");
            System.out.println("查询数组为："+ Arrays.toString(arr));
            System.out.println(p>=0?"查询成功，下标为"+p:"目标数据不存在");
            System.out.println("=============");
            System.out.println();


        }
    }

    /**
     * 局部最小
     * @param arr
     * @return
     */
    public static int getRangeMin(int[] arr){
        if(arr==null|| arr.length<2){
            return -1;
        }

        if(arr[0]<arr[1]) {
            return 0;
        }
        if(arr[arr.length-1]<arr[arr.length-2]){
            return arr.length-1;
        }

        int left=1,right=arr.length-2;

        while(left<right){
            int mid=left+((right-left)>>1);
            if(arr[mid]>arr[mid-1]){
                right=mid-1;
            }else if(arr[mid]>arr[mid+1]){
                left=mid+1;
            }else{
                return mid;
            }
        }

        return left;
    }

    /**
     * 测试>=num 最左
     */
    public static void f2(){
        int N=100000;
        int maxLength=10;
        int maxValue=20;
        for(int i=0;i<N;i++){
            int[] arr=getRandomArr(maxLength,maxValue);
            int[] newarr=arrCopy(arr);

            insertSort(arr);

            int p = getLeftMax(arr, 9);
            System.out.println("=============");
            System.out.println("查询数组为："+ Arrays.toString(arr));
            System.out.println(p>=0?"查询成功，下标为"+p:"目标数据不存在");
            System.out.println("=============");
            System.out.println();


        }
    }

    /**
     * 查找>=num最左数
     */
    public static int getLeftMax(int[] arr,int num){
        if(arr==null||arr.length==0){
            return -1;
        }

        int left=0,right=arr.length-1;
        int ans=-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(arr[mid]>=num){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        return ans;
    }


    /**
     * 测试二分查找
     */
    public static void test1(){
        int N=100000;
        int maxLength=10;
        int maxValue=20;
        for(int i=0;i<N;i++){
            int[] arr=getRandomArr(maxLength,maxValue);
            int[] newarr=arrCopy(arr);
            insertSort(arr);
            int p=BinaryEarch(arr,10);
            System.out.println("=============");
            System.out.println("查询数组为："+ Arrays.toString(arr));
            System.out.println(p>=0?"查询成功，下标为"+p:"目标数据不存在");
            System.out.println("=============");
            System.out.println();



        }
    }


    /**
     * 插入排序
     */
    public static void insertSort(int[] arr)
    {
        if(arr==null||arr.length<2){
            return;
        }

        for(int end=1;end<arr.length;end++){
            for(int pre=end-1;pre>=0&&arr[pre]>arr[pre+1];pre--){
                swap(arr,pre,pre+1);
            }
        }
    }

    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    /**
     * 对数器
     */
    public static int[] getRandomArr(int maxLength,int maxValue){
        int len=(int)(maxLength*Math.random());
        int[] arr=new int[len];
        for(int i=0;i<len;i++){
            arr[i]=(int)(maxValue*Math.random());
        }

        return arr;
    }


    /**
     * 生成相邻数组不等
     * @param maxLength
     * @param maxValue
     * @return
     */
    public static int[] getRandomArrNotEqual(int maxLength,int maxValue){

        int len=(int)(maxLength*Math.random());
        if(len<1) return new int[]{-1};
        int[] arr=new int[len];
        arr[0]=(int)(maxValue*Math.random());
        for(int i=1;i<len;i++){
            int x=-1;
            do{
                x=(int)(maxValue*Math.random());
            }while(x==arr[i-1]);
            arr[i]=x;
        }

        return arr;
    }

    /**
     * copy
     */
    public static int[] arrCopy(int[] arr){
        int len=arr.length;

        int[] newArr=new int[len];
        for(int i=0;i<len;i++){
            newArr[i]=arr[i];
        }

        return newArr;
    }

    /**
     * 二分查找
     * @param arr
     * @param num
     * @return
     */
    public static int BinaryEarch(int[] arr,int num){
        if(arr==null|| arr.length==0) {
            return -1;
        }

        int right=arr.length-1,left=0;
        while(right>=left){
            int mid=left+((right-left)>>1);
            if(arr[mid]==num){
                return mid;
            }else if(arr[mid]>num){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        return -1;
    }
}
