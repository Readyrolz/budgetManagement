package controller;

import DAO.ArticleDAO;
import DAO.OperationDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import model.Article;
import model.Operation;
import java.sql.SQLException;


public class OperationController {

    @FXML
    private TableView<Operation> operationTable;
    @FXML
    private TableColumn<Operation, Integer> operationId;
    @FXML
    private TableColumn<Operation, Integer> operationArticle;
    @FXML
    private TableColumn<Operation, Integer> operationDebit;
    @FXML
    private TableColumn<Operation, Integer> operationCredit;
    @FXML
    private TableColumn<Operation, String> operationDate;
    @FXML
    private ComboBox<Article> articleId;
    @FXML
    private DatePicker textDate;
    @FXML
    private TextField textDebit;
    @FXML
    private TextField textCredit;
    @FXML
    private TextField opId;

    @FXML
    public void initialize() throws Exception{
        operationId.setCellValueFactory(cellDate -> cellDate.getValue().getIdProperty().asObject());
        operationArticle.setCellValueFactory(cellDate -> cellDate.getValue().getArticleIdProperty().asObject());
        operationDebit.setCellValueFactory(cellDate -> cellDate.getValue().getDebitProperty().asObject());
        operationCredit.setCellValueFactory(cellDate -> cellDate.getValue().getCreditProperty().asObject());
        operationDate.setCellValueFactory(cellDate -> cellDate.getValue().getDateProperty());
        ObservableList<Operation> opList = OperationDAO.getAllRecordsOp();

        populateTable(opList);
    }

    private void populateTable(ObservableList<Operation> opList) throws Exception{
        operationTable.setItems(opList);
        ObservableList<Article> artList = ArticleDAO.getAllRecordsAr();
        articleId.setItems(artList);
        articleId.setConverter(new StringConverter<Article>() {
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
    private void insertOperation(ActionEvent event) throws ClassNotFoundException, SQLException, Exception {
        try {
        if (textDate.getValue() == null ){
            OperationDAO.insertOperation(articleId.getValue().getId() ,textDebit.getText(), textCredit.getText());
        } else
            OperationDAO.insertOperation(articleId.getValue().getId() ,textDebit.getText(), textCredit.getText(), textDate.getValue().toString());
        ObservableList<Operation> opList = OperationDAO.getAllRecordsOp();
        populateTable(opList);
        }catch (SQLException e){
            System.out.println("Error has been occurred while insert the date " + e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void delOperation(ActionEvent event) throws  ClassNotFoundException, SQLException, Exception{
        try {
            OperationDAO.deleteOperationById(opId.getText());
            ObservableList<Operation> opList = OperationDAO.getAllRecordsOp();
            populateTable(opList);
            opId.clear();
        }catch (SQLException e){
            System.out.println("Error has been occurred while deleting the date " + e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void updateOperation(ActionEvent event) throws ClassNotFoundException,SQLException, Exception{
        try {
            if(opId.getText().length() != 0){
                if(textDebit.getText().length() != 0)
                    OperationDAO.updateOperation(opId.getText(),textDebit.getText(),"DEBIT");
                if(textCredit.getText().length() != 0)
                    OperationDAO.updateOperation(opId.getText(),textCredit.getText(),"CREDIT");
//                if(articleId.getValue()() != 0)
//                    OperationDAO.updateOperation(opId.getText(), articleId.getValue().getId(), "ARTICLE_ID");
//                if(textDate.getValue() == null)
//                    OperationDAO.updateOperationDate(opId.getText(),textDate.getValue().toString());
            } else return;
            ObservableList<Operation> opList = OperationDAO.getAllRecordsOp();
            populateTable(opList);
        }catch (SQLException e){
            System.out.println("Error has been occurred while updating the date " + e);
            e.printStackTrace();
            throw e;
        }
    }


}
