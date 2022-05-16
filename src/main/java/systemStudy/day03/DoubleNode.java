package systemStudy.day03;

public class DoubleNode {


    public static void main(String[] args) {
        DoubleNode head = getRandomDoubleNodeLinks(10, 10);
        printDoubleNodeLinks(head);



    }

    public int value;
    public DoubleNode next;
    public DoubleNode pre;


    public DoubleNode(int value) {
        this.value = value;
    }

    public DoubleNode(int value, DoubleNode next, DoubleNode pre) {
        this.value = value;
        this.next = next;
        this.pre = pre;
    }

    public DoubleNode() {
    }


    /**
     * 打印双向链表
     *
     * @param head
     */
    public static void printDoubleNodeLinks(DoubleNode head) {
        DoubleNode p = null;
        while (head != null) {
            p = head;
            System.out.print(head.value);
            if (head.next != null) {
                System.out.print(" > ");
            }
            head = head.next;

        }
        System.out.println();

        while (p != null) {
            System.out.print(p.value);
            if (p.pre != null) {

                System.out.print(" > ");
            }
            p = p.pre;
        }
        System.out.println();

    }


    /**
     * 生成一个随机的双向链表
     * @param maxLength
     * @param maxValue
     * @return
     */
    public static DoubleNode getRandomDoubleNodeLinks(int maxLength, int maxValue) {
        int len=(int)(Math.random()*maxLength);
        DoubleNode newhead=new DoubleNode();
        for(int i=0;i<len;i++){
            int value=(int)(Math.random()*maxValue);
            DoubleNode newnode = new DoubleNode(value);
            newnode.next=newhead.next;
            newnode.pre=newhead;
            if(newhead.next!=null){

                newhead.next.pre=newnode;
            }
            newhead.next=newnode;

        }
        DoubleNode ans=newhead.next;
        ans.pre=null;

        return ans;
    }

    /**
     * 反转双向链表
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleNodeLink(DoubleNode head){
        DoubleNode pre=null;
        DoubleNode next=null;

        while(head!=null){

            next=head.next;
            head.next=pre;
            if(pre!=null){
                pre.pre=head;
            }
            pre=head;
            head=next;
        }

        return pre;

    }
}
