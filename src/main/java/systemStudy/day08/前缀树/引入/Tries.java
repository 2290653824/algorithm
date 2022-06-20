package systemStudy.day08.前缀树.引入;

/**
 * 我们假设该前缀树是针对于26位字母的字符串前缀树
 */
public class Tries {

    private Node root;

    public static class Node{
        public int pass; //有多少个字符串路径经过这个节点
        public int end; //有多少字符串结尾在该节点
        public Node[] nexts; //该节点的下一个节点，多叉树
    }

    public Tries(){
        root=new Node();
    }

    public void insert(String word){
        if(word==null){
            return;
        }
        char[] chs=word.toCharArray();
        Node node=root;
        node.pass++;
        int index=0;
        for(int i=0;i<chs.length;i++){
            index=chs[i]-'a'; //下个字符应该存在什么位置
            if(node.nexts[index]==null){
                node.nexts[index]=new Node();

            }
            node=node.nexts[index];
            node.pass++;

        }
        node.end++;
    }

    //查看某个单词出现了几次
    public int search(String word){
        if(word==null){
            return 0;
        }
        char[] chs=word.toCharArray();
        Node node=root;
        int index=0;
        for(int i=0;i<chs.length;i++){
            index=chs[i]-'a';
            if(node.nexts[index]==null){
                return 0;
            }
            node=node.nexts[index];
        }
        return node.end;
    }

    //所有加入的字符串中，有几个是以pre这个字符串为前缀的
    public int prefixNumber(String pre){
        if(pre==null){
            return 0;
        }

        char[] chs=pre.toCharArray();
        int index=0;
        Node node=root;
        for(int i=0;i<chs.length;i++){
            index=chs[i]-'a';
            if(node.nexts[index]==null){
                return 0;
            }
            node=node.nexts[index];
        }
        return node.pass;
    }

    //删除一个字符串
    public void delete(String word){
        if(search(word)!=0){
            char[] chs=word.toCharArray();
            Node node=root;
            node.pass--;
            int index=0;
            for(int i=0;i<chs.length;i++){
                index=chs[i]-'a';
                if(--node.nexts[index].pass==0){
                    node.nexts[index]=null;
                    return;
                }
                node=node.nexts[index];
            }
            node.end--;

        }

    }




}
