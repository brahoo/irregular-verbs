package pogorzelec.irregularverbs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Verb {

    @Id
    @Column(name = "first_form")
    private String firstForm;

    @Column(name = "second_form")
    private String secondForm;

    @Column(name = "third_form")
    private String thirdForm;

    public Verb() {
    }

    public Verb(String firstForm, String secondForm, String thirdForm) {
        this.firstForm = firstForm;
        this.secondForm = secondForm;
        this.thirdForm = thirdForm;
    }

    public String getFirstForm() {
        return firstForm;
    }

    public void setFirstForm(String firstForm) {
        this.firstForm = firstForm;
    }

    public String getSecondForm() {
        return secondForm;
    }

    public void setSecondForm(String secondForm) {
        this.secondForm = secondForm;
    }

    public String getThirdForm() {
        return thirdForm;
    }

    public void setThirdForm(String thirdForm) {
        this.thirdForm = thirdForm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Verb)) return false;
        Verb verb = (Verb) o;
        return firstForm.equals(verb.firstForm) && secondForm.equals(verb.secondForm) && thirdForm.equals(verb.thirdForm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstForm, secondForm, thirdForm);
    }

    @Override
    public String toString() {
        return firstForm + " " + secondForm + " " + thirdForm;
    }
}
