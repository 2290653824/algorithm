package MyDraft;

import jdk.management.resource.internal.inst.WindowsAsynchronousFileChannelImplRMHooks;

public class Treies {

    public static class Node{
        int pass;
        int end;
        Node[] nexts=new Node[26];
    }

    Node root;


    public void insertWord(String word){
        if(word==null||word.length()==0) return;
        char[] chars = word.toCharArray();
        int index=0;
        Node node=root;
        node.pass++;
        for (int i = 0; i < chars.length; i++) {
            index=chars[i]-'a';
            if(node.nexts[index]==null){
                node.nexts[index] = new Node();
            }
            node=node.nexts[index];
            node.pass++;
        }
        node.end++;

    }

    public int search(String word){
        if(word==null||word.length()==0) return 0;
        int index = 0;
        Node node = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            index=chars[i]-'a';
            if(node.nexts[index]==null){
                return 0;
            }
            node = node.nexts[index];

        }
        return node.end;
    }

    public int prefixNum(String word){
        if(word==null||word.length()==0) return 0;
        int index = 0;
        Node node = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            index=chars[i]-'a';
            if(node.nexts[index]==null){
                return 0;
            }
            node = node.nexts[index];

        }
        return node.end;
    }

    public void delete(String word){
        if(word==null||word.length()==0) return;
        if(search(word)==0) return;
        int index=0;
        Node node=root;
        node.pass--;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            index=chars[i] - 'a';
            if(--node.nexts[index].pass==0){
                node.nexts[index]=null;
                return;
            }
            node=node.nexts[index];
        }
        node.end--;
    }

}
