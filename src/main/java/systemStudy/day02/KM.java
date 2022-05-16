package systemStudy.day02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class KM {


    public static void main(String[] args) {
//        int[] arr =new int[]{0,0,3,3,3,3,5,5,5,5,6,6,6,6,456,456,456,456};
//
//        int k = getK(arr, 2, 4);
//        System.out.println(k);


//        int[] randomArr = getRandomArr(3, 20, 3, 5);
//        System.out.println(Arrays.toString(randomArr));
        test();
    }


    public static void test(){

        int testTimes=100000;
        for(int i=0;i<testTimes;i++){
            int numKinds=(int)(Math.random()*20)+2; //2--22
            int range=(int)(Math.random()*100)+100;
            int a=(int)(Math.random()*10)+2;
            int b=(int)(Math.random()*10)+2;
            int k=Math.min(a,b);
            int m=Math.max(a,b);
            if(k==m){
                m++;
            }
            int[] arr = getRandomArr(numKinds, range, k, m);
            int ans = getK(arr, k, m);
            System.out.println("数组为："+Arrays.toString(arr)+"  k为："+ans);
            System.out.println();



        }

    }

    /**
     * 生成一个随机数组，其中k,m
     * @param
     * @param
     * @param k
     * @param m
     * @return
     */
    public static int[] getRandomArr(int numKinds ,int range,int k,int m){
        int kNum=getRandomRange(range);
        int len =1*k+(numKinds-1)*m;
        int index=0;
        int[] arr=new int[len];
        for(;index<k;index++){
            arr[index]=kNum;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        set.add(kNum);
        numKinds--;
        while(numKinds!=0){
            int mNum=getRandomRange(range);
            if(set.contains(mNum)){
                continue;
            }
            for(int i=0;i<m;i++){
                arr[index]=mNum;
                index++;
            }
            numKinds--;
            set.add(mNum);
        }

        for(int i=0;i<arr.length;i++){
            int j=(int)(Math.random()*arr.length);
            arr[i]=arr[i]^arr[j];
            arr[j]=arr[i]^arr[j];
            arr[i]=arr[i]^arr[j];
        }

        return arr;
    }

    public static int getRandomRange(int range){
        return (int)(Math.random()*range)-(int)(Math.random()*range);
    }

    /**
     * 有一种数出现了k次，其他数都出现了m次，找出这个k次的数
     * 1<k<m
     *
     * @param arr
     * @param k
     * @param m
     * @return
     */
    /**
     * 这个是保证输入的数组一定有一种数有k次，而其他数一定有m次
     * @param arr
     * @param k
     * @param m
     * @return
     */
    public static int getK(int[] arr, int k, int m) {
        if (arr == null || arr.length == 1) {
            throw new RuntimeException("传入的数组不合法");
        }

        //生成一个map，通过最有数来获得该最有右在哪个下标，下标是从0开始的
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int p = 1;
        for (int i = 0; i < 32; i++) {
            map.put(p,i);
            p=p<<1;
        }

        int[] t=new int[32];

        for(int num:arr){
            while(num!=0){
                int rightOne=num&(-num);
                t[map.get(rightOne)]++;
                num^=rightOne;
            }
        }

        int ans=0;

        for(int i=0;i<32;i++){
            if(t[i]%m!=0){
                if(t[i]%m==k){
                    ans=(1<<i)|ans;
                }else{
                    System.out.println("给定的数据有问题");
                    return -1;
                }
            }
        }



        return ans;


    }
}
