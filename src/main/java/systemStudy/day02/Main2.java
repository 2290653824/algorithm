package systemStudy.day02;

import java.util.Arrays;

public class Main2 {


    public static void main(String[] args) {
        int[] arr=new int[]{2,33,33,44,44,55,55,6,6,5,5,5};
        int[] twoFromArr = getTwoFromArr(arr);
        System.out.println(Arrays.toString(twoFromArr));
    }

    /**
     * 保证在一个数组中，有两种数出现奇数次，其他数都出现偶数次
     * @param arr
     * @return
     */
    public static int[] getTwoFromArr(int[] arr){
        if(arr==null&&arr.length<2){
            return new int[]{};
        }

        int base=0;

        for(int i=0;i<arr.length;i++){
            base^=arr[i];

        }

        int rightMostOne = getRightMostOne(base);
        int index=0;
        while((rightMostOne&1)==0){
            index++;
        }

        int base1=0;
        int base2=0;
        for(int i=0;i<arr.length;i++){
            if(((arr[i]>>index)&1)==1){
                base1^=arr[i];
            }else{
                base2^=arr[i];
            }
        }

        return new int[]{base1,base2};

    }


    /**
     * 取得一个数的最左数
     * @param x
     * @return
     */
    public static int getRightMostOne(int x){
        if(x==0){
            return 0;
        }
        return (-x)&x;
    }
}
