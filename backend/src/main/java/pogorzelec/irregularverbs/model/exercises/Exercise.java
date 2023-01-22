package pogorzelec.irregularverbs.model.exercises;

import java.util.List;

public class Exercise {

    private List<Practice> practices;
    private int currentPracticeIndex;
    private boolean isFinished;
    private int points;

    public Exercise(List<Practice> practices) {
        this.practices = practices;
        this.currentPracticeIndex = 0;
        this.isFinished = false;
        this.points = 0;
    }

    public Practice getCurrentPractice() {
        return practices.get(currentPracticeIndex);
    }

    public void setCurrentPracticeOrSetFinished() {
        if (isFinished()) {
            throw new IllegalStateException("Exercise is already finished");
        }
        if (isCurrentPracticeIsLast()) {
            this.setFinished(true);
        }
        else {
            setCurrentPracticeFromNext();
        }
    }

    public boolean isFinished() {
        return isFinished;
    }

    public int getPoints() {
        return points;
    }

    public void addPoint() {
        if (isFinished()) {
            throw new IllegalStateException("Exercise must be not completed");
        } else {
            this.points++;
            getCurrentPractice().setPassed(true);
        }
    }

    private boolean isCurrentPracticeIsLast() {
        return currentPracticeIndex >= practices.size()-1;
    }

    private void setFinished(boolean arg) {
        this.isFinished = arg;
    }

    private void setCurrentPracticeFromNext() {
        currentPracticeIndex++;
    }
}