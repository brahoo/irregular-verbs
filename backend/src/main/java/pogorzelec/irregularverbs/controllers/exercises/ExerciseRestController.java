package pogorzelec.irregularverbs.controllers.exercises;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pogorzelec.irregularverbs.model.exercises.Answer;
import pogorzelec.irregularverbs.model.exercises.Exercise;
import pogorzelec.irregularverbs.model.exercises.Exerciser;

@RestController
@RequestMapping("api/exercises")
public class ExerciseRestController {

    @Autowired
    private Exerciser exerciser;

    @GetMapping
    @RequestMapping("/new")
    public ResponseEntity<?> getNew() {
        exerciser.createExercise(5);
        Exercise exercise = exerciser.getExercise();
        return new ResponseEntity<Exercise>(exercise, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?>get() {
        Exercise exercise = exerciser.getExercise();
        return new ResponseEntity<Exercise>(exercise, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> checkAnswer(@RequestBody Answer answer) {
        Boolean response = exerciser.checkAnswerAndSetResult(answer);
        exerciser.goForward();
        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }
}