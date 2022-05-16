package systemStudy.day03;

/**
 * 单链表
 */
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.next=null;
    }

    public Node() {
    }


    public static void main(String[] args) {

        for(int i=0;i<10;i++){

            Node head = getRandomNodeLinks(10, 20);
            printNodeLinks(head);

            Node node = deleteValue(head, head.value);

            printNodeLinks(node);
        }


    }

    /**
     * 随机生成一个链表，返回头结点
     * @param maxlength
     * @param maxValue
     * @return
     */
    public static Node getRandomNodeLinks(int maxlength,int maxValue){
        int len=(int)(Math.random()*maxlength);
        Node node = new Node(-1);
        for(int i=0;i<len;i++){
            int value=(int)(Math.random()*maxValue);
            Node newnode = new Node(value);
            newnode.next=node.next;
            node.next=newnode;
        }

        return node.next;
    }


    /**
     * 打印链表
     * @param head
     */
    public static void printNodeLinks(Node head){

        while(head!=null){
            System.out.print(head.value);
            if(head.next!=null){
                System.out.print(" > ");
            }
            head=head.next;
        }

        System.out.println();
    }

    /**
     * 反转单向链表
     *
     * @param head
     * @return
     */
    public static Node returnReverseLinks(Node head) {
        Node pre = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    /**
     * 删除链表上指定的value
     * @param head
     * @param value
     * @return
     */
    public static Node deleteValue(Node head,int value){
        Node newhead=new Node();
        newhead.next=head;
        Node pre=newhead;
        Node next=head;
        while(next!=null){
            if(next.value==value){
                pre.next=next.next;
                next=pre.next;
            }else{
                pre=next;
                next=next.next;
            }

        }
        return newhead.next;


    }


}
