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
public class PracticesGeneratorTest {

    private PracticesGenerator practicesGenerator;
    private List<Verb> testVerbs;

    @Before
    public void setUp() {
        practicesGenerator = new PracticesGenerator();
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
        practicesGenerator.generate(null,3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGeneratingFromEmptyVerbList() {
        List<Verb> emptyTestVerbs = new ArrayList<>();
        practicesGenerator.generate(emptyTestVerbs, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGeneratingZeroQuantity() {
        practicesGenerator.generate(testVerbs,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGeneratingNegativeQuantity() {
        practicesGenerator.generate(testVerbs,-1);
    }

    @Test
    public void testQuantityOfGeneratedPracticesIsCorrect() {
        Collection<Practice> testPractices;
        testPractices = practicesGenerator.generate(testVerbs, 3);
        
        assertEquals(3, testPractices.size());
    }

    @Test
    public void testGeneratingWithDefaultQuantity() {
        Collection<Practice> testPractices;
        testPractices = practicesGenerator.generate(testVerbs);

        assertEquals(1, testPractices.size());
    }

    @Test
    public void testAnotherGenerationIsDifferent() {
        List<Practice> testPractices = (List<Practice>) practicesGenerator.generate(testVerbs,3);
        List<Practice> anotherPractices = (List<Practice>) practicesGenerator.generate(testVerbs,3);

        assertNotEquals(testPractices, anotherPractices);
    }

    @Test
    public void testQuantityOfGeneratedPracticesIsCorrectWhenQuantityIsGreaterThanVerbListLength() {
        Collection<Practice> testPractices;
        testPractices = practicesGenerator.generate(testVerbs, 20);

        assertEquals(20, testPractices.size());
    }
}
