package nhannguyenh.leetcode.easies;

import nhannguyenh.leetcodes.easies.MergeStringsAlternately;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeStringsAlternatelyTest {
    private MergeStringsAlternately mergeStringsAlternately;

    @BeforeEach
    void setup() {
        mergeStringsAlternately = new MergeStringsAlternately();
    }

    @AfterEach
    void tearDown() {
        mergeStringsAlternately = null;
    }

    @Test
    void giveWord1LengthEqualsWord2Length_thenReturnMergedString() {
        assertEquals("apbqcr", mergeStringsAlternately.mergeAlternately("abc", "pqr"));
    }

    @Test
    void giveWord1LengthLessThanWord2Length_thenReturnMergedString() {
        assertEquals("apbqrs", mergeStringsAlternately.mergeAlternately("ab", "pqrs"));
    }

    @Test
    void giveWord1LengthGreaterThanWord2Length_thenReturnMergedString() {
        assertEquals("apbqcd", mergeStringsAlternately.mergeAlternately("abcd", "pq"));
    }
}
