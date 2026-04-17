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
        assertEquals("1", singlyLinkedList.traversal(new SinglyLinkedListNode(1)));
    }

    @Test
    void shouldReturnDataChain_whenLinkedListHasMultipleElements() {
        SinglyLinkedListNode head = initSinglyLinkedList();

        assertEquals("1 -> 3 -> 5", singlyLinkedList.traversal(head));
    }

    @Test
    void shouldReturnNewElement_whenAddingNewElementToBeginning() {
        SinglyLinkedListNode head = singlyLinkedList.insertFirst(null, new SinglyLinkedListNode(7));
        assertEquals("7", singlyLinkedList.traversal(head));
    }

    @Test
    void shouldReturnLinkedListHasCorrectOrder_whenAddingNewElementToBeginning() {
        SinglyLinkedListNode head = initSinglyLinkedList();

        head = singlyLinkedList.insertFirst(head, new SinglyLinkedListNode(7));

        assertEquals("7 -> 1 -> 3 -> 5", singlyLinkedList.traversal(head));
    }

    @Test
    void shouldReturnNewElement_whenAddingNewElementToTheEnd() {
        SinglyLinkedListNode head = singlyLinkedList.insertLast(null, new SinglyLinkedListNode(7));
        assertEquals("7", singlyLinkedList.traversal(head));
    }

    @Test
    void shouldReturnLinkedListHasCorrectOrder_whenAddingNewElementToTheEnd() {
        SinglyLinkedListNode head = initSinglyLinkedList();

        head = singlyLinkedList.insertLast(head, new SinglyLinkedListNode(7));

        assertEquals("1 -> 3 -> 5 -> 7", singlyLinkedList.traversal(head));
    }

    @Test
    void giveInvalidIndex_whenHeadIsNull_thenThrowIndexOutOfBoundsException() {
        Exception exception = assertThrows(
                IndexOutOfBoundsException.class,
                () -> singlyLinkedList.insertAt(null, new SinglyLinkedListNode(7), 2)
        );

        assertEquals("Position is out of the LinkedList's range", exception.getMessage());
    }

    @Test
    void shouldReturnLinkedListHasCorrectOrder_whenAddingNewElementToAnyPosition() {
        SinglyLinkedListNode head = initSinglyLinkedList();

        head = singlyLinkedList.insertAt(head, new SinglyLinkedListNode(7), 3);

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
        SinglyLinkedListNode head = initSinglyLinkedList();

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
        SinglyLinkedListNode head = initSinglyLinkedList();

        head = singlyLinkedList.removeLast(head);

        assertEquals("1 -> 3", singlyLinkedList.traversal(head));
    }

    @Test
    void shouldReturnLinkedList_whenRemoveElementAtAnyPosition() {
        SinglyLinkedListNode head = initSinglyLinkedList();

        head = singlyLinkedList.removeAt(head, 3);

        assertEquals("1 -> 3", singlyLinkedList.traversal(head));
    }

    private SinglyLinkedListNode initSinglyLinkedList() {
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(3);
        SinglyLinkedListNode tail = new SinglyLinkedListNode(5);

        head.next = newNode;
        newNode.next = tail;
        return head;
    }
}
