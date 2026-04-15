package nhannguyenh.datastructures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringDemoTest {
    private StringDemo stringDemo;

    @BeforeEach
    void setup() {
        stringDemo = new StringDemo();
    }

    @AfterEach
    void tearDown() {
        stringDemo = null;
    }

    @Test
    void shouldReturnLength_whenGetLengthOfString() {
        assertEquals(5,  stringDemo.getLengthOfString("Hello"));
    }

    @Test
    void giveChar_shouldReturnIndex_whenCharFoundInString() {
        assertEquals(0, stringDemo.findChar("Hello", 'H'));
    }

    @Test
    void giveChar_shouldReturnMinus1_whenCharNotFoundInString() {
        assertEquals(-1, stringDemo.findChar("Hello", 'h'));
    }
}
