package pogorzelec.irregularverbs.model.exercises;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import pogorzelec.irregularverbs.model.Verb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
public class ExercisesGeneratorTest {

    private ExercisesGenerator exercisesGenerator;
    private List<Verb> testVerbs;

    @Before
    public void setUp() {
        exercisesGenerator = new ExercisesGenerator();
        testVerbs = new ArrayList<>();
        testVerbs.add(new Verb ("do","did", "done"));
        testVerbs.add(new Verb ("be", "was", "been"));
        testVerbs.add(new Verb ("have", "had", "had"));
        testVerbs.add(new Verb ("write","wrote", "written"));
        testVerbs.add(new Verb ("ride", "rode", "ridden"));
        testVerbs.add(new Verb ("shake", "shook", "shaken"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGeneratingFromNullVerbList() {
        exercisesGenerator.generate(null,3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGeneratingFromEmptyVerbList() {
        List<Verb> emptyTestVerbs = new ArrayList<>();
        exercisesGenerator.generate(emptyTestVerbs, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGeneratingZeroQuantity() {
        exercisesGenerator.generate(testVerbs,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGeneratingNegativeQuantity() {
        exercisesGenerator.generate(testVerbs,-1);
    }

    @Test
    public void testQuantityOfGeneratedExercisesIsCorrect() {
        Collection<Exercise> testExercises;
        testExercises = exercisesGenerator.generate(testVerbs, 3);
        
        assertEquals(3, testExercises.size());
    }

    @Test
    public void testGeneratingWithDefaultQuantity() {
        Collection<Exercise> testExercises;
        testExercises = exercisesGenerator.generate(testVerbs);

        assertEquals(1, testExercises.size());
    }

    @Test
    public void testAnotherGenerationIsDifferent() {
        List<Exercise> testExercises = (List<Exercise>) exercisesGenerator.generate(testVerbs,3);
        List<Exercise> anotherExercises = (List<Exercise>) exercisesGenerator.generate(testVerbs,3);

        assertNotEquals(testExercises, anotherExercises);
    }
}
