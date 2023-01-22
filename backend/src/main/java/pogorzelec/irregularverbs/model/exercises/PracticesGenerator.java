package pogorzelec.irregularverbs.model.exercises;

import org.springframework.stereotype.Component;
import pogorzelec.irregularverbs.model.Verb;
import pogorzelec.irregularverbs.utils.RandomUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component("practicesGenerator")
public class PracticesGenerator {

    public Collection<Practice> generate(List<Verb> verbs, int practiceQuantity) {
        Collection<Practice> practices = new ArrayList<>();

        if (verbs == null) {
            throw new IllegalArgumentException("verbs must be not null");
        }

        if (verbs.isEmpty()) {
            throw new IllegalArgumentException("verbs must be not empty");
        }

        if (practiceQuantity <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }

        for (int i=0; i<practiceQuantity; i++) {
            int randomPosition = RandomUtil.getInstance().nextInt(verbs.size());
            Practice practice = new Practice(verbs.get(randomPosition));
            practices.add(practice);
        }

        return practices;
    }

    public Collection<Practice> generate(List<Verb> verbs) {
        return generate(verbs,1);
    }
}
