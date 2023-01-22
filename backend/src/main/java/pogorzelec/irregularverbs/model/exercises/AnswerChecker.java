package pogorzelec.irregularverbs.model.exercises;

import pogorzelec.irregularverbs.model.Verb;
import org.springframework.stereotype.Component;
import pogorzelec.irregularverbs.model.Verb;

@Component("answerChecker")
public class AnswerChecker {

    public boolean check(Verb verb, Answer answer) {
        return (verb.getSecondForm().equals(answer.getSecondForm()) &&
                verb.getThirdForm().equals(answer.getThirdForm()));
    }

}
