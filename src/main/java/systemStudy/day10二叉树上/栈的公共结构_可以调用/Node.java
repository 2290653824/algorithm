package systemStudy.day10二叉树.栈的公共结构_可以调用;

public class Node {

    public Node left;
    public Node right;
    public String value;


    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", value='" + value + '\'' +
                '}';
    }
}
