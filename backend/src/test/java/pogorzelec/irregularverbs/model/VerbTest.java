package pogorzelec.irregularverbs.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class VerbTest {

    Verb testVerb;

    @Before
    public void setUp() {
        testVerb = new Verb("do", "did", "done");
    }

    @Test
    public void testGetFirstForm() {
        assertEquals("do", testVerb.getFirstForm());
    }

    @Test
    public void testGetSecondForm() {
        assertEquals("did", testVerb.getSecondForm());
    }

    @Test
    public void testGetThirdForm() {
        assertEquals("done", testVerb.getThirdForm());
    }

    @Test
    public void testTheSameVerbsAreEqual() {
        Verb anotherTestVerb = new Verb("do", "did", "done");
        assertTrue(anotherTestVerb.equals(testVerb));
    }

    @Test
    public void testDifferentVerbsArentEqual() {
        Verb anotherTestVerb = new Verb("be", "was", "were");
        assertFalse(anotherTestVerb.equals(testVerb));
    }

    @Test
    public void testToString() {
        assertEquals("do did done", testVerb.toString());
    }
}