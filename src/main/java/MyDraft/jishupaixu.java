package MyDraft;

import java.util.Arrays;

public class jishupaixu {

    public static void main(String[] args) {
        int[] arr=new int[]{3,4,51,2,3,21,45,22,11};
        jishupaixu.countSort(arr,53);
        System.out.println(Arrays.toString(arr));
    }

    public  static  void countSort(int[] arr,int max){
        int[] count=new int[max];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int index=0;
        for (int i = 0; i < count.length; i++) {
            while(count[i]>0){
                arr[index]=i;
                index++;
                count[i] --;
            }
        }


    }
}

