package pogorzelec.irregularverbs.model.exercises;

public class Answer {

    private String secondForm;
    private String thirdForm;

    public Answer(String secondForm, String thirdForm) {
        this.secondForm = secondForm;
        this.thirdForm = thirdForm;
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
}
