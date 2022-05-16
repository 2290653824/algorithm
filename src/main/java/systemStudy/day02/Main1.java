package systemStudy.day02;

import java.util.Arrays;

public class Main1 {


    public static void main(String[] args) {
//        System.out.println(7^13);
//        System.out.println(7^7);
//        System.out.println(7^0);

//        int[] arr = new int[]{1,1,3,3,3,4,4,6,6};
//        int[] arr=getarr(12,20);
//
//        int fromArr = getFromArr(arr);
//        System.out.println(fromArr);

//        test1();

        f2();



    }

    public static void f2(){
        for(int i=0;i<10000;i++){
            int random=(int)(Math.random()*1000000);
            System.out.println("============");
            System.out.println("============");
            printBinaryOfInt(random);
            int rightOne = getRightOne(random);
            printBinaryOfInt(rightOne);
            System.out.println("============");
            System.out.println();
        }
    }


    /**
     * 打印二进制
     * @param num
     */
    public static void printBinaryOfInt(int num){
        int j=1;
        for(int i=31;i>=0;i--){

            System.out.print((((1<<i)&num)==0)?"0":"1");
        }
        System.out.println();
    }

    /**
     * 提取一个数的最右边的1
     * @param a
     * @return
     */
    public static int getRightOne(int a){
        if(a==0){
            return 0;
        }

        return a&(-a);


    }


    public static void test1(){
        int maxlength=10;
        int maxValue=20;
        int times=10000;
        for(int i=0;i<times;i++){
            int[] getarr = getarr(maxlength, maxValue);
            int fromArr = getFromArr(getarr);
//            if(fromArr!=getarr[0])
            System.out.println("元素组为："+ Arrays.toString(getarr)+"  单数为："+fromArr);
        }
    }


    /**
     * 生成一个偶数次，其他数都是奇数次
     * @param maxLength
     * @param maxValue
     * @return
     */
    public static int[] getarr(int maxLength,int maxValue){
        if(maxLength==0){
            return new int[]{};
        }

        int len=(int)(maxLength*Math.random());

        if(len%2==0){
            len+=1;
        }
        int[] arr =new int[len];

        int newint=(int)(Math.random()*maxValue);
        arr[0]=newint;

        for(int i=1;i+1<len;i+=2){
            int m=(int)(Math.random()*maxValue);
            arr[i]=m;
            arr[i+1]=m;
        }

        //打乱数组
        for(int i=0;i<len;i++){
            int j=(int)(Math.random()*len);
            swap(arr,j,i);
        }

        return arr;


    }

    /**
     * 一个数组中只有一种数出现奇数次，其他都出现偶数次
     * @param arr
     * @return
     */
    public static int getFromArr(int[] arr){
        int j=0;
        for(int i=0;i<arr.length;i++){
            j^=arr[i];
        }
        return j;
    }

    /**
     * 交换两个数
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr ,int a,int b){
//        arr[a]=arr[a]^arr[b];
//        arr[b]=arr[a]^arr[b];
//        arr[a]=arr[a]^arr[b];

        int temp=arr[a];
        arr[b]=arr[a];
        arr[a]=temp;
    }
}
