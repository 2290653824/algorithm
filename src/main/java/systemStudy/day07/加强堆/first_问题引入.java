package systemStudy.day07.加强堆;

import java.util.*;

/**
 * 1.做题技巧，如何决策一个题用多少时间复杂度的算法？
 * 如果给定的N=10^3,则将O(N*2) 约等于 10^6
 * 一般java运行时间在2-4s，也就是10^8
 * 这时就表示时间复杂度O(N^2) 可以通过测试
 *
 *
 * 2. 最大线段重合问题：
 *  给定很多线段，每个线段都有两个数组[start,end]
 *  表示线段的开始位置和结束位置，左右都是闭区间，
 *  规定：
 *  1）线段的开始位置和结束位置都是整数值
 *  2）线段重合区域的长度必须>=1
 *
 *  要求返沪最多重合区域中，包含了多少条线段
 */
public class first_问题引入 {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(7);

        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(2);
        a2.add(3);

        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(4);
        a3.add(6);

        ArrayList<Integer> a4 = new ArrayList<>();
        a4.add(4);
        a4.add(5);

        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(a1);
        lists.add(a2);
        lists.add(a3);
        lists.add(a4);

        int max = Solution.getMax(lists);
        System.out.println(max);
    }

}

class Solution{

    //保证参数list中都是大小为2的list
    public static int getMax(List<List<Integer>> list){
        //将每个线段的开始位置按从大到小进行排序

        list.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0)-o2.get(0);
            }
        });


        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (List<Integer> integers : list) {
            int start=integers.get(0);
            int end=integers.get(1);
            while(queue.size()!=0&&queue.peek()<=start){
                queue.poll();
            }
            queue.add(end);

        }

        return queue.size();



    }
}
