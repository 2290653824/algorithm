package systemStudy.day04;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 其实解体思路就是求x右边都有多少个数比x小,是小和数的逆过程，只不过在进行merge时要从右边开始而不是左边开始
 */
public class 逆序对 {

    public static void main(String[] args) {
        t1();
    }

    public static int getMin2(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                  sum+=1;
                }
            }
        }
        return sum;
    }

    public static void t1(){
        int count=100;
        int maxlength=500;
        int maxvalue=50000;
        int time1=0;
        int time2=0;

        for(int i=0;i<count;i++){
            int[] randomArr = getRandomArr(maxlength, maxvalue);
//            System.out.println(Arrays.toString(randomArr));
            long start1 = System.currentTimeMillis();
            int i1 = getMin2(randomArr);
            long end1 = System.currentTimeMillis();
            time1+=(end1-start1);
//            System.out.println(i1);

        }
        for(int i=0;i<count;i++){
            int[] randomArr = getRandomArr(maxlength, maxvalue);
//            System.out.println(Arrays.toString(randomArr));
            long start1 = System.currentTimeMillis();
            int i1 = mergeSortOfMIn(randomArr);
            long end1 = System.currentTimeMillis();
            time2+=(end1-start1);
//            System.out.println(i1);

        }

        System.out.println(time1);
        System.out.println(time2);
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

    public static int mergeSortOfMIn(int[] arr){
        if(arr==null||arr.length<2) return 0;

        int process = process(arr, 0, arr.length - 1);
        return process;
    }

    public static int process(int[] arr,int l,int r){
        if (l==r){
            return 0;
        }

        int mid=l+((r-l)>>1);
        return process(arr,l,mid)+process(arr,mid+1,r)+merge(arr,l,mid,r);


    }

    /**
     * 归并两个数组的同时将小于x的总数计算出来
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @return
     */
    public static int merge(int[] arr,int l,int mid,int r){
        int help[] =new int[r-l+1];
        int p1=mid;
        int p2=r;
        int ans=0;
        int i=r-l;

        while(p1>=l&&p2>=mid+1){
            ans+=arr[p1]>arr[p2]?(p2-mid):0;
            help[i--]=arr[p1]>arr[p2]?arr[p1--]:arr[p2--];
        }

        while(p1>=l){
            help[i--]=arr[p1--];
        }
        while(p2>=mid+1){
            help[i--]=arr[p2--];
        }

        for(i=0;i<help.length;i++){
            arr[l+i]=help[i];
        }

        return ans;

    }


}
