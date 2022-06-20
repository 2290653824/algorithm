package systemStudy.day08.前缀树.计数排序;

import java.util.Arrays;

public class 计数排序1 {

    public static void main(String[] args) {
        int times=1000;
        int maxValue=1000;
        int maxLength=100;
        for(int i=0;i<times;i++){
            int[] randomArray = getRandomArray(maxLength, maxValue);
            System.out.println(Arrays.toString(randomArray));
            countSort(randomArray);
            System.out.println(Arrays.toString(randomArray));
            System.out.println();
        }
    }


    public static int[] getRandomArray(int maxLength,int maxValue){
        int length=(int)(Math.random()*maxLength);
        int[] arr=new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random() * maxValue);
        }
        return arr;
    }

    public static void countSort(int[] arr){
        int min=10000;
        int max=-10000;
        for (int i = 0; i < arr.length; i++) {
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }

        if(max-min+1<=0) return;
        int[] count=new int[max-min+1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]-min]++;

        }

        int index=0;
        for (int i = 0; i < count.length; i++) {
            while(count[i]>0){
                arr[index]=i+min;
                index++;
                count[i]--;
            }
        }
    }
}
