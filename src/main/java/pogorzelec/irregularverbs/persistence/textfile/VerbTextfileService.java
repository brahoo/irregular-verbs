package pogorzelec.irregularverbs.persistence.textfile;

import pogorzelec.irregularverbs.model.Verb;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;

public class VerbTextfileService {

    private String filename;

    public VerbTextfileService(String filename) {
        this.filename = filename;
    }

    public Collection<Verb> getAll() {
        Collection<Verb> verbs = new HashSet<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.filename),"utf-8"));

            String line = null;
            int counter = 1;

            String firstForm = null;
            String secondForm = null;
            String thirdForm = null;

            while((line = reader.readLine()) != null) {
                if (counter == 1) {
                    firstForm = line.trim();
                }
                else if (counter == 2) {
                    secondForm = line.trim();
                }
                else if (counter == 3) {
                    thirdForm = line.trim();
                }
                else {
                    line.trim();
                    verbs.add(new Verb(firstForm, secondForm, thirdForm));
                    counter = 0;
                }
                counter++;
            }
        }catch (IOException e) {
            System.err.format("IOException: %s", e);
        }
        return verbs;
    }
}
