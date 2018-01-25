package pl.piotrbartoszak.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

public class FinanceDetailsView {

    private long id;

    private String name;

    private int year;

    private int month;

    private int day;

    private long value;

    private boolean regulated;

    private String flatName;

    public static FinanceDetailsView fromFinance(Finance finance) {
        FinanceDetailsView financeDetailsView = new FinanceDetailsView();
        financeDetailsView.setId(finance.getId());
        financeDetailsView.setName(finance.getName());
        financeDetailsView.setYear(finance.getYear());
        financeDetailsView.setMonth(finance.getMonth());
        financeDetailsView.setDay(finance.getDay());
        financeDetailsView.setValue(finance.getValue());
        financeDetailsView.setRegulated(finance.isRegulated());

        return financeDetailsView;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public boolean isRegulated() {
        return regulated;
    }

    public void setRegulated(boolean regulated) {
        this.regulated = regulated;
    }

    public String getFlatName() {
        return flatName;
    }

    public void setFlatName(String flatName) {
        this.flatName = flatName;
    }
}
