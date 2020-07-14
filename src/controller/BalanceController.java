package controller;

import DAO.BalanceDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Balance;

import java.sql.SQLException;

public class BalanceController {

    @FXML
    private TableView<Balance> balanceTable;
    @FXML
    private TableColumn<Balance, Integer> balanceId;
    @FXML
    private TableColumn<Balance, String> balanceDate;
    @FXML
    private TableColumn<Balance, Integer> balanceDebit;
    @FXML
    private TableColumn<Balance, Integer> balanceCredit;
    @FXML
    private TableColumn<Balance, Integer> balanceAmount;
    @FXML
    private TextField textBalanceId;
    @FXML
    private TextField textBalanceCredit;
    @FXML
    private TextField textBalanceDebit;




    @FXML
    private void initialize() throws Exception{
        balanceId.setCellValueFactory(cellDate -> cellDate.getValue().getIdProperty().asObject());
        balanceDebit.setCellValueFactory(cellDate -> cellDate.getValue().getDebitProperty().asObject());
        balanceCredit.setCellValueFactory(cellDate -> cellDate.getValue().getCreditProperty().asObject());
        balanceDate.setCellValueFactory(cellDate -> cellDate.getValue().getDateProperty());
        balanceAmount.setCellValueFactory(cellDate -> cellDate.getValue().getAmountProperty().asObject());
        ObservableList<Balance> balList = BalanceDAO.getAllRecordsBal();
        populateTable(balList);
    }

    private void populateTable(ObservableList<Balance> balList) {
        balanceTable.setItems(balList);
    }

    @FXML
    private void delBalance(ActionEvent event) throws  ClassNotFoundException, SQLException{
        try {
            BalanceDAO.deleteBalanceById(textBalanceId.getText());
            ObservableList<Balance> balList = BalanceDAO.getAllRecordsBal();
            populateTable(balList);
            textBalanceId.clear();
        }catch (SQLException e){
            System.out.println("Error has been occurred while deleting the date " + e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void updateArticle(ActionEvent event) throws ClassNotFoundException,SQLException{
        try {
            BalanceDAO.insertBalance(textBalanceDebit.getText(), textBalanceCredit.getText());
            ObservableList<Balance> balList = BalanceDAO.getAllRecordsBal();
            populateTable(balList);
        }catch (SQLException e){
            System.out.println("Error has been occurred while updating the date " + e);
            e.printStackTrace();
            throw e;
        }
    }
}
