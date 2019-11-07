package test;

import main.AnagramChecker;
import org.junit.Assert;
import org.junit.Test;

class AnagramCheckerTest {
    @Test
    public void test_singleStrings() {
        final boolean expected = true;

        final boolean actual = AnagramChecker.areAnagram("ate", "tea");

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test_stringsWithSpaces() {
        final boolean expected = false;

        final boolean actual = AnagramChecker.areAnagram("hel lo", "ehllo");

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test_withEmptyString() {
        final boolean expected = false;

        final boolean actual = AnagramChecker.areAnagram("table", "");

        Assert.assertEquals(actual, expected);
    }
}