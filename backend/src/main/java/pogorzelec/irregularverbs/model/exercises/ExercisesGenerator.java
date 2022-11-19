package pogorzelec.irregularverbs.model.exercises;

import pogorzelec.irregularverbs.model.Verb;
import pogorzelec.irregularverbs.utils.RandomUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExercisesGenerator {

    public Collection<Exercise> generate(List<Verb> verbs, int exerciseQuantity) {
        Collection<Exercise> exercises = new ArrayList<>();

        if (verbs == null) {
            throw new IllegalArgumentException("verbs must be not null");
        }

        if (verbs.isEmpty()) {
            throw new IllegalArgumentException("verbs must be not empty");
        }

        if (exerciseQuantity <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }

        for (int i=0; i<exerciseQuantity; i++) {
            int randomPosition = RandomUtil.getInstance().nextInt(verbs.size());
            Exercise exercise = new Exercise(verbs.get(randomPosition));
            exercises.add(exercise);
        }

        return exercises;
    }

    public Collection<Exercise> generate(List<Verb> verbs) {
        return generate(verbs,1);
    }
}
