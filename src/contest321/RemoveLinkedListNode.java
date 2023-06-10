package contest321;

class ListNode {
    int val;
    ListNode next;
    ListNode tail;
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

public class RemoveLinkedListNode {

    public ListNode removeNodes(ListNode head) {
        int val = head.val;
        ListNode listHead = null;
        while (head != null) {
            if (head.val > val) {
                if (listHead == null) {
                    listHead = new ListNode(head.val);
                } else {
                    var node = new ListNode(head.val);
                    var tail = listHead.tail;
                    if (tail == null) {
                        listHead.next = listHead.tail = node;
                    } else {
                        tail.next = node;
                        listHead.tail = node;
                    }
                }
            }
            head = head.next;
        }
        return listHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        System.out.println(head);
        var removeNode = new RemoveLinkedListNode();
        var result = removeNode.removeNodes(head);
        System.out.println(result);
    }

}
