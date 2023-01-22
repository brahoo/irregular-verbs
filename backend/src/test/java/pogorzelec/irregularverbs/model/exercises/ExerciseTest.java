package pogorzelec.irregularverbs.model.exercises;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class ExerciseTest {

    private Exercise exercise;
    private List<Practice> testPractices;
    private Practice testPractice1, testPractice2, testPractice3;

    @Before
    public void setUp() {
        testPractices = new ArrayList<>();
        testPractice1 = mock(Practice.class);
        testPractices.add(testPractice1);
        testPractice2 = mock(Practice.class);
        testPractices.add(testPractice2);
        testPractice3 = mock(Practice.class);
        testPractices.add(testPractice3);

        exercise = new Exercise(testPractices);
    }

    @Test
    public void testGetCurrentPracticeGiveFirstPracticeAtStart() {
        Practice currentPractice = exercise.getCurrentPractice();
        assertEquals(testPractice1, currentPractice);
    }

    @Test
    public void testGetCurrentPracticeGiveTheSamePractice() {
        Practice practice1 = exercise.getCurrentPractice();
        Practice practice2 = exercise.getCurrentPractice();
        assertEquals(practice1, practice2);
    }

    @Test
    public void testSetCurrentPracticeOrSetFinishedWhenNotLast() {
        exercise.setCurrentPracticeOrSetFinished();
        Practice practice = exercise.getCurrentPractice();
        assertEquals(testPractice2,practice);
    }

    @Test
    public void testSetCurrentPracticeOrSetFinishedWhenLast() {
        exercise.setCurrentPracticeOrSetFinished();
        exercise.setCurrentPracticeOrSetFinished();
        exercise.setCurrentPracticeOrSetFinished();
        assertTrue(exercise.isFinished());
    }

    @Test(expected = IllegalStateException.class)
    public void testSetCurrentPracticeOrSetFinishedWhenFinished() {
        exercise.setCurrentPracticeOrSetFinished();
        exercise.setCurrentPracticeOrSetFinished();
        exercise.setCurrentPracticeOrSetFinished();
        exercise.setCurrentPracticeOrSetFinished();
    }

    @Test
    public void testSetPointsInProgress() {
        exercise.addPoint();
        assertEquals(1, exercise.getPoints());
        verify(testPractice1).setPassed(true);
    }

    @Test(expected = IllegalStateException.class)
    public void testSetPointsAfterEnd() {
        exercise.setCurrentPracticeOrSetFinished();
        exercise.setCurrentPracticeOrSetFinished();
        exercise.setCurrentPracticeOrSetFinished();
        exercise.addPoint();
    }

}
