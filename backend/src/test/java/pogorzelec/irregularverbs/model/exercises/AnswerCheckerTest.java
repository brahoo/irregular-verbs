package pogorzelec.irregularverbs.model.exercises;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import pogorzelec.irregularverbs.model.Verb;

@RunWith(SpringRunner.class)
public class AnswerCheckerTest {

    private AnswerChecker answerChecker;

    @Before
    public void setUp() {
        answerChecker = new AnswerChecker();
    }

    @Test
    public void testCheckingCorrectAnswer() {
        Verb testVerb = new Verb("do", "did", "done");
        Answer testAnswer = new Answer("did", "done");

        assertTrue(answerChecker.check(testVerb, testAnswer));
    }

    @Test
    public void testCheckingIncorrectAnswerWithAllWordsWrong() {
        Verb testVerb = new Verb("do", "did", "done");
        Answer testAnswer = new Answer("had", "had");

        assertFalse(answerChecker.check(testVerb,testAnswer));
    }

    @Test
    public void testCheckingIncorrectAnswerWithSecondFormWrong() {
        Verb testVerb = new Verb("do", "did", "done");
        Answer testAnswer = new Answer("had", "done");

        assertFalse(answerChecker.check(testVerb,testAnswer));
    }

    @Test
    public void testCheckingIncorrectAnswerWithThirdFormWrong() {
        Verb testVerb = new Verb("do", "did", "done");
        Answer testAnswer = new Answer("did", "had");

        assertFalse(answerChecker.check(testVerb,testAnswer));
    }

}
