package dailyChallenge;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeSortedListSolution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return new ListNode();
        }
        var count = Arrays.stream(lists).reduce(0, (a, b) -> a + length(b), Integer::sum);
        var priorityQueue = new PriorityQueue<>(count, Integer::compare);
        for (ListNode node : lists) {
            while (node != null) {
                priorityQueue.add(node.val);
                node = node.next;
            }
        }
        if (priorityQueue.isEmpty()) {
            return null;
        }
        var node = new ListNode(priorityQueue.poll());
        while (priorityQueue.size() != 0) {
            var nodeValue = priorityQueue.poll();
            lastNode(node).next = new ListNode(nodeValue);
        }
        return node;
    }

    private ListNode lastNode(ListNode node) {
        while (node != null) {
            if (node.next == null) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private int length(ListNode node) {
        var length = 1;
        while (node.next != null) {
            length ++;
            node = node.next;
        }
        return length;
    }

}


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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + (next != null ? next.toString() : "") +
                '}';
    }

}

class Demo {

    public static void main(String[] args) {
        var solution = new MergeSortedListSolution();
        var a = new ListNode(1, new ListNode(4, new ListNode(5)));
        var b = new ListNode(1, new ListNode(3, new ListNode(4)));
        var c = new ListNode(2, new ListNode(6));
        var nodeArray = new ListNode[] {a, b, c};

        var sortedListNode = solution.mergeKLists(nodeArray);
        System.out.println(sortedListNode);
    }


}