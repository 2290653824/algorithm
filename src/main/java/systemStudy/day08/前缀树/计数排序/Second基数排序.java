package systemStudy.day08.前缀树.计数排序;

/**
 * 非负，可以用十进制进行排序
 * radixSort
 *
 * 负数也可以改变
 * O(N*log10 MAX)
 * 但是实际上max的位数一般很小，对多也就10位，常见4位，所以可以忽略
 * 即复杂度为O(N)
 *
 * 原理，有一系列非负数，计算出其中位数最多的位数，并将其余数补0。创建10个桶
 * 从个位 从左往右遍历，将对应数字放到对应的桶中，并采用先进先出的方式，将数字进行排序
 */
public class Second基数排序 {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    // arr[L..R]排序  ,  最大值的十进制位数digit
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        // 有多少个数准备多少个辅助空间
        int[] help = new int[R - L + 1];
        for (int d = 1; d <= digit; d++) { // 有多少位就进出几次
            // 10个空间
            // count[0] 当前位(d位)是0的数字有多少个
            // count[1] 当前位(d位)是(0和1)的数字有多少个
            // count[2] 当前位(d位)是(0、1和2)的数字有多少个
            // count[i] 当前位(d位)是(0~i)的数字有多少个
            int[] count = new int[radix]; // count[0..9]

            //将count数组进行统计
            for (i = L; i <= R; i++) {
                // 103  1   3
                // 209  1   9
                j = getDigit(arr[i], d);
                count[j]++;
            }

            //将count数组进行累加和
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            //从右往左便利，并将排序得到得顺序写到help数组中
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }

//            将辅助数组中的值回写到arr中,以便循环使用
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = help[j];
            }
        }
    }

    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }
}
