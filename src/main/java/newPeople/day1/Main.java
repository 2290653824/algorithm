package newPeople.day1;

public class Main {

    public static void main(String[] args) {
//        printBinaryNum(-4);
//        printBinaryNum(-4>>>1);
//        printBinaryNum(~(-4)+1);
//        System.out.println(~(-4)+1);
//        System.out.println(printJieCheng(3));


        int[] arr=new int[]{1,4,2,8,5,3,1};
        insertSort(arr);
        print(arr);

    }

    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }


    /**
     * 显示二进制
     * @param num
     */
    public static void printBinaryNum(int num){

        for(int i=31;i>=0;i--){
            System.out.print(((1 << i) & num)==0 ?"0":"1");
//            System.out.print();
        }
        System.out.println();
    }


    /**
     * 计算阶乘
     * @param N
     */
    public static long printJieCheng(int N){
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= N; i++) {
            cur = cur * i;
//            ans *= cur;
        }
//        return ans;

        return cur;
    }

    public static void swap(int arr[] ,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr){
        if(arr==null&&arr.length<2){
            return;
        }

        int len=arr.length;
        for(int i=0;i<len-1;i++){
            int minValueIndex=i;
            for(int j=minValueIndex+1;j<len;j++){
                minValueIndex=arr[minValueIndex]>arr[j]?j:minValueIndex;
            }
            swap(arr,i,minValueIndex);

        }
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        if(arr==null|| arr.length<2){
            return;
        }

        for(int i=arr.length-1;i>=0;i--){
            for(int second=1;second<=i;second++){
                if(arr[second-1]>arr[second]){
                    swap(arr,second,second-1);
                }
            }
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }

        for(int end=1;end<arr.length;end++){
            for(int pre=end-1;pre>=0&&arr[pre]>arr[pre+1];pre--){
                swap(arr,pre,pre+1);
            }
        }
    }
}



