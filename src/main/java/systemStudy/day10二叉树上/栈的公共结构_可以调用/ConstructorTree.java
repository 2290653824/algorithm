package systemStudy.day10二叉树.栈的公共结构_可以调用;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ConstructorTree {

    public static void main(String[] args) {
//        printRoot(getRoot());
        System.out.println(getRoot().left.value);
        System.out.println(getRoot().right.value);
    }

    public static Node getRoot(){
        Node root = new Node();
        Node cur=root;
        cur.value="a";
        cur.left=new Node();
        cur.right=new Node();
        cur.left.value="b";
        cur.right.value="c";
        cur=root.left;
        cur.left=new Node();
        cur.right=new Node();
        cur.left.value="d";
        cur.right.value="e";
        cur=root.right;
        cur.left=new Node();
        cur.right=new Node();
        cur.left.value="f";
        cur.right.value="g";
        return root;
    }

    public static void printRoot(Node root){
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.push(root);
        while(!queue.isEmpty()){
            Node node = queue.pop();
            System.out.println(node.value);
            if(node.left!=null)
            queue.push(node.left);
            if(node.right!=null)
            queue.push(node.right);
        }
    }
}
