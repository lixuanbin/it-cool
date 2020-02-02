package co.speedar.infra.itcool.list.copy_list_with_random_pointer;

import co.speedar.infra.itcool.list.Node;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node[] index = new Node[1000];
        int i = 0;
        index[0] = head;
        Node copiedHead = new Node(head.val);
        Node iNode = copiedHead;
        // copy list and set next
        while (head.next != null) {
            // forward pointer
            i++;
            head = head.next;
            index[i] = head; // remember origin node
            Node newNode = new Node(head.val); // copy node
            // chain new node
            iNode.next = newNode;
            iNode = iNode.next;
        }
        int length = i + 1;
        iNode = copiedHead;
        // set random of new list
        for (int j = 0; j < length; j++) {
            if (index[j].random == null) {
                iNode.random = null;
            } else {
                int k = findIndex(index[j].random, index, length);
                if (k < 0) {
                    iNode.random = null;
                } else {
                    Node tmp = copiedHead;
                    for (int l = 0; l < k; l++) {
                        tmp = tmp.next;
                    }
                    iNode.random = tmp;
                }
            }
            iNode = iNode.next;
        }
        return copiedHead;
    }
    private int findIndex(Node node, Node[] array, int length) {
        for (int i = 0; i < length; i++) {
            if (array[i] == node) {
                return i;
            }
        }
        return -1;
    }
}