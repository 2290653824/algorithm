package newPeople.day2;

import java.util.Arrays;
import java.util.Random;

public class Main {


    /**
     * 随机生成一个数组，其长度为0-maxLength-1     数值范围为 0 - maxValue-1
     * @param maxLength
     * @param maxValue
     * @return
     */
    public static int[]  getRandomArr(int maxLength,int maxValue){
        if(maxLength<=0|| maxValue<=0){
            System.out.println("传入的数据不合法");
        }

        int len=(int)(Math.random()*maxLength);
        int[] arr=new int[len];

        for(int i=0;i<len;i++){
            arr[i]=(int)(Math.random()*maxValue);
        }


        return arr;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void printArr(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
//        int[] arr=getRandomArr(10,100);
//        int[] preArr=getPreArr(arr);
//
//        printArr(arr);
//        printArr(preArr);

        printGailv();


    }

    /**
     * 生成一个前缀和数组
     */
    public static int[] getPreArr(int[] arr){
        int n=arr.length;
        if(n<=0) {
            return new int[]{0};
        }
        int[] preArr=new int[n];
        preArr[0]=arr[0];
        for(int i=1;i<n;i++){
            preArr[i]=preArr[i-1]+arr[i];
        }
        return preArr;
    }

    /**
     * 生成一个1-5的等概率器
     */
    public static int getOneToFive(){
        return (int)(Math.random()*5+1);
    }

    /**
     * 查看构造器的概率问题是否是等概率
     */
    public static void printGailv(){

        int n=1000000;
        int[] arr=new int[10];
        for(int i=1;i<=n;i++){
            int a=f3();
            arr[a]++;
        }

        for(int i=0;i<10;i++){
            System.out.println((i)+"的次数为："+arr[i]);
        }
    }

    /**
     * 将1-5的等概率转化为01等概率
     */
    public static int f2(){
        int i=0;
        do{
            i=getOneToFive();

        }while(i==3);
        return i<3?0:1;
    }

    /**
     * 将01等概率转化为1-7
     */
    public static int f3(){
        int i;

        do{
            i=(f2()<<2)+(f2()<<1)+(f2()<<0);
        }while (i==7);

        return i+1;

    }


}
