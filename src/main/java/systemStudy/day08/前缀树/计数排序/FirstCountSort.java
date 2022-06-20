package systemStudy.day08.前缀树.计数排序;

/**
 * 桶排序（桶思想，一个桶里可以放置多个相同的数据）
 * 前面都是基于比较的排序，
 * 而桶排序是基于计数排序，不是基于比较的排序
 * 不基于比较必须有限定的范围内，使用范围比较小
 *
 * 目前基于比较的排序最好是O(N*logN) 堆排序
 * 基于非比较的排序最好是堆排序
 */
public class FirstCountSort {

    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }
}
