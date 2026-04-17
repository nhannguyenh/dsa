package nhannguyenh.datastructures.linkedlist;

import java.util.NoSuchElementException;
import java.util.Objects;

public class DoublyLinkedListDemo {

    public String traversal(Node head) {
        StringBuilder result = new StringBuilder();
        while (Objects.nonNull(head)) {
            if (Objects.nonNull(head.next)) {
                result.append(head.data).append(" -> ");
            } else {
                result.append(head.data);
            }
            head = head.next;
        }
        return result.toString();
    }

    public Node insertFirst(Node head, int data) {
        Node newNode = new Node(data);

        if (Objects.isNull(head)) {
            return newNode;
        }

        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    public Node insertLast(Node head, int data) {
        Node newNode = new Node(data);
        if (Objects.isNull(head)) {
            return newNode;
        }

        Node current = head;
        while (Objects.nonNull(current.next)) {
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;
        return head;
    }

    public Node insertAt(Node head, int data, int position) {
        Node newNode = new Node(data);

        // get the element before the position
        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        // insert new node to the position
        newNode.next = current.next;
        newNode.prev = current;
        current.next = newNode;
        return head;
    }

    public Node removeFirst(Node head) {
        if (Objects.isNull(head)) {
            throw new NoSuchElementException("Cannot remove from empty linked list");
        }

        head = head.next;
        head.prev = null;
        return head;
    }

    public Node removeLast(Node head) {
        if (Objects.isNull(head)) {
            throw new NoSuchElementException("Cannot remove from empty linked list");
        }

        // get the last node
        Node current = head;
        while (Objects.nonNull(current.next)) {
            current = current.next;
        }

        // remove last node
        current = current.prev;
        current.next = null;
        return head;
    }

    public Node removeAt(Node head, int position) {
        // get the node before position need to delete
        Node current = head;
        for (int i = 1; i <= position - 1; i++) {
            current = current.next;
        }

        if (Objects.isNull(current.next)) {
            removeLast(current);
        } else {
            // remove the node at requested position
            Node prevNode = current.prev;
            Node nextNode = current.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        return head;
    }
}
