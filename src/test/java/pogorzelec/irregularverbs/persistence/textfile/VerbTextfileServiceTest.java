package pogorzelec.irregularverbs.persistence.textfile;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import pogorzelec.irregularverbs.model.Verb;

import java.util.Collection;
import java.util.HashSet;


@RunWith(SpringRunner.class)
public class VerbTextfileServiceTest {

    private VerbTextfileService verbTextfileService = new VerbTextfileService("src/test/resources/verbsfortest.txt");

    @Test
    public void testGetAll() {
        Collection<Verb> testsVerbs = verbTextfileService.getAll();
        Collection<Verb> expectedsVerbs = new HashSet();
        expectedsVerbs.add(new Verb ("do","did", "done"));
        expectedsVerbs.add(new Verb ("be", "was", "been"));
        expectedsVerbs.add(new Verb ("have", "had", "had"));

        assertArrayEquals(expectedsVerbs.toArray(), testsVerbs.toArray());
    }


}