package systemStudy.day04;


import java.util.Arrays;

/**
 * 小和问题
 * 给定一个数组，找出数组上每个位置左边 <=num 的数的累加和
 * 所有小和累加
 * 
 * 其实就是在归并排序上进行累加
 *
 * [10, 3, 3, 9]
 * 6
 */
public class LeetCode1 {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 一个测试方法
     */
    public static void test1(){
        int times=1000;
        int maxlength=10000;
        int maxValue=20000;
        int count1=0;
        int count2=0;
        for(int i=0;i<times;i++){
            int[] randomArr = getRandomArr(maxlength, maxValue);
//            System.out.println(Arrays.toString(randomArr));
            long start = System.currentTimeMillis();
            int i1 = mergeSortOfSum(randomArr);
            long end = System.currentTimeMillis();
            count1+=(end-start);
//            System.out.println(Arrays.toString(randomArr));
//            System.out.println(i1);

        }
        System.out.println(count1);

        for(int i=0;i<times;i++){
            int[] randomArr = getRandomArr(maxlength, maxValue);
//            System.out.println(Arrays.toString(randomArr));
            long start1 = System.currentTimeMillis();
            int i1 = getMin(randomArr);
            long end1 = System.currentTimeMillis();
            count2+=(end1-start1);
//            System.out.println(Arrays.toString(randomArr));
//            System.out.println(i1);

        }
        System.out.println(count2);
    }


    /**
     * 小和问题的高复杂度解法
     * @return
     */
    public static int getMin(int[] arr){
        int sum=0;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    sum+=arr[j];
                }
            }
        }
        return sum;
    }



    /**
     * 生成一个随机数组
     * @param maxLength
     * @param maxValue
     * @return
     */
    public static int[] getRandomArr(int maxLength,int maxValue){
        int len=(int)(Math.random()*maxLength+2);
        int[] arr=new int[len];

        for(int i=0;i<len;i++){
            int value=(int)(Math.random()*maxValue);

            arr[i]=value;
        }

        return arr;

    }

    /**
     * 解提本体
     * @param arr
     * @return
     */
    public static int mergeSortOfSum(int[] arr){
        if(arr==null||arr.length<2){
            
            return 0;
        }
        int process = process(arr, 0, arr.length - 1);
        return process;
    }

    /**
     * 递归本体
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static int process(int[] arr,int l,int r){
        if(l==r){
            return 0;
        }
        int mid=l+((r-l)>>2);
        return process(arr,l,mid)+
        process(arr,mid+1,r)+merge(arr,l,mid,r);


    }

    /**
     * 将两个有序的数组组成一个有序的数组，并计算其中小和总和
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @return
     */
    public static int merge(int[] arr,int l,int mid,int r){
        int p1=l,p2=mid+1;
        int[] help=new int[r-l+1];
        int ans=0;
        int i=0;
        while(p1<=mid&&p2<=r){
            ans+=arr[p1]<arr[p2]?(r-p2+1)*arr[p1]:0;
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }

        while(p1<=mid){
            help[i++]=arr[p1++];
        }
        while(p2<=r){
            help[i++]=arr[p2++];
        }

        for(i=0;i<help.length;i++){
            arr[l+i]=help[i];
        }

        return ans;

    }

}


