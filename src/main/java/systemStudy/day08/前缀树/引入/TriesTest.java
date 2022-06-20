package systemStudy.day08.前缀树.引入;

import java.util.ArrayList;
import java.util.Arrays;

public class TriesTest {

    public static void main(String[] args) {
        TriesTest triesTest = new TriesTest();
        triesTest.insert("zhengjian");
        triesTest.insert("yuexiaoqian");
        triesTest.insert("wujunjie");

        System.out.println(triesTest.search("zh"));
        System.out.println(triesTest.prefixNum("zh"));
        System.out.println(triesTest.root);
        triesTest.delete("zhengjian");
        System.out.println(triesTest.prefixNum("zh"));
        System.out.println(triesTest.prefixNum("yuexiaoo"));

    }

    Node root;
    static class Node{
        int pass;
        int end;
        Node[] nexts;

        public Node(){
            nexts=new Node[26];
        }

        @Override
        public String toString() {
            return "Node{" +
                    "pass=" + pass +
                    ", end=" + end +
                    ", nexts=" + Arrays.toString(nexts) +
                    '}';
        }
    }

    public TriesTest(){
        root=new Node();
    }

    public void insert(String word){
        if(word==null){
            return;
        }

        char[] chars = word.toCharArray();
        int index=0;
        Node node=root;
        node.pass++;
        for (int i = 0; i < chars.length; i++) {
            index=chars[i]-'a';
            if(node.nexts[index]==null){
                node.nexts[index]=new Node();
            }
            node=node.nexts[index];
            node.pass++;
        }

        node.end--;
    }

    public int search(String word){
        if(word==null) return 0;
        int index=0;
        Node node=root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            index=chars[i]-'a';
            if(node.nexts[index]==null) return 0;
            node=node.nexts[index];
        }
        return node.end;
    }

    public int prefixNum(String prefix){
        if(prefix==null||prefix.length()==0) return 0;

        int index=0;
        Node node=root;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            index=chars[i]-'a';
            if(node.nexts[index]==null){
                return 0;
            }
            node=node.nexts[index];

        }
        return node.pass;
    }

    public void delete(String word){
        if(search(word)!=0){
            char[] chars = word.toCharArray();
            Node node=root;
            int index=0;
            root.pass--;
            for (int i = 0; i < chars.length; i++) {
                index=chars[i]-'a';
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
