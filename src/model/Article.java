package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Article implements Model{

    private StringProperty id;
    private StringProperty name;

    public Article(String id, String name){
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
    }

    public Article(String name){
        this.id = new SimpleStringProperty();
        this.name = new SimpleStringProperty(name);
    }

    public Article(){
        id = new SimpleStringProperty();
        name = new SimpleStringProperty();
    }

    public String getId() {
        return id.get();
    }

    public StringProperty getIdProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public String getTableName() {
        return "ARTICLES";
    }

    @Override
    public String getSeqName() {
        return "ISEQ$$_83825";
    }
}
