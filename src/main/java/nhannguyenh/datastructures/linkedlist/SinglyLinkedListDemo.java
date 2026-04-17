package nhannguyenh.datastructures.linkedlist;

import java.util.Objects;

public class SinglyLinkedListDemo {

    public String traversal(SinglyLinkedListNode head) {
        if (Objects.isNull(head)) {
            return "";
        }

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

    public SinglyLinkedListNode insertFirst(SinglyLinkedListNode head, SinglyLinkedListNode newNode) {
        if (Objects.isNull(head)) {
            return newNode;
        }

        newNode.next = head;
        return newNode;
    }

    public SinglyLinkedListNode insertLast(SinglyLinkedListNode head, SinglyLinkedListNode newNode) {
        if (Objects.isNull(head)) {
            return newNode;
        }

        SinglyLinkedListNode currentElement = head;
        while (currentElement.next != null) {
            currentElement = currentElement.next;
        }
        currentElement.next = newNode;
        return head;
    }

    public SinglyLinkedListNode insertAt(SinglyLinkedListNode head, SinglyLinkedListNode newNode, int position) {
        if (Objects.isNull(head) && position > 1) {
            throw new IndexOutOfBoundsException("Position is out of the LinkedList's range");
        }

        if (Objects.isNull(head) && position == 1) {
            return insertFirst(null, newNode);
        }

        SinglyLinkedListNode currentElement = head;
        for (int i = 1; i < position - 1; i++) {
            currentElement = currentElement.next;
        }

        newNode.next = currentElement.next;
        currentElement.next = newNode;
        return head;
    }

    public SinglyLinkedListNode removeFirst(SinglyLinkedListNode head) {
        if (Objects.isNull(head)) {
            throw new IndexOutOfBoundsException("Can't remove from empty LinkedList");
        }

        head = head.next;
        return head;
    }

    public SinglyLinkedListNode removeLast(SinglyLinkedListNode head) {
        if (Objects.isNull(head)) {
            throw new IndexOutOfBoundsException("Can't remove from empty LinkedList");
        }

        SinglyLinkedListNode currentElement = head;
        while (Objects.nonNull(currentElement.next.next)) {
            currentElement = currentElement.next;
        }

        currentElement.next = null;
        return head;
    }

    public SinglyLinkedListNode removeAt(SinglyLinkedListNode head, int position) {
        SinglyLinkedListNode currentElement = head;
        for (int i = 1; i < position - 1; i++) {
            currentElement = currentElement.next;
        }

        currentElement.next = currentElement.next.next;
        return head;
    }
}
