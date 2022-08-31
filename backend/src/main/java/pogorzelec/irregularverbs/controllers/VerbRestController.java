package pogorzelec.irregularverbs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pogorzelec.irregularverbs.model.Verb;
import pogorzelec.irregularverbs.persistence.database.VerbDatabaseService;

import java.util.Collection;

@RestController
@RequestMapping("/api/verbs")
public class VerbRestController {

    @Autowired
    private VerbDatabaseService verbDatabaseService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        Collection<Verb> verbs = verbDatabaseService.getAll();
        return new ResponseEntity<Collection<Verb>>(verbs, HttpStatus.OK);
    }
}
