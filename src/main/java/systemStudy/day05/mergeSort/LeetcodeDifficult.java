package systemStudy.day05.mergeSort;

import java.util.Arrays;

/**
 * 有一个数组从0~n-1 ，累加和为sum
 * 求以n~1结尾的子数组中，有多少个子数组（即x~n-1）的累加和落在（lower，upper）范围内
 * 其实可以转变为0~x-1 的累加和落在（sum-upper~sum-lower）的范围上的个数
 */
public class LeetcodeDifficult {

    public static void main(String[] args) {
        test1(1000,10,30);
//        System.out.println(getCount(new int[]{10, 4, 2, 21, 22, 5}, 0, 20));
    }

    public static void test1(int counts,int maxlength,int maxValue){
        for(int i=0;i<counts;i++){
            int[] randomArr = getRandomArr(maxlength, maxValue);
            System.out.println(Arrays.toString(randomArr));
            int count = getCount(randomArr, 10, 20);
            System.out.println(count);
            System.out.println();

        }
    }

    /**
     * 获得一个随机数组
     * @param maxLength
     * @param maxValue
     * @return
     */
    public static int[] getRandomArr(int maxLength,int maxValue){
        int len=(int)(Math.random()*maxLength);
        int[] arr=new int[len];

        for(int i=0;i<len;i++){
            int value=(int)(Math.random()*maxValue);
            arr[i]=value;
        }

        return arr;


    }

    /**
     * 获取的方法
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public static int getCount(int[] nums,int lower,int upper){
        if(nums==null||nums.length<1){
            return 0;
        }

        return count(getSumArr(nums),0,nums.length-1,lower,upper);
    }

    /**
     * 注意这里传入的是sum数组
     * 递归调用的主体
     * @param sum
     * @return
     */
    public static int count(int[] sum,int l,int r,int lower,int upper){
        if(l==r){
            if(sum[l]>=lower&&sum[l]<=upper){
                return 1;
            }else{
                return 0;
            }
        }
        int mid=(l+r)/2;
        return count(sum,l,mid,lower,upper)+count(sum,mid+1,r,lower,upper)+merge(sum,l,mid,r,lower,upper);
    }


    /**
     * 归并主题，这里是解题的核心
     * @param sum
     * @param l
     * @param mid
     * @param r
     * @param lower
     * @param upper
     * @return
     */
    public static int merge(int[] sum,int l,int mid,int r,int lower,int upper){
        int windowR=l,windowL=l;
        int ans=0;

        for(int i=mid+1;i<=r;i++){
            int max=sum[i]-lower;
            int min=sum[i]-upper;
            while(windowR<=mid&&sum[windowR]<=max){
                windowR++;
            }
            while(windowL<=r&&sum[windowL]<min){
                windowL++;
            }

            ans+=Math.max(windowR-windowL,0);
        }

        int[] help=new int[r-l+1];
        int index=0;
        int p1=l;
        int p2=mid+1;
        while(p1<=mid&&p2<=r){
            help[index++]=sum[p1]<sum[p2]?sum[p1++]:sum[p2++];
        }

        while(p1<=mid){
            help[index++]=sum[p1++];
        }
        while(p2<=r){
            help[index++]=sum[p2++];
        }

        for(index=0;index<help.length;index++){
            sum[l+index]=help[index];
        }



        return ans;



    }



    /**
     * 获得一个前缀和数组
     * @param nums
     * @return
     */
    public static int[] getSumArr(int[] nums){
        if(nums==null||nums.length==0){
            return null;
        }
        int[] sum=new int[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i]=nums[i]+sum[i-1];
        }

        return sum;
    }



}
