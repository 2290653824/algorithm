package systemStudy.day10二叉树;

import systemStudy.day10二叉树.栈的公共结构_可以调用.ConstructorTree;
import systemStudy.day10二叉树.栈的公共结构_可以调用.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 先序遍历和后序遍历可以使用一个套路，不过后序遍历需要使用两个栈结构
 */
public class Third二叉树的非递归遍历 {


    public static void main(String[] args) {
        Node root = ConstructorTree.getRoot();
        List xianxu = getZhongxu(root);
        System.out.println(xianxu);

    }

    /**
     * 左神中序
     */
    public static void in(Node cur) {
        System.out.print("in-order: ");
        if (cur != null) {
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    System.out.print(cur.value + " ");
                    cur = cur.right;
                }
            }
        }
        System.out.println();
    }


    /**
     * 中序遍历,使用栈结构，先将左下全部节点加入到栈中
     */
    public static List<String> getZhongxu(Node root){
        if(root == null) return null;
        ArrayList<String> strings = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.println(pop.value);
            strings.add(pop.value);
            if(pop.right!=null){
                stack.push(pop.right);

                pop=pop.right;
                while(pop.left!=null){
                    stack.push(pop.left);
                    pop = pop.left;
                }

            }
        }
        return strings;

    }

    /**
     * 后续遍历使用两个栈
     * @param root
     * @return
     */
    public static List<String> getHouxu(Node root){
        if(root == null) return null;
        Stack<Node> stack = new Stack<>();
        Stack<String> printStack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            printStack.push(node.value);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }

        }

        ArrayList<String> strings = new ArrayList<>();
        while(!printStack.isEmpty()){
            strings.add(printStack.pop());
        }
        return strings;


    }

    /**
     * 先序遍历,使用一个栈既可以实现
     * @param root
     * @return
     */
    public static List getXianxu(Node root){
        if(root == null) return null;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.push(root);
        ArrayList<Node> nodes = new ArrayList<>();
        while(!queue.isEmpty()){
            Node node = queue.pop();
            System.out.println(node.value);
            nodes.add(node);


            if(node.right!=null) {
                queue.push(node.right);
            }
            if(node.left!=null)
                queue.push(node.left);
        }

        return nodes;
    }

}
