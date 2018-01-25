package pl.piotrbartoszak.model;

public class Turnover {

    private int actualTurnover;
    private int possibleTurnover;

    public Turnover(int actualTurnover, int possibleTurnover) {
        this.actualTurnover = actualTurnover;
        this.possibleTurnover = possibleTurnover;
    }

    public int getActualTurnover() {
        return actualTurnover;
    }

    public void setActualTurnover(int actualTurnover) {
        this.actualTurnover = actualTurnover;
    }

    public int getPossibleTurnover() {
        return possibleTurnover;
    }

    public void setPossibleTurnover(int possibleTurnover) {
        this.possibleTurnover = possibleTurnover;
    }
}
