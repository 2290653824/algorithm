package systemStudy.day05.快排;

import java.util.Arrays;

public class 快速排序与随机快速排序的时间复杂度测试 {

    public static void main(String[] args) {
//        long l = quickTest(300, 300, 1000000);
//        long l1 = randomQuickTest(300, 300, 1000000);
//        System.out.println(l);
//        System.out.println(l1);
        //7737
        //8687
        //这里会看到快速排序比随机快速排序要快，这是为什么呢？有一下两点原因
        /**
         * 1. 随机快速排序中产生随机index和额外的swap交换都会产生额外的时间
         * 2. 快速排序与随机快速排序只有在最恶劣的环境下（有序）的情况下才会展示出随机快速排序的好处，
         * 一般情况下两者时间都差不多（随即快速排序会多出选择随机数和swap产生的时间），
         */


        long l1=quickSortWorse(300,300,1000000);
        long l2=randomQuickSortWorse(300,300,1000000);
        System.out.println(l1);
        System.out.println(l2);
        //135
        //47
        /**
         * 这时在最坏的情况下明显可以看出在最坏的情况下，两者的时间差距就分长大了，甚至比上面非最坏情况差距还大。
         * 因为在一般情况下，两者的时间复杂度都是NlogN，
         * 但是在最坏情况下，随机快速排序还可以保持NlogN，但是快速排序的时间复杂度会退化为O(n^2)
         */




    }

    /**
     * 最坏情况下 有序情况下 快速排序测试
     * @param maxLength
     * @param maxValue
     * @param times
     * @return
     */
    public static long quickSortWorse(int maxLength,int maxValue,int times){
        long sum=0;
        for(int i=0;i<times;i++){
            int[] randomArr = getRandomArr(maxLength, maxValue);
            Arrays.sort(randomArr);
            Long start=System.currentTimeMillis();
            快速排序.quickSort(randomArr);
            Long end=System.currentTimeMillis();
            sum+=(end-start);

        }

        return sum;

    }

    /**
     * 最坏情况下 有序情况下 快速排序测试
     * @param maxLength
     * @param maxValue
     * @param times
     * @return
     */
    public static long randomQuickSortWorse(int maxLength,int maxValue,int times){
        long sum=0;
        for(int i=0;i<times;i++){
            int[] randomArr = getRandomArr(maxLength, maxValue);
            Arrays.sort(randomArr);
            Long start=System.currentTimeMillis();
            随机快速排序.randomQuickSort(randomArr);
            Long end=System.currentTimeMillis();
            sum+=(end-start);

        }

        return sum;

    }


    /**
     * 一般情况下的快速排序测试
     * @param maxLength
     * @param maxValue
     * @param times
     * @return
     */
    public static long quickTest(int maxLength,int maxValue,int times){
        long start = System.currentTimeMillis();
        for(int i=0;i<times;i++){
            int[] randomArr = getRandomArr(maxLength, maxValue);
            快速排序.quickSort(randomArr);
        }
        long end = System.currentTimeMillis();
        return end-start;
    }

    /**
     * 一般情况下随机快速排序的测试
     * @param maxLength
     * @param maxValue
     * @param times
     * @return
     */
    public static long randomQuickTest(int maxLength,int maxValue,int times){
        long start = System.currentTimeMillis();
        for(int i=0;i<times;i++){
            int[] randomArr = getRandomArr(maxLength, maxValue);
            随机快速排序.randomQuickSort(randomArr);
        }
        long end = System.currentTimeMillis();
        return end-start;
    }

    /**
     * 生成随机数组
     * @param maxLength
     * @param maxValue
     * @return
     */
    public static int[] getRandomArr(int maxLength,int maxValue){
        int len=(int)(Math.random()*maxLength);
        int[] arr=new int[len];

        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*maxLength);

        }

        return arr;
    }
}
