package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Balance implements Model {

    private IntegerProperty id;
    private StringProperty date;
    private IntegerProperty debit;
    private IntegerProperty credit;
    private IntegerProperty amount;

    public Balance(int id, String date, int debit, int credit, int amount) {
        this.id = new SimpleIntegerProperty(id);
        this.date = new SimpleStringProperty(date);
        this.debit = new SimpleIntegerProperty(debit);
        this.credit = new SimpleIntegerProperty(credit);
        this.amount = new SimpleIntegerProperty(amount);
    }

    public Balance(String date, int debit, int credit, int amount) {
        this.id = new SimpleIntegerProperty();
        this.date = new SimpleStringProperty(date);
        this.debit = new SimpleIntegerProperty(debit);
        this.credit = new SimpleIntegerProperty(credit);
        this.amount = new SimpleIntegerProperty(amount);
    }

    public Balance(){
        this.id = new SimpleIntegerProperty();
        this.date = new SimpleStringProperty();
        this.debit = new SimpleIntegerProperty();
        this.credit = new SimpleIntegerProperty();
        this.amount = new SimpleIntegerProperty();
    }


    public int getId(){
        return id.get();
    }

    public IntegerProperty getIdProperty() {
        return id;
    }

    public void setId(int value){
        this.id.set(value);
    }

    public String getDate(){
        return date.get();
    }

    public StringProperty getDateProperty() {
        return date;
    }

    public void setDate(String value){
        this.date.set(value);
    }

    public int getDebit(){
        return debit.get();
    }

    public IntegerProperty getDebitProperty() {
        return debit;
    }

    public void setDebit(int value){
        this.debit.set(value);
    }

    public int getCredit(){
        return credit.get();
    }

    public IntegerProperty getCreditProperty() {
        return credit;
    }

    public void setCredit(int value){
        this.credit.set(value);
    }

    public int getAmount(){
        return amount.get();
    }

    public IntegerProperty getAmountProperty() {
        return amount;
    }

    public void setAmount(int value){
        this.amount.set(value);
    }

    @Override
    public String getTableName() {
        return "Balance";
    }

    @Override
    public String getSeqName() {
        return null;
    }
}
