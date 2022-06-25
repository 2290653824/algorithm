package systemStudy.day10二叉树;

/**
 * 使用递归遍历，最强点
 * 会发现先序，中序，后序的遍历的代码形式都差不多
 * 要看到其本质：递归序：在一个函数中，如果有两个递归调用，则该函数会遍历3次。而先序遍历就是第一次出现这个函数的
 * 时候进行打印
 */
public class 二叉树的遍历 {

    public static void main(String[] args) {
        Node node = new Node();
        node.value=2;
        node.left=new Node();
        node.right=new Node();
        node.left.value=4;
        node.right.value=7;
        preSort(node);

    }

    private Node node;

    static class Node{
        int value;
        Node left;
        Node right;
    }

    /**
     * 先序遍历
     * @param root
     */
    public static void preSort(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.value);
        preSort(root.left);
        preSort(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void MediaSort(Node root){
        if(root == null){
            return;
        }
        MediaSort(root.left);
        System.out.println(root.value);
        MediaSort(root.right);
    }

    /**
     * 后续遍历
     * @param root
     */
    public static void HouSort(Node root){
        if(root == null){
            return;
        }
        HouSort(root.left);
        System.out.println(root.value);
        HouSort(root.right);
    }


}

