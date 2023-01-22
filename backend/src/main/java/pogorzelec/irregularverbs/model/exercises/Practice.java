package pogorzelec.irregularverbs.model.exercises;

import pogorzelec.irregularverbs.model.Verb;

import java.util.Objects;

public class Practice {

    private Verb subject;
    private boolean isPassed;

    public Practice(Verb verb) {
        this.subject = verb;
        this.isPassed = false;
    }

    public Verb getSubject() {
        return this.subject;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Practice)) return false;
        Practice practice = (Practice) o;
        return isPassed == practice.isPassed && subject.equals(practice.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, isPassed);
    }
}