package nhannguyenh.datastructures.array;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayDemoTest {
    private ArrayDemo arrayDemo;

    @BeforeEach
    void setup() {
        arrayDemo = new ArrayDemo();
    }

    @AfterEach
    void tearDown() {
        arrayDemo = null;
    }

    @Test
    void giveValidIndex_thenReturnElementAtIndex() {
        assertEquals(2, arrayDemo.getElementAtIndex(1, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    @Test
    void giveInvalidIndex_thenThrowArrayIndexOutOfBoundsException() {
        int index = 2;
        int[] arrays = new int[]{1, 2};

        Exception exception = assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> arrayDemo.getElementAtIndex(index, arrays)
        );
        assertEquals(
                String.format("Index %d out of bounds for length %d", index, arrays.length),
                exception.getMessage()
        );
    }

    @Test
    void giveEmptyArray_thenReturnNoElement() {
        assertEquals("", arrayDemo.getAllElements(new int[] {}));
    }

    @Test
    void giveIntegerArray_thenReturnElements() {
        assertEquals("1, 2, 3", arrayDemo.getAllElements(new int[] {1, 2, 3}));
    }

    @Test
    void giveIntegerValue_whenAddToBeginningArray_thenReturnArrayWithNewElement() {
        int[] input = new int[]{1, 2, 3, 0};
        int[] expected = new int[]{4, 1, 2, 3, 0};

        int[] actual = arrayDemo.addElement(input, 4, 0);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void giveIntegerValue_whenAddToEndArray_thenReturnArrayWithNewElement() {
        int[] input = new int[]{1, 2, 3, 0};
        int[] expected = new int[]{1, 2, 3, 4, 0};

        int[] actual = arrayDemo.addElement(input, 4, 3);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void giveIntegerValue_whenAddToAnyIndex_thenReturnArrayWithNewElement() {
        int[] input = new int[]{1, 2, 3, 0};
        int[] expected = new int[]{1, 4, 2, 3, 0};

        int[] actual = arrayDemo.addElement(input, 4, 1);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void givePositionAtTheBeginningOfArray_whenRemoveFromArray_thenReturnArrayWithoutElementRemoved() {
        int[] input = new int[]{1, 2, 3, 4};
        int[] expected = new int[]{2, 3, 4, 0};

        int[] actual = arrayDemo.removeElement(input, 0);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void givePositionAtTheEndOfArray_whenRemoveFromArray_thenReturnArrayWithoutElementRemoved() {
        int[] input = new int[]{1, 2, 3, 4};
        int[] expected = new int[]{1, 2, 3, 0};

        int[] actual = arrayDemo.removeElement(input, 3);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    void givePositionAtAnyPosition_whenRemoveFromArray_thenReturnArrayWithoutElementRemoved() {
        int[] input = new int[]{1, 2, 3, 4};
        int[] expected = new int[]{1, 3, 4, 0};

        int[] actual = arrayDemo.removeElement(input, 1);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}
