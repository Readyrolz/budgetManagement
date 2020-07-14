package controller;

import DAO.ArticleDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import model.Article;

import java.sql.SQLException;

public class ArticleController {

    @FXML
    private TableView<Article> articleTab;

    @FXML
    private TableColumn<Article, String> articleId;

    @FXML
    private TableColumn<Article, String> articleName;

    @FXML
    private TextField articleNameField;

    @FXML
    private ComboBox<Article> artId;

    @FXML
    public void initialize() throws Exception{
        articleId.setCellValueFactory(cellDate -> cellDate.getValue().getIdProperty());
        articleName.setCellValueFactory(cellDate -> cellDate.getValue().getNameProperty());
        ObservableList<Article> artList = ArticleDAO.getAllRecordsAr();
        populateTable(artList);
    }

    private void populateTable(ObservableList<Article> artList) {
        articleTab.setItems(artList);
        artId.setItems(artList);
        artId.setConverter(new StringConverter<Article>() {
            @Override
            public String toString(Article object) {
                return object.getId();
            }

            @Override
            public Article fromString(String string) {
                return null;
            }
        });

    }

    @FXML
    private void insertName(ActionEvent event) throws ClassNotFoundException, SQLException{
        if(articleNameField.getText().length() == 0) return;
        ArticleDAO.insertArticle(articleNameField.getText());
        ObservableList<Article> artList = ArticleDAO.getAllRecordsAr();
        populateTable(artList);
    }

    @FXML
    private void updateArticle(ActionEvent event) throws ClassNotFoundException,SQLException{
        try {
            ArticleDAO.updateArticle(artId.getValue().getId(),articleNameField.getText());
            ObservableList<Article> artList = ArticleDAO.getAllRecordsAr();
            populateTable(artList);
        }catch (SQLException e){
            System.out.println("Error has been occurred while updating the date " + e);
            e.printStackTrace();
            throw e;
        }
    }
    @FXML
    private void delArticle(ActionEvent event) throws  ClassNotFoundException, SQLException{
        try {
            ArticleDAO.deleteArtivleById(artId.getValue().getId());
            ObservableList<Article> artList = ArticleDAO.getAllRecordsAr();
            populateTable(artList);
        }catch (SQLException e){
            System.out.println("Error has been occurred while deleting the date " + e);
            e.printStackTrace();
            throw e;
        }
    }
}
