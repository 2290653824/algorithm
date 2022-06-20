package systemStudy.day06.比较器;

import javax.print.DocFlavor;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(3);
        queue.add(4);
        queue.add(6);
        queue.add(8);
        queue.add(4);
        queue.add(1);
        System.out.println(queue);

    }
}
