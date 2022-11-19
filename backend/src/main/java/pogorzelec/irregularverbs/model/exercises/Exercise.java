package pogorzelec.irregularverbs.model.exercises;

import pogorzelec.irregularverbs.model.Verb;

import java.util.Objects;

public class Exercise {

    private Verb verb;

    public Exercise(Verb verb) {
        this.verb = verb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exercise)) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(verb, exercise.verb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(verb);
    }
}