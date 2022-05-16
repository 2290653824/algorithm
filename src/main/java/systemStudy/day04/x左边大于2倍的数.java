package systemStudy.day04;

/**
 * TODO
 * 求一个数组中，x大于等于右边n的2倍的数的个数
 */
public class x左边大于2倍的数 {

    public static int mergeOf2(int[] arr){
        if(arr==null|| arr.length<2){
            return 0;
        }

        return 0;
    }

    public static int process(int[] arr,int l,int r){
        if(r==l){
            return 0;
        }
        int mid=l+((r-l)>>2);
        return process(arr,l,mid)+process(arr,mid+1,r)+merge(arr,l,mid,r);
    }

    public static int merge(int[] arr,int l,int mid,int r){
        int p=mid+1;
        int anw=0;
        int p1=l;
        int p2=mid;
        return 0;
    }
}
