package pogorzelec.irregularverbs.controllers.exercises;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pogorzelec.irregularverbs.model.exercises.Exercise;
import pogorzelec.irregularverbs.model.exercises.Exerciser;

@RestController
@RequestMapping("api/exercises")
public class ExerciseRestController {

    @Autowired
    private Exerciser exerciser;

    @GetMapping
    public ResponseEntity<?> getNew() {
        exerciser.createExercise(5);
        Exercise exercise = exerciser.getExercise();
        return new ResponseEntity<Exercise>(exercise, HttpStatus.OK);
    }
}