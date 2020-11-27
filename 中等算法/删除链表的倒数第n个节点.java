package 中等;

class ListNode {
     int val;
     ListNode next;

     ListNode() {
     }

     ListNode(int val) {
         this.val = val;
     }

     ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
     }
 }

public class 删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0){    //倒数第0个则不删
            return head;
        }
        if(head.next==null){      //链表只有一个节点
            if(n==1){
                return null;
            }
            else return head;
        }
        int count = nextNode(head,n,0);
        if(count==n) {    //头节点即要删的节点
            head=head.next;
        }
        return head;
    }
    public int nextNode(ListNode node,int n,int count){
        if(node.next==null){    //递归出口
            return count+1;
        }
        count = nextNode(node.next,n,count);
        if(count==n) {      //当前节点的下一个节点是要删除的节点
            if (node.next.next != null) {
                node.next = node.next.next;
            } else {
                node.next = null;
            }
        }
        return count+1;
    }
}
