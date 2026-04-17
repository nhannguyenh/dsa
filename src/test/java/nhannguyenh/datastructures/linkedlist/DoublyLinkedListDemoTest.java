package nhannguyenh.datastructures.linkedlist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DoublyLinkedListDemoTest {
    private  DoublyLinkedListDemo doublyLinkedList;

    @BeforeEach
    void setup() {
        doublyLinkedList = new DoublyLinkedListDemo();
    }

    @AfterEach
    void tearDown() {
        doublyLinkedList = null;
    }

    @Test
    void shouldReturnData_whenLinkedListHasOneElement() {
        assertEquals("1", doublyLinkedList.traversal(new Node(1)));
    }

    @Test
    void shouldReturnDataChain_whenLinkedListHasMultipleElements() {
        Node head = initDoublyLinkedList();

        assertEquals("1 -> 3 -> 5", doublyLinkedList.traversal(head));
    }

    @Test
    void shouldReturnNewElement_whenAddNewElementToTheBeginningOfEmptyList() {
        Node head = doublyLinkedList.insertFirst(null, 7);
        assertEquals("7", doublyLinkedList.traversal(head));
    }

    @Test
    void shouldReturnLinkedList_whenAddNewElementToTheBeginning() {
        Node head = initDoublyLinkedList();
        head = doublyLinkedList.insertFirst(head, 7);

        assertEquals("7 -> 1 -> 3 -> 5", doublyLinkedList.traversal(head));
    }

    @Test
    void shouldReturnNewElement_whenAddNewElementToTheEndOfEmptyList() {
        Node head = doublyLinkedList.insertLast(null, 7);
        assertEquals("7", doublyLinkedList.traversal(head));
    }

    @Test
    void shouldReturnLinkedList_whenAddNewElementToTheEnd() {
        Node head = initDoublyLinkedList();
        head = doublyLinkedList.insertLast(head, 7);

        assertEquals("1 -> 3 -> 5 -> 7", doublyLinkedList.traversal(head));
    }

    @Test
    void shouldReturnLinkedList_whenAddNewElementToAnyPosition() {
        Node head = initDoublyLinkedList();

        head = doublyLinkedList.insertAt(head, 7, 3);

        assertEquals("1 -> 3 -> 7 -> 5", doublyLinkedList.traversal(head));
    }

    @Test
    void shouldReturnLinkedList_whenRemoveHead() {
        Node head = initDoublyLinkedList();

        head = doublyLinkedList.removeFirst(head);

        assertEquals("3 -> 5", doublyLinkedList.traversal(head));
    }

    @Test
    void shouldThrowNoSuchElementException_whenRemoveFirstElementFromEmptyList() {
        Exception exception = assertThrows(
                NoSuchElementException.class,
                () -> doublyLinkedList.removeFirst(null)
        );

        assertEquals("Cannot remove from empty linked list", exception.getMessage());
    }

    @Test
    void shouldReturnLinkedList_whenRemoveLastElement() {
        Node head = initDoublyLinkedList();

        head = doublyLinkedList.removeLast(head);

        assertEquals("1 -> 3", doublyLinkedList.traversal(head));
    }

    @Test
    void shouldThrowNoSuchElementException_whenRemoveLastElementFromEmptyList() {
        Exception exception = assertThrows(
                NoSuchElementException.class,
                () -> doublyLinkedList.removeLast(null)
        );

        assertEquals("Cannot remove from empty linked list", exception.getMessage());
    }

    @Test
    void shouldReturnLinkedList_whenRemoveElementAtAnyPosition() {
        Node head = initDoublyLinkedList();
        head = doublyLinkedList.insertLast(head, 7);
        head = doublyLinkedList.removeAt(head, 2);

        assertEquals("1 -> 5 -> 7", doublyLinkedList.traversal(head));
    }

    private Node initDoublyLinkedList() {
        Node head = new Node(1);
        Node newNode = new Node(3);
        Node tail = new Node(5);

        head.next = newNode;
        newNode.prev = head;

        newNode.next = tail;
        tail.prev = newNode;
        return head;
    }
}
