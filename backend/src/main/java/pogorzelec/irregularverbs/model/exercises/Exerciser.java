package pogorzelec.irregularverbs.model.exercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pogorzelec.irregularverbs.model.Verb;
import pogorzelec.irregularverbs.persistence.database.VerbDatabaseService;

import java.util.Collection;
import java.util.List;

@Component("exerciser")
public class Exerciser {

    @Autowired
    private PracticesGenerator practicesGenerator;

    @Autowired
    private VerbDatabaseService verbDatabaseService;

    @Autowired
    private AnswerChecker answerChecker;

    private Exercise exercise;

    public void createExercise(int quantity) {
        Collection<Verb> verbs = verbDatabaseService.getAll();
        Collection<Practice> practices = practicesGenerator.generate((List<Verb>)verbs, quantity);
        Exercise exercise = new Exercise((List<Practice>)practices);
        this.exercise = exercise;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public boolean checkAnswerAndSetResult(Answer answer) {
        if (answerIsCorrect(answer)) {
            setPositiveResult();
            return true;
        } else {
            return false;
        }
    }

    public void goForward() {
        exercise.setCurrentPracticeOrSetFinished();
    }

    private boolean answerIsCorrect(Answer answer) {
        Practice practice = exercise.getCurrentPractice();
        Verb subject = practice.getSubject();
        return answerChecker.check(subject, answer);
    }

    private void setPositiveResult() {
        exercise.addPoint();
    }
}
