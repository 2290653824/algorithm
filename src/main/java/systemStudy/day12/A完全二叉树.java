package systemStudy.day12;

import systemStudy.day10二叉树上.栈的公共结构_可以调用.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 怎么判断完全二叉树
 * 1.前面的节点不会出现 不双全 节点   （有右无左，直接false）
 *
 * 2.第一次遇到不 双全的节点，则后续节点全为叶子节点
 */
public class 完全二叉树 {


    /**
     * 只能通过层序遍历进行判断
     * 判断一颗树是不是完全二叉树
     */
    public static boolean panduan(Node root){
        if(root==null) return false;

        Queue<Node> q=new LinkedList<Node>();
        q.offer(root);
        Node left=null;
        Node right=null;
        boolean flag=false; //是否已经遇到了左右不全的节点
        while(!q.isEmpty()){
            Node node = q.poll();
            left=node.left;
            right=node.right;
            if((flag&&(left!=null||right != null))  //已经遇到了非双全节点，但是后续节点出现非叶子节点
                ||
            (left==null&&right != null)            //出现左无右有 直接判定不是完全二叉树
            ){
                return false;
            }

            if(left!=null) q.offer(left);
            if(right!=null) q.offer(right);
            if(left==null||right==null){           //判断是否出现了非双全节点
                flag=true;
            }
        }
        return true;
    }

}
