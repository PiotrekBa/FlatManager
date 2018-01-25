package pl.piotrbartoszak.model;

import java.util.List;

public class MonthlyFinancialSummaryView {
    private List<List<FinanceDetailsView>> finances;

    private int turnover;

    private int maxPossibleTurnover;

    public List<List<FinanceDetailsView>> getFinances() {
        return finances;
    }

    public void setFinances(List<List<FinanceDetailsView>> finances) {
        this.finances = finances;
    }

    public int getTurnover() {
        return turnover;
    }

    public void setTurnover(int turnover) {
        this.turnover = turnover;
    }

    public int getMaxPossibleTurnover() {
        return maxPossibleTurnover;
    }

    public void setMaxPossibleTurnover(int maxPossibleTurnover) {
        this.maxPossibleTurnover = maxPossibleTurnover;
    }
}
