package MyDraft;

public class 基数 {

    public static void radixSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }


    }
    public static void radixSort(int[] arr,int left,int right,int maxBit){
        final int radix=10;  //设置桶位数量
        int i=0,j=0;
        int[] help=new int[right-left+1]; //设置辅助空间，用于存放数组的排序
        for(int d=1;d<=maxBit; d++){
            int[] count=new int[radix];
        }
    }

    public static int getArrMaxBit(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        int res=0;
        while(max!=0){
            res++;
            max=max/10;
        }
        return res;
    }
}
