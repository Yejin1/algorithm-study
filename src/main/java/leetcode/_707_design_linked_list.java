package leetcode;

// Leetcode
// 707. Design Linked List
// https://leetcode.com/problems/design-linked-list/description/
// 유형 : 자료구조 구현

public class _707_design_linked_list {
    class MyLinkedList {

        class Node{
            int val;
            Node next;
            Node(int val) {
                this.val = val;
            }
        }

        Node head;
        Node tail;
        int size;

        public MyLinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        public int get(int index) {
            if(index < 0 || index >= size) return -1;
            if(index ==0) return head.val;
            if(index == size-1) return tail.val;

            Node node = head;
            for(int i=0; i<index; i++) node = node.next;

            return node.val;
        }

        public void addAtHead(int val) {

            Node node = new Node(val);
            if(size>0){
                node.next = head;
                head = node;
            }
            else {
                head = node;
                tail = node;
            }

            size++;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);
            if(size>0){
                tail.next = node;
                tail = node;
            }
            else {
                head = node;
                tail = node;
            }

            size++;
        }

        public void addAtIndex(int index, int val) {
            if(index==0) {
                addAtHead(val);
                return;
            }
            else if(index==size) {
                addAtTail(val);
                return;
            }
            if(index > size) return;

            Node prev = head;
            for(int i=0; i<index-1; i++){
                prev = prev.next;
            }

            Node node = new Node(val);
            node.next= prev.next;
            prev.next = node;

            size++;


        }

        public void deleteAtIndex(int index) {
            if(index >= size) return;
            if(index==0){
                head = head.next;
                size--;
                return;
            }

            Node prev = head;
            for(int i=0; i<index-1; i++){
                prev = prev.next;
            }

            Node node = prev.next;
            prev.next = node.next;
            if(index == size-1) tail = prev;

            size--;

        }
    }


}
