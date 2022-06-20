package shuati.day01;


/**
 * 1.给定一个有序数组arr，代表坐落在x轴上的点
 * 给定一个正整数k，代表绳子的长度
 * 返回绳子对多压中几个点
 * 即使绳子边缘处盖住点也算盖住
 */
public class TestOne {


    public static void main(String[] args) {
        int[] arr=new int[]{1,3,5,6};
        System.out.println(solution(arr, 1));
    }

    public static int solution(int[] arr,int k){
       if(arr==null&&arr.length==0) return 0;
       int left=0,right=0;
       int max=0;
       while(left<arr.length){
           while(right<arr.length&&arr[right]-arr[left]<=k){
               right++;
           }
           max=Math.max(max,right-left);
           left++;
       }
       return max;




    }


}


