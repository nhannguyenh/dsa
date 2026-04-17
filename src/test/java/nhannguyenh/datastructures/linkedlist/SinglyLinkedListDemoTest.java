package nhannguyenh.datastructures.linkedlist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SinglyLinkedListDemoTest {
    private SinglyLinkedListDemo singlyLinkedList;

    @BeforeEach
    void setUp() {
        singlyLinkedList = new SinglyLinkedListDemo();
    }

    @AfterEach
    void tearDown() {
        singlyLinkedList = null;
    }

    @Test
    void shouldReturnEmptyString_whenHeadElementIsNull() {
        assertEquals("", singlyLinkedList.traversal(null));
    }

    @Test
    void shouldReturnData_whenLinkedListHasOneElement() {
        assertEquals("1", singlyLinkedList.traversal(new Node(1)));
    }

    @Test
    void shouldReturnDataChain_whenLinkedListHasMultipleElements() {
        Node head = initSinglyLinkedList();

        assertEquals("1 -> 3 -> 5", singlyLinkedList.traversal(head));
    }

    @Test
    void shouldReturnNewElement_whenAddingNewElementToBeginning() {
        Node head = singlyLinkedList.insertFirst(null, new Node(7));
        assertEquals("7", singlyLinkedList.traversal(head));
    }

    @Test
    void shouldReturnLinkedListHasCorrectOrder_whenAddingNewElementToBeginning() {
        Node head = initSinglyLinkedList();

        head = singlyLinkedList.insertFirst(head, new Node(7));

        assertEquals("7 -> 1 -> 3 -> 5", singlyLinkedList.traversal(head));
    }

    @Test
    void shouldReturnNewElement_whenAddingNewElementToTheEnd() {
        Node head = singlyLinkedList.insertLast(null, new Node(7));
        assertEquals("7", singlyLinkedList.traversal(head));
    }

    @Test
    void shouldReturnLinkedListHasCorrectOrder_whenAddingNewElementToTheEnd() {
        Node head = initSinglyLinkedList();

        head = singlyLinkedList.insertLast(head, new Node(7));

        assertEquals("1 -> 3 -> 5 -> 7", singlyLinkedList.traversal(head));
    }

    @Test
    void giveInvalidIndex_whenHeadIsNull_thenThrowIndexOutOfBoundsException() {
        Exception exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> singlyLinkedList.insertAt(null, new Node(7), 2)
        );

        assertEquals("Position is out of the LinkedList's range", exception.getMessage());
    }

    @Test
    void shouldReturnLinkedListHasCorrectOrder_whenAddingNewElementToAnyPosition() {
        Node head = initSinglyLinkedList();

        head = singlyLinkedList.insertAt(head, new Node(7), 3);

        assertEquals("1 -> 3 -> 7 -> 5", singlyLinkedList.traversal(head));
    }

    @Test
    void shouldThrowIndexOutOfBoundsException_whenRemoveFirstElementFromEmptyList() {
        Exception exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> singlyLinkedList.removeFirst(null)
        );

        assertEquals("Can't remove from empty LinkedList", exception.getMessage());
    }

    @Test
    void shouldReturnLinkedList_whenRemoveHead() {
        Node head = initSinglyLinkedList();

        head = singlyLinkedList.removeFirst(head);

        assertEquals("3 -> 5", singlyLinkedList.traversal(head));
    }

    @Test
    void shouldThrowIndexOutOfBoundsException_whenRemoveLastElementFromEmptyList() {
        Exception exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> singlyLinkedList.removeLast(null)
        );

        assertEquals("Can't remove from empty LinkedList", exception.getMessage());
    }

    @Test
    void shouldReturnLinkedList_whenRemoveLastElement() {
        Node head = initSinglyLinkedList();

        head = singlyLinkedList.removeLast(head);

        assertEquals("1 -> 3", singlyLinkedList.traversal(head));
    }

    @Test
    void shouldReturnLinkedList_whenRemoveElementAtAnyPosition() {
        Node head = initSinglyLinkedList();

        head = singlyLinkedList.removeAt(head, 3);

        assertEquals("1 -> 3", singlyLinkedList.traversal(head));
    }

    private Node initSinglyLinkedList() {
        Node head = new Node(1);
        Node newNode = new Node(3);
        Node tail = new Node(5);

        head.next = newNode;
        newNode.next = tail;
        return head;
    }
}
