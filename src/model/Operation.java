package model;

import javafx.beans.property.*;

public class Operation implements Model{

    private IntegerProperty id;
    private IntegerProperty articleId;
    private IntegerProperty balanceId;
    private IntegerProperty debit;
    private IntegerProperty credit;
    private StringProperty date;

    public Operation(int id, int articleId, int balanceId, int debit, int credit, String date){
        this.id = new SimpleIntegerProperty(id);
        this.articleId = new SimpleIntegerProperty(articleId);
        this.balanceId = new SimpleIntegerProperty(balanceId);
        this.debit = new SimpleIntegerProperty(debit);
        this.credit = new SimpleIntegerProperty(credit);
        this.date = new SimpleStringProperty(date);
    }

    public Operation(int articleId, int balanceId, int debit, int credit, String date){
        this.id = new SimpleIntegerProperty();
        this.articleId = new SimpleIntegerProperty(articleId);
        this.balanceId = new SimpleIntegerProperty(balanceId);
        this.debit = new SimpleIntegerProperty(debit);
        this.credit = new SimpleIntegerProperty(credit);
        this.date = new SimpleStringProperty(date);
    }

    public Operation(int articleId, int debit, int credit,String date){
        this.id = new SimpleIntegerProperty();
        this.articleId = new SimpleIntegerProperty(articleId);
        this.balanceId = new SimpleIntegerProperty();
        this.debit = new SimpleIntegerProperty(debit);
        this.credit = new SimpleIntegerProperty(credit);
        this.date = new SimpleStringProperty(date);
    }

    public Operation(){
        this.id = new SimpleIntegerProperty();
        this.articleId = new SimpleIntegerProperty();
        this.balanceId = new SimpleIntegerProperty();
        this.debit = new SimpleIntegerProperty();
        this.credit = new SimpleIntegerProperty();
        this.date = new SimpleStringProperty();
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty getIdProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getArticleId() { return articleId.get(); }

    public IntegerProperty getArticleIdProperty() {
        return articleId;
    }

    public void setArticleId(int article) {
        this.articleId.set(article);
    }

    public int getBalanceId() {
        return balanceId.get();
    }

    public IntegerProperty getBalanceIdProperty() {
        return balanceId;
    }

    public void setBalanceId(int balanceId) { this.balanceId.set(balanceId); }

    public int getDebit() {
        return debit.get();
    }

    public IntegerProperty getDebitProperty() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit.set(debit);
    }

    public int getCredit() {
        return credit.get();
    }

    public IntegerProperty getCreditProperty() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit.set(credit);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty getDateProperty() {
        return date;
    }

    public void setDate(String date) { this.date.set(date); }

    @Override
    public String getTableName() {
        return "OPERATIONS";
    }

    @Override
    public String getSeqName() { return "ISEQ$$_83828"; }
}
