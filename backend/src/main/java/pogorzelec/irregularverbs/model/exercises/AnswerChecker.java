package pogorzelec.irregularverbs.model.exercises;

import pogorzelec.irregularverbs.model.Verb;

public class AnswerChecker {

    public boolean check(Verb verb, Answer answer) {
        return (verb.getSecondForm().equals(answer.getSecondForm()) &&
                verb.getThirdForm().equals(answer.getThirdForm()));
    }

}
